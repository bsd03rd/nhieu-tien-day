/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author NamDepTraiVL
 */
public class QuizDetail {

    private int quizid;
    private Lesson lesson;
    private int acc;
    private double mark;
    private int enrolled;
    private int attempt;
    private String overview;

    public QuizDetail() {
    }

    public QuizDetail(int quizid, Lesson lesson, int acc, double mark, int enrolled, int attempt, String overview) {
        this.quizid = quizid;
        this.lesson = lesson;
        this.acc = acc;
        this.mark = mark;
        this.enrolled = enrolled;
        this.attempt = attempt;
        this.overview = overview;
    }

    public QuizDetail(Lesson lesson, int acc, int enrolled, int attempt) {
        this.lesson = lesson;
        this.mark = acc;
        this.enrolled = enrolled;
        this.attempt = attempt;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public int getQuizid() {
        return quizid;
    }

    public void setQuizid(int quizid) {
        this.quizid = quizid;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public int getAcc() {
        return acc;
    }

    public void setAcc(int acc) {
        this.acc = acc;
    }

    public int getEnrolled() {
        return enrolled;
    }

    public void setEnrolled(int enrolled) {
        this.enrolled = enrolled;
    }

    public int getAttempt() {
        return attempt;
    }

    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

}
