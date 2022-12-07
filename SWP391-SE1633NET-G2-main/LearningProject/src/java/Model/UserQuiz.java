/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author vuman
 */
public class UserQuiz {
    private int userQuizId;
    private int userId;
    private int quizId;
    private int correctAmount;
    private double mark;
    private String time;

    public UserQuiz() {
    }

    public UserQuiz(int userQuizId, int userId, int quizId, int correctAmount, double mark, String time) {
        this.userQuizId = userQuizId;
        this.userId = userId;
        this.quizId = quizId;
        this.correctAmount = correctAmount;
        this.mark = mark;
        this.time = time;
    }

    public int getUserQuizId() {
        return userQuizId;
    }

    public void setUserQuizId(int userQuizId) {
        this.userQuizId = userQuizId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public int getCorrectAmount() {
        return correctAmount;
    }

    public void setCorrectAmount(int correctAmount) {
        this.correctAmount = correctAmount;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    
}
