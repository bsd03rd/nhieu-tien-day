/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import Model.CurrentCourse;
import Model.Lesson;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vuman
 */
public class LessonDAO extends DBContext {

    public LessonDAO() {
    }

    public void addLessonVideo(int sectionId, String lessonName, String videoName, String videoURL, int duration) {
        try {
            execute("EXEC [sp_create_video] ?, ?, ?, ?, ?", sectionId, lessonName, videoName, videoURL, duration);
        } catch (Exception ex) {
            Logger.getLogger(LessonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addLessonDoc(int sectionId, String lessonName, int time, String content) {
        try {
            execute("EXEC [sp_create_docs] ?, ?, ?, ?", sectionId, lessonName, time, content);
        } catch (Exception ex) {
            Logger.getLogger(LessonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addLessonQuiz(Lesson lessonQuiz) {
        try {
            execute("insert into Lesson\n"
                    + "values(?, ?, 0, 'Quiz', ?);", lessonQuiz.getSectionId(), lessonQuiz.getLessonName(), lessonQuiz.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getNewestLessonID(int sectionID) {
        try {
            ResultSet rs = executeQuery("select IDENT_CURRENT('Lesson') from Section\n"
                    + "where Section.SectionID = ?", sectionID);
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void disableLesson(int lessonId) {
        try {
            executeUpdate("UPDATE [dbo].[Lesson] SET [isDisable] = 1 WHERE [LessonID] = ? ", lessonId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Lesson> getAllLessonOfSection(int sectionId) {
        ArrayList<Lesson> lessonlist = new ArrayList<Lesson>();
        try ( ResultSet rs = executeQuery("SELECT [LessonID],"
                + " [LessonName],"
                + " [isDisable],"
                + " [types],"
                + " [Time] FROM [dbo].[Lesson] WHERE [SectionID] = ? AND [isDisable] = 0", sectionId)) {
            while (rs.next()) {
                lessonlist.add(new Lesson(rs.getInt("LessonID"),
                        sectionId,
                        rs.getNString("LessonName"),
                        rs.getBoolean("isDisable"),
                        rs.getString("types"),
                        rs.getInt("Time")));
            }
            return lessonlist;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Lesson> getAllLessonOfUserOFSection(int sectionId, int userID) {
        ArrayList<Lesson> lessonlist = new ArrayList<Lesson>();
        try ( ResultSet rs = executeQuery("SELECT l.[LessonID],\n"
                + "[LessonName],\n"
                + "[isDisable],\n"
                + "[types],\n"
                + "[Time],\n"
                + "ul.Status\n"
                + "FROM [dbo].[Lesson] l\n"
                + "left join \n"
                + "(\n"
                + "select LessonID, Status\n"
                + "from User_Lesson\n"
                + "where UserID = ?\n"
                + ") ul on ul.LessonID = l.LessonID\n"
                + "WHERE [SectionID] = ? AND [isDisable] = 0", userID, sectionId)) {
            while (rs.next()) {
                lessonlist.add(new Lesson(rs.getInt("LessonID"),
                        sectionId,
                        rs.getNString("LessonName"),
                        rs.getBoolean("isDisable"),
                        rs.getString("types"),
                        rs.getInt("Time"),
                        rs.getString("Status")));
            }
            return lessonlist;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Lesson getLessonbyLessonID(int lessonid) {
        try {
            ResultSet rs = executeQuery("SELECT [SectionID]\n"
                    + "      ,[LessonName]\n"
                    + "      ,[isDisable]\n"
                    + "      ,[types]\n"
                    + "      ,[Time]\n"
                    + "      ,[VideoLink]\n"
                    + "      ,[Content]\n"
                    + "  FROM [Lesson] FULL OUTER JOIN [Video]\n"
                    + "  ON [Lesson].[LessonID] = [Video].[LessonID]\n"
                    + "  FULL OUTER JOIN [Docs]\n"
                    + "  ON [Lesson].[LessonID] = [Docs].[LessonID]\n"
                    + "  WHERE [Lesson].[LessonID] = ? AND [isDisable] = 0", lessonid);
            if (rs.next()) {
                return new Lesson(lessonid, rs.getInt("SectionID"),
                        rs.getNString("LessonName"),
                        false, rs.getString("types"), rs.getInt("Time"),
                        rs.getString("VideoLink"), rs.getString("Content"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LessonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void updateLessonVideo(String lessonName, String videoLink, int lessonId, int time) {
        try {
            executeUpdate("UPDATE [dbo].[Lesson] SET [LessonName] = ?, [Time] = ? WHERE [LessonID] = ?", lessonName, time, lessonId);
            executeUpdate("UPDATE [dbo].[Video] SET [VideoLink] = ? WHERE [LessonID] = ?", videoLink, lessonId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateLessonDocs(String lessonName, int time, String docsContent, int lessonId) {
        try {
            executeUpdate("UPDATE [dbo].[Lesson] SET [LessonName] = ?, [Time] = ? WHERE [LessonID] = ?", lessonName, time, lessonId);
            executeUpdate("UPDATE [dbo].[Docs] SET [Content] = ? WHERE [LessonID] = ?", docsContent, lessonId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateLessonQuiz(String lessonName, int time, int lessonId) {
        try {
            executeUpdate("UPDATE [dbo].[Lesson] SET [LessonName] = ?, [Time] = ? WHERE [LessonID] = ?", lessonName, time, lessonId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getQuizID(int lessonID) {
        try {
            ResultSet rs = executeQuery("select Quiz.QuizID from dbo.Lesson, dbo.Quiz\n"
                    + "where Lesson.LessonID = Quiz.LessonID "
                    + "and Lesson.[types] = 'Quiz' "
                    + "and Lesson.LessonID = ?", lessonID);
            while (rs.next()) {
                return rs.getInt("QuizID");
            }
        } catch (Exception ex) {
            System.out.println("getQuizID: " + ex.getMessage());
        }
        return 0;
    }

    public void MarkAs(int lessonID, int userID, String status) {
        execute("INSERT INTO [dbo].[User_Lesson]\n"
                + "           ([UserID]\n"
                + "           ,[LessonID]\n"
                + "           ,[Status])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?)", userID, lessonID, status);
    }

    public int UpdateMarkAs(int lessonID, int userID, String status) {
        return executeUpdate("UPDATE [dbo].[User_Lesson]\n"
                + "   SET [Status] = ?\n"
                + " WHERE [UserID] = ? and [LessonID] = ?", status, userID, lessonID);
    }

    public String getLessonStatusOfUser(int lessonID, int userID) {
        try {
            ResultSet rs = executeQuery("select [Status]\n"
                    + " from [User_Lesson]\n"
                    + " where LessonID = ? and UserID = ?", lessonID, userID);
            if (rs.next()) {
                return rs.getString("Status");
            }
            return null;
        } catch (SQLException ex) {
            return null;
        }
    }

    public Integer getNextLessonInSection(int sectionID, int lessonID) {
        try {
            ResultSet rs = executeQuery("select top 1 l.LessonID from Lesson l\n"
                    + "inner join Section s on l.SectionID = s.SectionID\n"
                    + "where s.SectionID = ? and l.LessonID > ?", sectionID, lessonID);
            if (rs.next()) {
                return rs.getInt("lessonID");
            }
        } catch (SQLException ex) {
            return null;
        }
        return null;
    }

    public Integer getNextSectionOfCourse(int sectionID, int courseID) {
        try {
            ResultSet rs = executeQuery("select top 1 s.SectionID from Lesson l\n"
                    + "inner join Section s on l.SectionID = s.SectionID\n"
                    + "where s.CourseID = ? and s.SectionID > ?", courseID, sectionID);
            if (rs.next()) {
                return rs.getInt("SectionID");
            }
        } catch (SQLException ex) {
            return null;
        }
        return null;
    }

    public Lesson getFirstLessonOfCourse(int courseID) {
        try {
            ResultSet rs = executeQuery("select top 1 LessonID, s.SectionID from Lesson l\n"
                    + "inner join Section s on s.SectionID = l.SectionID\n"
                    + "where s.CourseID = ?\n"
                    + "order by s.SectionID asc, LessonID asc", courseID);
            if (rs.next()) {
                Lesson lesson = new Lesson();
                lesson.setLessonId(rs.getInt("LessonID"));
                lesson.setSectionId(rs.getInt("SectionID"));
                return lesson;
            }
        } catch (SQLException ex) {
            return null;
        }
        return null;
    }

    public CurrentCourse getAllFromLessonID(int lessonID) {
        try {
            ResultSet rs = executeQuery("select l.LessonID, s.SectionID, s.CourseID from Lesson l\n"
                    + "inner join Section s on l.SectionID = s.SectionID\n"
                    + "where l.LessonID = ?", lessonID);
            if (rs.next()) {
                CurrentCourse current = new CurrentCourse(rs.getInt("CourseID"), lessonID, rs.getInt("SectionID"));
                return current;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LessonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
