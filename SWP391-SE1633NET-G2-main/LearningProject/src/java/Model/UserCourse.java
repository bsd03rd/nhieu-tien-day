/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

public class UserCourse {
    private int UserID;
    private int CourseID;
    private boolean isStudied;
    private int CourseRating;
    private String CourseFeedback;
    private double Progress;
    private Date Paydate;
    private boolean isFavourite;

    public UserCourse() {
        
    }
    
    public UserCourse(int UserID, int CourseID, boolean isStudied, int CourseRating, String CourseFeedback, double Progress, Date Paydate, boolean isFavourite) {
        this.UserID = UserID;
        this.CourseID = CourseID;
        this.isStudied = isStudied;
        this.CourseRating = CourseRating;
        this.CourseFeedback = CourseFeedback;
        this.Progress = Progress;
        this.Paydate = Paydate;
        this.isFavourite = isFavourite;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

    public boolean isIsStudied() {
        return isStudied;
    }

    public void setIsStudied(boolean isStudied) {
        this.isStudied = isStudied;
    }

    public int getCourseRating() {
        return CourseRating;
    }

    public void setCourseRating(int CourseRating) {
        this.CourseRating = CourseRating;
    }

    public String getCourseFeedback() {
        return CourseFeedback;
    }

    public void setCourseFeedback(String CourseFeedback) {
        this.CourseFeedback = CourseFeedback;
    }

    public double getProgress() {
        return Progress;
    }

    public void setProgress(double Progress) {
        this.Progress = Progress;
    }

    public Date getPaydate() {
        return Paydate;
    }

    public void setPaydate(Date Paydate) {
        this.Paydate = Paydate;
    }

    public boolean isIsFavourite() {
        return isFavourite;
    }

    public void setIsFavourite(boolean isFavourite) {
        this.isFavourite = isFavourite;
    }
    
    
    
    
    
}
