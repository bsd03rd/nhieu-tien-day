/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import Model.Answer;
import com.oracle.wls.shaded.org.apache.xpath.operations.Bool;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author vuman
 */
public class AnswerDAO extends DBContext {

    public ArrayList<Answer> getAnswersOfQuestion(int questionId) {
        ArrayList<Answer> answerlist = new ArrayList<Answer>();
        try ( ResultSet rs = executeQuery("SELECT [AnswerID], [AnswerContent], [isCorrect] FROM [dbo].[Answer] WHERE [QuestionID] = ?", questionId)) {
            while (rs.next()) {
                answerlist.add(new Answer(rs.getInt("AnswerID"), rs.getNString("AnswerContent"), questionId, rs.getBoolean("isCorrect")));
            }

            return answerlist;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addAnswer(Answer answer) {
        try {
            execute("insert into Answer\n"
                    + "values(?, ?, ?)", answer.getAnswerContent(), answer.getQuestionId(), answer.isIsCorrect());
        } catch (Exception e) {
            System.out.println("addAnswer: ");
            e.printStackTrace();
        }
    }

    public ArrayList<Integer> getAnswerListID(int questionID) {
        ArrayList<Integer> answerListID = new ArrayList<>();
        try {
            ResultSet rs = executeQuery("select AnswerID from Answer\n"
                    + "where QuestionID = ?", questionID);
            while (rs.next()) {
                answerListID.add(rs.getInt("AnswerID"));
            }
        } catch (Exception e) {
            System.out.println("getAnswerListID: ");
            e.printStackTrace();
        }
        return answerListID;
    }

    public void updateAnswerByAnswerID(int ansID, String answerValue, boolean answer) {
        try {
            int updateStatus = executeUpdate("update Answer\n"
                    + "set AnswerContent = ?, isCorrect = ?\n"
                    + "where AnswerID = ?", answerValue, answer, ansID);
        } catch (Exception e) {
            System.out.println("updateAnswerByAnswerID: ");
            e.printStackTrace();
        }
    }

    public void deleteAnswer(int i) {
        try {
            int updateStatus = executeUpdate("delete Answer\n"
                    + "where AnswerID = ?", i);
        } catch (Exception e) {
            System.out.println("deleteAnswer: ");
            e.printStackTrace();
        }
    }
    
    public ArrayList<Answer> getAnswersOfQuiz(int quizId) {
        ArrayList<Answer> answerlist = new ArrayList<Answer>();
        try ( ResultSet rs = executeQuery("SELECT [Answer].[AnswerID], [Answer].[AnswerContent], [Answer].[QuestionID], [Answer].[isCorrect] "
                + "FROM [dbo].[Answer], [dbo].[Question] "
                + "WHERE [Answer].[QuestionID] = [Question].[QuestionID] "
                + "AND [Question].[QuizID] = ?", quizId)) {
            while (rs.next()) {
                answerlist.add(new Answer(rs.getInt("AnswerID"), rs.getNString("AnswerContent"), rs.getInt("QuestionID"), rs.getBoolean("isCorrect")));
            }

            return answerlist;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<Answer> getCorrectAnswersOfQuiz(int quizId) {
        ArrayList<Answer> answerlist = new ArrayList<Answer>();
        try ( ResultSet rs = executeQuery("SELECT [Answer].[AnswerID], [Answer].[AnswerContent], [Answer].[QuestionID], [Answer].[isCorrect] "
                + "FROM [dbo].[Answer], [dbo].[Question] "
                + "WHERE [Answer].[QuestionID] = [Question].[QuestionID] "
                + "AND [Question].[QuizID] = ? "
                + "AND [Answer].[isCorrect] = ?", quizId, 1)) {
            while (rs.next()) {
                answerlist.add(new Answer(rs.getInt("AnswerID"), rs.getNString("AnswerContent"), rs.getInt("QuestionID"), true));
            }

            return answerlist;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<Answer> getUserAnswersOfQuiz(int quizId, int userId, Timestamp time) {
        ArrayList<Answer> answerlist = new ArrayList<Answer>();
        try ( ResultSet rs = executeQuery("SELECT [Answer].[AnswerID], [Answer].[AnswerContent], [Answer].[QuestionID], [Answer].[isCorrect] "
                + "FROM [dbo].[Answer], [dbo].[Question], [dbo].[User_Quiz] "
                + "WHERE [Answer].[QuestionID] = [Question].[QuestionID] "
                + "AND [User_Quiz].[ChooseID] = [Answer].[AnswerID] "
                + "AND [Question].[QuizID] = ? "
                + "AND [Answer].[isCorrect] = ? "
                + "AND [User_Quiz].[UserID] = ? "
                + "AND [User_Quiz].[Time] = ?", quizId, 1, userId, time)) {
            while (rs.next()) {
                answerlist.add(new Answer(rs.getInt("AnswerID"), rs.getNString("AnswerContent"), rs.getInt("QuestionID"), true));
            }

            return answerlist;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<Integer> getUserAnswerList(int userId, int userQuizId){
        ArrayList<Integer> list = new ArrayList<Integer>();
        try {
            ResultSet rs = executeQuery("SELECT [AnswerID] FROM [dbo].[User_Answer] WHERE [UserID] = ? AND [UserQuizID] = ?", userId, userQuizId);
            
            while(rs.next()){
                list.add(rs.getInt(1));
            }
            
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
