package dal;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import Model.Answer;
import Model.Course;
import Model.CurrentCourse;
import Model.Docs;
import Model.Feedback;
import Model.Lesson;
import Model.Question;
import Model.Quiz;
import Model.Section;
import Model.User;
import Model.UserCourse;
import Model.Video;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
//import org.apache.tomcat.util.net.SSLHostConfigCertificate;

/**
 *
 */
public class CourseDAO extends DBContext {

    public CourseDAO() {
    }

    public ArrayList<Course> ListAllCourses() {
        ArrayList<Course> courses = new ArrayList<>();
        try {
            String sql = "SELECT \n"
                    + "[C].[CourseName],"
                    + "[C].[DateCreate],"
                    + "[C].[Category],"
                    + "[C].[CourseImage],"
                    + "[C].[Status],"
                    + "[C].[NumberEnrolled],"
                    + "[C].[CourseID],"
                    + "[C].[CoursePrice],"
                    + "[C].[Description],"
                    + "[C].[Objectives],"
                    + "[C].[Difficulty],"
                    + "[C].[AuthorID]"
                    + "FROM [Course] C INNER JOIN [User] U\n"
                    + "ON [C].[AuthorID] = [U].[UserID] WHERE [C].[Status] = 'Enabled'";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Course course = new Course();
                course.setCourseName(rs.getString("CourseName"));
                course.setDateCreate(rs.getTimestamp("DateCreate"));
                course.setCategory(rs.getString("Category"));
                course.setCourseImage(rs.getString("CourseImage"));
                course.setStatus(rs.getString("Status"));
                course.setNumberEnrolled(rs.getInt("NumberEnrolled"));
                course.setCoursePrice(rs.getInt("CoursePrice"));
                course.setCourseID(rs.getInt("CourseID"));
                course.setObjectives(rs.getNString("Objectives"));
                course.setDifficulty(rs.getString("Difficulty"));
                course.setCourseImage(rs.getString("CourseImage"));
                course.setAuthor(new UserDAO().getAllUserInformationByID(rs.getInt("AuthorID")));

                courses.add(course);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return courses;
    }

    public Course getAllCourseInformation(int courseId) {
        try ( ResultSet rs = executeQuery("SELECT [CourseName],"
                + "[DateCreate],"
                + "[AuthorID],"
                + "[Category],"
                + "[NumberEnrolled],"
                + "[CoursePrice],"
                + "[CourseImage],"
                + "[Status],"
                + "[Description],"
                + "[Objectives],"
                + "[Difficulty] FROM [dbo].[Course] WHERE [CourseID] = ?", courseId)) {
            if (rs.next()) {
                return new Course(
                        courseId,
                        rs.getNString("CourseName"),
                        rs.getTimestamp("DateCreate"),
                        rs.getNString("Category"),
                        rs.getInt("NumberEnrolled"),
                        rs.getInt("CoursePrice"),
                        rs.getString("CourseImage"),
                        rs.getString("Status"),
                        new UserDAO().getAllUserInformationByID(rs.getInt("AuthorID")),
                        rs.getNString("Description"),
                        rs.getNString("Objectives"),
                        rs.getString("Difficulty")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Course getCourseInformation(int courseId) {
        try {
            String sql = "SELECT [CourseName],"
                    + "[DateCreate],"
                    + "[AuthorID],"
                    + "[Category],"
                    + "[NumberEnrolled],"
                    + "[CoursePrice],"
                    + "[CourseImage],"
                    + "[Status], "
                    + "[Description], "
                    + "[Objectives],"
                    + "[Difficulty] FROM [dbo].[Course] WHERE [CourseID] = " + courseId;
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            Course c = new Course();
            if (rs.next()) {
                c.setCourseID(courseId);
                c.setCourseName(rs.getNString("CourseName"));
                c.setDateCreate(rs.getTimestamp("DateCreate"));
                c.setAuthor(new UserDAO().getAllUserInformationByID(rs.getInt("AuthorID")));
                c.setCategory(rs.getString("Category"));
                c.setNumberEnrolled(rs.getInt("NumberEnrolled"));
                c.setCoursePrice(rs.getInt("CoursePrice"));
                c.setCourseImage(rs.getString("CourseImage"));
                c.setStatus(rs.getString("Status"));
                c.setDescription(rs.getString("Description"));
                c.setObjectives(rs.getString("Objectives"));
                c.setDifficulty(rs.getString("Difficulty"));
            }
            return c;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void disableCourse(int courseId) {
        try {
            executeUpdate("UPDATE [dbo].[Course] SET [Status] = 'Disabled' WHERE [CourseID] = ? ", courseId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int createClone(int courseId) {
        int newCourseID = 0;
        try {
            Course course = getAllCourseInformation(courseId);
            SectionDAO sd = new SectionDAO();
            LessonDAO ld = new LessonDAO();
            DocsDAO dd = new DocsDAO();
            VideoDAO vd = new VideoDAO();
            QuizDAO qd = new QuizDAO();
            QuestionDAO qtd = new QuestionDAO();
            AnswerDAO ad = new AnswerDAO();

            ArrayList<Section> sectionlist = sd.getAllSectionOfCourse(courseId);

            ResultSet rs = executeQuery("SELECT IDENT_CURRENT('Course')\nINSERT INTO [dbo].[Course] VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);",
                    course.getCourseName(),
                    course.getDateCreate(),
                    course.getAuthor().getUserId(),
                    course.getCategory(),
                    course.getNumberEnrolled(),
                    course.getCoursePrice(),
                    course.getCourseImage(),
                    "Disabled",
                    course.getDescription(),
                    course.getObjectives(),
                    course.getDifficulty());

            if (!rs.next()) {
                return 0;
            }

            newCourseID = rs.getInt(1) + 1;

            for (Section section : sectionlist) {
                rs = executeQuery("SELECT IDENT_CURRENT('Section')\nINSERT INTO [dbo].[Section] VALUES (?, ?, ?);",
                        newCourseID,
                        section.getSectionName(),
                        0);

                if (!rs.next()) {
                    return 0;
                }

                int newSectionID = rs.getInt(1) + 1;

                ArrayList<Lesson> lessonlist = ld.getAllLessonOfSection(section.getSectionId());
                for (Lesson lesson : lessonlist) {
                    rs = executeQuery("SELECT IDENT_CURRENT('Lesson')\nINSERT INTO [dbo].[Lesson] VALUES (?, ?, ?, ?, ?);",
                            newSectionID,
                            lesson.getLessonName(),
                            0,
                            lesson.getType(),
                            lesson.getTime());

                    if (!rs.next()) {
                        return 0;
                    }

                    int newLessonID = rs.getInt(1) + 1;

                    if (lesson.getType().equals("Docs")) {
                        Docs docs = dd.getDocsOfLesson(lesson.getLessonId());
                        executeUpdate("INSERT INTO [dbo].[Docs] VALUES (?, ?)",
                                newLessonID,
                                docs.getContent());
                    }
                    if (lesson.getType().equals("Video")) {
                        Video video = vd.getVideoOfLesson(lesson.getLessonId());
                        executeUpdate("INSERT INTO [dbo].[Video] VALUES (?, ?, ?)",
                                newLessonID,
                                video.getVideoName(),
                                video.getVideoLink());
                    }
                    if (lesson.getType().equals("Quiz")) {
                        Quiz quiz = qd.getQuizOfLesson(lesson.getLessonId());
                        rs = executeQuery("SELECT IDENT_CURRENT('Quiz')\nINSERT INTO [dbo].[Quiz] VALUES (?, ?);",
                                quiz.getMark(),
                                newLessonID);

                        if (!rs.next()) {
                            return 0;
                        }

                        int newQuizId = rs.getInt(1) + 1;

                        ArrayList<Question> questionlist = qtd.getQuestionsOfQuiz(quiz.getQuizId());
                        for (Question question : questionlist) {
                            rs = executeQuery("SELECT IDENT_CURRENT('Question')\nINSERT INTO [dbo].[Question] VALUES (?, ?);",
                                    question.getQuestionContent(),
                                    newQuizId);

                            if (!rs.next()) {
                                return 0;
                            }

                            int newQuestionId = rs.getInt(1) + 1;

                            ArrayList<Answer> answerlist = ad.getAnswersOfQuestion(question.getQuestionId());
                            for (Answer answer : answerlist) {
                                executeUpdate("INSERT INTO [dbo].[Answer] VALUES (?, ?, ?)",
                                        answer.getAnswerContent(),
                                        newQuestionId,
                                        answer.isIsCorrect());
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newCourseID;
    }

    public ArrayList<Course> getAllUserCourse(String username) {
        ArrayList<Course> courseList = new ArrayList<>();
        UserDAO userDao = new UserDAO();
        try {
            ResultSet rs = executeQuery("select c.CourseID, c.CourseName, c.DateCreate, c.AuthorID, c.Category, c.NumberEnrolled, c.CoursePrice, c.CourseImage, uc.Progress\n"
                    + "from [Course] c\n"
                    + "inner join [User_Course] uc on c.CourseID=uc.CourseID\n"
                    + "inner join [User] u on u.UserID = uc.UserID\n"
                    + "where u.Username= ?", username);
            while (rs.next()) {
                Course c = new Course();
                c.setCourseID(rs.getInt("CourseID"));
                c.setCourseName(rs.getString("CourseName"));
                c.setDateCreate(rs.getTimestamp("DateCreate"));
                c.setAuthor(userDao.getAllUserInformationByID(rs.getInt("AuthorID")));
                c.setCategory(rs.getString("Category"));
                c.setNumberEnrolled(rs.getInt("NumberEnrolled"));
                c.setCoursePrice(rs.getInt("CoursePrice"));
                c.setCourseImage(rs.getString("CourseImage"));
                c.setCourseProgress(rs.getDouble("Progress"));
                courseList.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courseList;
    }

    public ArrayList<Course> getAllMentorCourse(int userId) {
        try {
            ArrayList<Course> list = new ArrayList<Course>();
            ResultSet rs = executeQuery("SELECT [CourseID],"
                    + " [CourseName],"
                    + " [DateCreate],"
                    + " [Category],"
                    + " [NumberEnrolled],"
                    + " [CoursePrice],"
                    + " [CourseImage],"
                    + " [Status],"
                    + " [Description],"
                    + " [Objectives],"
                    + " [Difficulty] FROM [Course] WHERE [AuthorID] = ?", userId);

            while (rs.next()) {
                list.add(new Course(rs.getInt("CourseID"),
                        rs.getString("CourseName"),
                        rs.getTimestamp("DateCreate"),
                        rs.getString("Category"),
                        rs.getInt("NumberEnrolled"),
                        rs.getInt("CoursePrice"),
                        rs.getString("CourseImage"),
                        rs.getString("Status"),
                        new UserDAO().getAllUserInformationByID(userId),
                        rs.getNString("Description"),
                        rs.getNString("Objectives"),
                        rs.getString("Difficulty")));
            }

            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Feedback> getFeedBack(int courseID) {
        UserDAO userDAO = new UserDAO();
        ArrayList<Feedback> feedbackList = new ArrayList<>();
        try {
            ResultSet rs = executeQuery("select UserID, CourseRating, CourseFeedback from User_Course\n"
                    + "where CourseID = ? and CourseRating is not null and CourseFeedback is not null", courseID);
            while (rs.next()) {
                Feedback feedback = new Feedback(userDAO.getAllUserInformationByID(rs.getInt("UserID")), rs.getInt("CourseRating"), rs.getString("CourseFeedback"));
                feedbackList.add(feedback);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return feedbackList;
    }

    public void addNewCourse(Course c) {
        try {
            executeUpdate("INSERT INTO [dbo].[Course]\n"
                    + "           ([CourseName]\n"
                    + "           ,[DateCreate]\n"
                    + "           ,[AuthorID]\n"
                    + "           ,[Category]\n"
                    + "           ,[NumberEnrolled]\n"
                    + "           ,[CoursePrice]\n"
                    + "           ,[CourseImage]\n"
                    + "           ,[Status]\n"
                    + "           ,[Description]\n"
                    + "           ,[Objectives]\n"
                    + "           ,[Difficulty])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)",
                    c.getCourseName(), c.getDateCreate(), c.getAuthor().getUserId(),
                    c.getCategory(), c.getNumberEnrolled(), c.getCoursePrice(),
                    c.getCourseImage(), c.getStatus(), c.getDescription(), c.getObjectives(), c.getDifficulty());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getNewCourseID() {
        int id = 0;
        try {
            ResultSet rs = executeQuery("SELECT IDENT_CURRENT('Course')");
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return id;
    }

    public int getCourseTime(int courseID) {
        try {
            ResultSet rs = executeQuery("select SUM(Time) as totalTime from Lesson l\n"
                    + "inner join Section s on s.SectionID = l.SectionID\n"
                    + "where s.CourseID = ?", courseID);
            if (rs.next()) {
                return rs.getInt("totalTime");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public UserCourse getUserCourseInformation(int courseId, int userId) {
        try ( ResultSet rs = executeQuery("SELECT * FROM [User_Course] WHERE CourseID = ? AND UserID = ?", courseId, userId)) {

            if (rs.next()) {
                int userID = rs.getInt("UserID");
                int courseID = rs.getInt("CourseID");
                boolean isStudied = rs.getBoolean("isStudied");
                int courseRating = rs.getInt("CourseRating");
                String CourseFeedback = rs.getNString("CourseFeedback");
                double Progress = rs.getDouble("Progress");
                Date Paydate = rs.getDate("Paydate");
                boolean isFavourite = rs.getBoolean("isFavourite");

                return new UserCourse(userID, courseID, isStudied, courseRating, CourseFeedback, Progress, Paydate, isFavourite);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insertNewObjective(String objective, int courseId) {
        try {
            executeUpdate("UPDATE [dbo].[Course] SET [Objectives] = CONCAT([Objectives], ?) WHERE [CourseID] = ?", "/" + objective, courseId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateSaveChangesCourse(int courseId, String courseName, String description, String image, String category, String status, double price) {
        try {
            executeUpdate("UPDATE [dbo].[Course] SET [CourseName] = ?,"
                    + " [Description] = ?,"
                    + " [CourseImage] = ?,"
                    + " [Category] = ?,"
                    + " [Status] = ?,"
                    + " [CoursePrice] = ? WHERE [CourseID] = ?", courseName, description, image, category, status, price, courseId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CurrentCourse getCurrentCourse(int courseID, int userID) {
        try {
            ResultSet rs = executeQuery("select top 1 CourseID, l.LessonID, s.SectionID\n"
                    + "from User_Lesson ul\n"
                    + "inner join Lesson l on l.LessonID = ul.LessonID\n"
                    + "inner join Section s on s.SectionID = l.SectionID\n"
                    + "where s.CourseID = ? and ul.UserID = ? and [Status] = 'Study'\n"
                    + "order by ul.LessonID desc", courseID, userID);
            if (rs.next()) {
                CurrentCourse course = new CurrentCourse(rs.getInt("CourseID"), rs.getInt("LessonID"), rs.getInt("SectionID"));
                return course;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void enableCourse(int courseId) {
        try {
            executeUpdate("UPDATE [dbo].[Course] SET [Status] = ? WHERE [CourseID] = ?", "Enabled", courseId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getMentorNumberOfCourse(int authorId) {
        int count = 0;
        try {
            ResultSet rs = executeQuery("SELECT COUNT(1) AS Total FROM [dbo].[Course] WHERE [AuthorID] =  ?", authorId);

            if (rs.next()) {
                count = rs.getInt("Total");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public int getMentorNumberOfStudent(int authorId) {
        int count = 0;
        try {
            ResultSet rs = executeQuery("SELECT COUNT(1) AS Total FROM [dbo].[Course] C, [dbo].[User_Course] UC WHERE [AuthorID] =  ? AND C.[CourseID] = UC.[CourseID] AND UC.[isStudied] = ?", authorId, 1);

            if (rs.next()) {
                count = rs.getInt("Total");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public int getMentorNumberOfBlog(int authorId) {
        int count = 0;
        try {
            ResultSet rs = executeQuery("SELECT COUNT(1) AS Total FROM [dbo].[Blog] WHERE [UserID] =  ?", authorId);

            if (rs.next()) {
                count = rs.getInt("Total");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public int getMentorNumberOfQuiz(int authorId) {
        int count = 0;
        try {
            ResultSet rs = executeQuery("select COUNT(*) as Total from Quiz q\n"
                    + "inner join Lesson l on l.LessonID = q.LessonID\n"
                    + "inner join Section s on s.SectionID = l.SectionID\n"
                    + "inner join Course c on c.CourseID = s.SectionID\n"
                    + "where c.AuthorID = ? ", authorId);

            if (rs.next()) {
                count = rs.getInt("Total");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public ArrayList<Course> getPendingCourse() {
        ArrayList<Course> coursePendingList = new ArrayList<>();
        UserDAO udao = new UserDAO();
        try {
            ResultSet rs = executeQuery("SELECT [CourseID]\n"
                    + "      ,[CourseName]\n"
                    + "      ,[DateCreate]\n"
                    + "      ,[AuthorID]\n"
                    + "      ,[Category]\n"
                    + "      ,[NumberEnrolled]\n"
                    + "      ,[CoursePrice]\n"
                    + "      ,[CourseImage]\n"
                    + "      ,[Status]\n"
                    + "      ,[Description]\n"
                    + "      ,[Objectives]\n"
                    + "      ,[Difficulty]\n"
                    + "  FROM [dbo].[Course]\n"
                    + "  where [Status] ='pending'");
            while (rs.next()) {
                coursePendingList.add(new Course(rs.getInt("CourseID"),
                        rs.getNString("CourseName"), rs.getTimestamp("DateCreate"),
                        rs.getString("Category"), rs.getInt("NumberEnrolled"),
                        rs.getInt("CoursePrice"), rs.getString("CourseImage"),
                        rs.getString("Status"),
                        udao.getAllUserInformationByID(rs.getInt("AuthorID")),
                        0, rs.getNString("Description"), rs.getNString("Objectives"), rs.getString("Difficulty")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return coursePendingList;
    }
    
     public ArrayList<Course> getPendingCourseByCourseName(String courseName) {
        ArrayList<Course> coursePendingList = new ArrayList<>();
        UserDAO udao = new UserDAO();
        try {
            ResultSet rs = executeQuery("SELECT [CourseID]\n"
                    + "      ,[CourseName]\n"
                    + "      ,[DateCreate]\n"
                    + "      ,[AuthorID]\n"
                    + "      ,[Category]\n"
                    + "      ,[NumberEnrolled]\n"
                    + "      ,[CoursePrice]\n"
                    + "      ,[CourseImage]\n"
                    + "      ,[Status]\n"
                    + "      ,[Description]\n"
                    + "      ,[Objectives]\n"
                    + "      ,[Difficulty]\n"
                    + "  FROM [dbo].[Course]\n"
                    + "  where [Status] = 'pending' AND [CourseName] LIKE '%" +courseName +"%'");
            while (rs.next()) {
                coursePendingList.add(new Course(rs.getInt("CourseID"),
                        rs.getNString("CourseName"), rs.getTimestamp("DateCreate"),
                        rs.getString("Category"), rs.getInt("NumberEnrolled"),
                        rs.getInt("CoursePrice"), rs.getString("CourseImage"),
                        rs.getString("Status"),
                        udao.getAllUserInformationByID(rs.getInt("AuthorID")),
                        0, rs.getNString("Description"), rs.getNString("Objectives"), rs.getString("Difficulty")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return coursePendingList;
    }

    public void updateCourseStatus(int courseID, String Status) {
        try {
            int updateStatus = executeUpdate("update Course\n"
                    + "set [Status] = ?\n"
                    + "where [CourseID] = ?", Status, courseID);
            if (updateStatus > 0) {
                System.out.println("Update success");
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Course> getAllCourse() {
        ArrayList<Course> allCourse = new ArrayList<>();
        UserDAO udao = new UserDAO();
        try {
            ResultSet rs = executeQuery("SELECT [CourseID]\n"
                    + "      ,[CourseName]\n"
                    + "      ,[DateCreate]\n"
                    + "      ,[AuthorID]\n"
                    + "      ,[Category]\n"
                    + "      ,[NumberEnrolled]\n"
                    + "      ,[CoursePrice]\n"
                    + "      ,[CourseImage]\n"
                    + "      ,[Status]\n"
                    + "      ,[Description]\n"
                    + "      ,[Objectives]\n"
                    + "      ,[Difficulty]\n"
                    + "  FROM [dbo].[Course]");
            while (rs.next()) {
                allCourse.add(new Course(rs.getInt("CourseID"),
                        rs.getNString("CourseName"), rs.getTimestamp("DateCreate"),
                        rs.getString("Category"), rs.getInt("NumberEnrolled"),
                        rs.getInt("CoursePrice"), rs.getString("CourseImage"),
                        rs.getString("Status"),
                        udao.getAllUserInformationByID(rs.getInt("AuthorID")),
                        0, rs.getNString("Description"), rs.getNString("Objectives"), rs.getString("Difficulty")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allCourse;
    }

    public ArrayList<Course> getAllCourseByCourseName(String courseName) {
        ArrayList<Course> allCourse = new ArrayList<>();
        UserDAO udao = new UserDAO();
        try {
            ResultSet rs = executeQuery("SELECT [CourseID]\n"
                    + "      ,[CourseName]\n"
                    + "      ,[DateCreate]\n"
                    + "      ,[AuthorID]\n"
                    + "      ,[Category]\n"
                    + "      ,[NumberEnrolled]\n"
                    + "      ,[CoursePrice]\n"
                    + "      ,[CourseImage]\n"
                    + "      ,[Status]\n"
                    + "      ,[Description]\n"
                    + "      ,[Objectives]\n"
                    + "      ,[Difficulty]\n"
                    + "  FROM [dbo].[Course] WHERE [CourseName] LIKE '%" + courseName+ "%'");
            while (rs.next()) {
                allCourse.add(new Course(rs.getInt("CourseID"),
                        rs.getNString("CourseName"), rs.getTimestamp("DateCreate"),
                        rs.getString("Category"), rs.getInt("NumberEnrolled"),
                        rs.getInt("CoursePrice"), rs.getString("CourseImage"),
                        rs.getString("Status"),
                        udao.getAllUserInformationByID(rs.getInt("AuthorID")),
                        0, rs.getNString("Description"), rs.getNString("Objectives"), rs.getString("Difficulty")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allCourse;
    }
    
    public ArrayList<UserCourse> getListUserCourseOfUser(int userId, String courseName) {
        ArrayList<UserCourse> list = new ArrayList<UserCourse>();
        try {
            ResultSet rs = executeQuery("SELECT [uc].[CourseID], [uc].[isStudied], [uc].[CourseRating], [uc].[CourseFeedback], [uc].[Progress], [uc].[Paydate], [uc].[isFavourite] FROM [dbo].[User_Course] uc INNER JOIN [Course] c ON [uc].[CourseID] = [c].[CourseID] WHERE [uc].[UserID] =" + userId
                    + "AND [c].[CourseName] LIKE N'%" + courseName + "%'");
            while (rs.next()) {
                list.add(new UserCourse(userId, rs.getInt("CourseID"), rs.getBoolean("isStudied"), rs.getInt("CourseRating"), rs.getString("CourseFeedback"), rs.getDouble("Progress"), rs.getDate("Paydate"), rs.getBoolean("isFavourite")));
            }

            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void UpdateNumberEnrolledCourse(int courseId) {
        try {
            executeUpdate("UPDATE [Course] SET [NumberEnrolled] += 1 WHERE [CourseID] = ?", courseId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Feedback> getFeedbackByPage(ArrayList<Feedback> listAllFeedback, int startIndex, int endIndex) {
        ArrayList<Feedback> listFeedback = new ArrayList<>();
        for (int i = startIndex; i < endIndex; i++) {
            listFeedback.add(listAllFeedback.get(i));
        }

        return listFeedback;
    }

    public ArrayList<Course> getAllCoursesByCourseName(String courseName) {
        ArrayList<Course> courseList = new ArrayList<>();
        try ( ResultSet rs = executeQuery("SELECT \n"
                + "[C].[CourseName],"
                + "[C].[DateCreate],"
                + "[C].[Category],"
                + "[C].[CourseImage],"
                + "[C].[Status],"
                + "[C].[NumberEnrolled],"
                + "[C].[CourseID],"
                + "[C].[CoursePrice],"
                + "[C].[Description],"
                + "[C].[Objectives],"
                + "[C].[Difficulty],"
                + "[C].[AuthorID]"
                + "FROM [Course] C INNER JOIN [User] U\n"
                + "ON [C].[AuthorID] = [U].[UserID] WHERE [C].[Status] = 'Enabled' AND ([C].[CourseName] LIKE  N'%" + courseName + "%'  OR [U].[FirstName] LIKE N'%" + courseName +"%')")) {
            while (rs.next()) {
                Course course = new Course();
                course.setCourseName(rs.getString("CourseName"));
                course.setDateCreate(rs.getTimestamp("DateCreate"));
                course.setCategory(rs.getString("Category"));
                course.setCourseImage(rs.getString("CourseImage"));
                course.setStatus(rs.getString("Status"));
                course.setNumberEnrolled(rs.getInt("NumberEnrolled"));
                course.setCoursePrice(rs.getInt("CoursePrice"));
                course.setCourseID(rs.getInt("CourseID"));
                course.setObjectives(rs.getNString("Objectives"));
                course.setDifficulty(rs.getString("Difficulty"));
                course.setCourseImage(rs.getString("CourseImage"));
                course.setAuthor(new UserDAO().getAllUserInformationByID(rs.getInt("AuthorID")));

                courseList.add(course);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courseList;
    }
    public ArrayList<Course> getAllCoursesByTime(String courseName,String ordertime) {
        ArrayList<Course> courseList = new ArrayList<>();
        try ( ResultSet rs = executeQuery("SELECT \n"
                + "[C].[CourseName],"
                + "[C].[DateCreate],"
                + "[C].[Category],"
                + "[C].[CourseImage],"
                + "[C].[Status],"
                + "[C].[NumberEnrolled],"
                + "[C].[CourseID],"
                + "[C].[CoursePrice],"
                + "[C].[Description],"
                + "[C].[Objectives],"
                + "[C].[Difficulty],"
                + "[C].[AuthorID]"
                + "FROM [Course] C INNER JOIN [User] U\n"
                + "ON [C].[AuthorID] = [U].[UserID] WHERE [C].[Status] = 'Enabled' AND ([C].[CourseName] LIKE  N'%" + courseName + "%' OR [U].[FirstName] LIKE N'%" + courseName +"%')"
                +"order by DateCreate  "+ordertime
        )) {
            while (rs.next()) {
                Course course = new Course();
                course.setCourseName(rs.getString("CourseName"));
                course.setDateCreate(rs.getTimestamp("DateCreate"));
                course.setCategory(rs.getString("Category"));
                course.setCourseImage(rs.getString("CourseImage"));
                course.setStatus(rs.getString("Status"));
                course.setNumberEnrolled(rs.getInt("NumberEnrolled"));
                course.setCoursePrice(rs.getInt("CoursePrice"));
                course.setCourseID(rs.getInt("CourseID"));
                course.setObjectives(rs.getNString("Objectives"));
                course.setDifficulty(rs.getString("Difficulty"));
                course.setCourseImage(rs.getString("CourseImage"));
                course.setAuthor(new UserDAO().getAllUserInformationByID(rs.getInt("AuthorID")));

                courseList.add(course);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courseList;
    }
    public static void main(String[] args) {
        new CourseDAO().getAllCourseByCourseName("");
        System.err.println(new CourseDAO().getAllCoursesByTime("","ASC").size());
    }
    
    
    

    public ArrayList<Course> getAllFavouriteCoursesByCourseName(String courseName) {
        ArrayList<Course> courseList = new ArrayList<>();
        try ( ResultSet rs = executeQuery("SELECT \n"
                + "[C].[CourseName],"
                + "[C].[DateCreate],"
                + "[C].[Category],"
                + "[C].[CourseImage],"
                + "[C].[Status],"
                + "[C].[NumberEnrolled],"
                + "[C].[CourseID],"
                + "[C].[CoursePrice],"
                + "[C].[Description],"
                + "[C].[Objectives],"
                + "[C].[Difficulty],"
                + "[C].[AuthorID]"
                + "FROM [User_Course] C\n"
                + "WHERE[isFavourite] = 1 AND [CourseName] LIKE  '%" + courseName + "%'")) {
            while (rs.next()) {
                Course course = new Course();
                course.setCourseName(rs.getString("CourseName"));
                course.setDateCreate(rs.getTimestamp("DateCreate"));
                course.setCategory(rs.getString("Category"));
                course.setCourseImage(rs.getString("CourseImage"));
                course.setStatus(rs.getString("Status"));
                course.setNumberEnrolled(rs.getInt("NumberEnrolled"));
                course.setCoursePrice(rs.getInt("CoursePrice"));
                course.setCourseID(rs.getInt("CourseID"));
                course.setObjectives(rs.getNString("Objectives"));
                course.setDifficulty(rs.getString("Difficulty"));
                course.setCourseImage(rs.getString("CourseImage"));
                course.setAuthor(new UserDAO().getAllUserInformationByID(rs.getInt("AuthorID")));

                courseList.add(course);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courseList;
    }
    
    public ArrayList<Course> getAllMentorCourseByID(int userId) {
        try {
            ArrayList<Course> list = new ArrayList<Course>();
            ResultSet rs = executeQuery("SELECT [CourseID],"
                    + " [CourseName],"
                    + " [DateCreate],"
                    + " [Category],"
                    + " [NumberEnrolled],"
                    + " [CoursePrice],"
                    + " [CourseImage],"
                    + " [Status],"
                    + " [Description],"
                    + " [Objectives],"
                    + " [Difficulty] FROM [Course] WHERE [AuthorID] = ? AND [Status] = 'Enabled'", userId);

            while (rs.next()) {
                list.add(new Course(rs.getInt("CourseID"),
                        rs.getString("CourseName"),
                        rs.getTimestamp("DateCreate"),
                        rs.getString("Category"),
                        rs.getInt("NumberEnrolled"),
                        rs.getInt("CoursePrice"),
                        rs.getString("CourseImage"),
                        rs.getString("Status"),
                        new UserDAO().getAllUserInformationByID(userId),
                        rs.getNString("Description"),
                        rs.getNString("Objectives"),
                        rs.getString("Difficulty")));
            }

            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

//SQL for getCurrentCourse
//select top 10 *
//from User_Lesson ul
//inner join Lesson l on l.LessonID = ul.LessonID
//inner join Section s on s.SectionID = l.SectionID
//where s.CourseID = 5 and ul.UserID = 10 
//order by ul.LessonID desc
