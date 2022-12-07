/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import Model.Answer;
import Model.CurrentCourse;
import Model.Question;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vuman
 */
public class QuestionDAO extends DBContext {

    public ArrayList<Question> getQuestionsOfQuiz(int quizId) {
        ArrayList<Question> questionlist = new ArrayList<Question>();
        try ( ResultSet rs = executeQuery("SELECT [QuestionID], [QuestionContent] FROM [dbo].[Question] WHERE [QuizID] = ?", quizId)) {
            while (rs.next()) {
                questionlist.add(new Question(rs.getInt("QuestionID"), rs.getNString("QuestionContent"), quizId));
            }
            return questionlist;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public CurrentCourse getDetailFromQuiz(int quizid) {
        try {
            ResultSet rs = executeQuery("select l.LessonID, s.SectionID, s.CourseID from Quiz q\n"
                    + "inner join Lesson l on q.LessonID= l.LessonID\n"
                    + "inner join Section s on s.SectionID = l.SectionID\n"
                    + "where QuizID = ?", quizid);
            if (rs.next()) {
                CurrentCourse current = new CurrentCourse(rs.getInt("CourseID"), rs.getInt("LessonID"), rs.getInt("SectionID"));
                return current;
            }
        } catch (SQLException ex) {
            return new CurrentCourse();
        }
        return new CurrentCourse();
    }

    public boolean isThereAnyQuestions() {
        try ( ResultSet rs = executeQuery("SELECT [QuestionID], [QuestionContent] FROM [dbo].[Question]")) {
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Question getQuestionAndAnswer(int questionID) {
        Question q = new Question();
        try {
            ResultSet rs = executeQuery("select q.QuestionID, q.QuestionContent,a.AnswerContent, a.isCorrect from dbo.Question q\n"
                    + "join Answer a on q.QuestionID = a.QuestionID\n"
                    + "where q.QuestionID = ?", questionID);
            ArrayList<Answer> answers = new ArrayList<>();
            boolean status = false;
            while (rs.next()) {
                if (status == false) {
                    q.setQuestionId(rs.getInt("QuestionID"));
                    q.setQuestionContent(rs.getString("QuestionContent"));
                    status = true;
                }
                answers.add(new Answer(0, rs.getString("AnswerContent"), 0, rs.getBoolean("isCorrect")));
            }
            q.setAnswers(answers);
        } catch (Exception e) {
            System.out.println("getQuestionAndAnswer: ");
            e.printStackTrace();
        }
        return q;
    }

    public int addQuestion(Question question) {
        try {
            ResultSet rs = executeQuery("SELECT IDENT_CURRENT('Question')\n"
                    + "insert into Question\n"
                    + "values(?, ?) ", question.getQuestionContent(), question.getQuizId());
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("addQuestion: ");
            e.printStackTrace();
        }
        return -1;
    }

    public void deleteQuestion(int quesitonID) {
        try {
            int deleteStatus = executeUpdate("delete Answer\n"
                    + "where QuestionID = ?\n"
                    + "delete Question\n"
                    + "where QuestionID = ?", quesitonID, quesitonID);
            if (deleteStatus > 0) {
                System.out.println("deleteQuestion: Delete Success");
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("deleteQuestion: ");
            e.printStackTrace();
        }
    }

    public ArrayList<Integer> getListQuestionID(int quizID) {
        ArrayList<Integer> listQuestionID = new ArrayList<>();
        try {
            ResultSet rs = executeQuery("select QuestionID from Question\n"
                    + "where QuizID = ?", quizID);
            while (rs.next()) {
                listQuestionID.add(rs.getInt("QuestionID"));
            }
        } catch (Exception e) {
            System.out.println("getListQuestionID: ");
            e.printStackTrace();
        }
        return listQuestionID;
    }

    public void updateQuestionByQuestionID(int qID, String QuestionContent) {
        try {
            int updateStatus = executeUpdate("update Question\n"
                    + "set QuestionContent = ?\n"
                    + "where QuestionID = ?", qID, QuestionContent);
        } catch (Exception e) {
        }
    }

    public ArrayList<Answer> getAnswersbyQuestionID(int questionid) {
        ArrayList<Answer> answers = new ArrayList<>();
        try {
            ResultSet rs = executeQuery("SELECT \n"
                    + "	[AnswerID],\n"
                    + "	[AnswerContent]\n"
                    + "FROM \n"
                    + "[Quiz] QU INNER JOIN [Question] QT\n"
                    + "ON QU.QuizID = QT.QuizID\n"
                    + "INNER JOIN [Answer] A\n"
                    + "ON QT.QuestionID = A.QuestionID\n"
                    + "WHERE QT.QuestionID = ?", questionid);
            while (rs.next()) {
                Answer a = new Answer();
                a.setAnswerId(rs.getInt("AnswerID"));
                a.setAnswerContent(rs.getNString("AnswerContent"));
                answers.add(a);
            }
            return answers;
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Question getQuestionByQuestionID(int questionid) {
        try {
            ResultSet rs = executeQuery("SELECT [QuestionContent]\n"
                    + "FROM [Question]\n"
                    + "WHERE [QuestionID] = ?", questionid);
            if (rs.next()) {
                Question q = new Question();
                q.setQuestionContent(rs.getNString("QuestionContent"));
                return q;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Question getFirstQuestion(int lessonid) {
        try {
            ResultSet rs = executeQuery("SELECT TOP 1\n"
                    + "	QU.[QuestionID],\n"
                    + "	QU.[QuestionContent]\n"
                    + "FROM\n"
                    + "[Lesson] L FULL OUTER JOIN [Quiz] Q\n"
                    + "ON L.LessonID = Q.LessonID\n"
                    + "FULL OUTER JOIN [Question] QU\n"
                    + "ON Q.QuizID = QU.QuizID\n"
                    + "WHERE types = 'Quiz' AND Q.LessonID = ? AND L.isDisable = 0\n"
                    + "ORDER BY QU.[QuestionID] ASC", lessonid);
            if (rs.next()) {
                Question question = new Question();
                question.setQuestionId(rs.getInt("QuestionID"));
                question.setQuestionContent(rs.getNString("QuestionContent"));
                return question;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Question getNextQuestion(int lessonid, int questionid) {
        try {
            ResultSet rs = executeQuery("SELECT TOP 1\n"
                    + "	QU.[QuestionID],\n"
                    + "	QU.[QuestionContent]\n"
                    + "FROM\n"
                    + "[Lesson] L FULL OUTER JOIN [Quiz] Q\n"
                    + "ON L.LessonID = Q.LessonID\n"
                    + "FULL OUTER JOIN [Question] QU\n"
                    + "ON Q.QuizID = QU.QuizID\n"
                    + "WHERE types = 'Quiz' AND Q.LessonID = ? \n"
                    + "AND L.isDisable = 0 AND QU.QuestionID > ?\n"
                    + "ORDER BY QU.[QuestionID] ASC", lessonid, questionid);
            if (rs.next()) {
                Question question = new Question();
                question.setQuestionId(rs.getInt("QuestionID"));
                question.setQuestionContent(rs.getNString("QuestionContent"));
                return question;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int getNumberQuestionOfQuiz(int lessonid) {
        try {
            ResultSet rs = executeQuery("WITH T AS (SELECT DISTINCT A.QuestionID FROM\n"
                    + "[Quiz] QU INNER JOIN [Question] QT\n"
                    + "ON QU.QuizID = QT.QuizID\n"
                    + "INNER JOIN [Answer] A\n"
                    + "ON QT.QuestionID = A.QuestionID\n"
                    + "WHERE LessonID = ?\n"
                    + "GROUP BY A.QuestionID)\n"
                    + "SELECT COUNT(*) FROM T", lessonid);
            if (rs.next()) {
                int num = rs.getInt(1);
                return num;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int getNumberQuesOfQuiz(int quizId) {
        try {
            ResultSet rs = executeQuery("SELECT COUNT(1) FROM [dbo].[Question] WHERE [QuizID] = ?", quizId);

            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
