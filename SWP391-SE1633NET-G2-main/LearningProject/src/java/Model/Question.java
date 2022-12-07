/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author vuman
 */
public class Question {
    private int questionId;
    private String questionContent;
    private int quizId;
    private ArrayList<Answer> answers;
    
    public Question() {
    }

    public Question(int questionId, String questionContent, int quizId) {
        this.questionId = questionId;
        this.questionContent = questionContent;
        this.quizId = quizId;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }

    public Question(int questionId, String questionContent, int quizId, ArrayList<Answer> answers) {
        this.questionId = questionId;
        this.questionContent = questionContent;
        this.quizId = quizId;
        this.answers = answers;
    }
    
    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }
    
    
}
