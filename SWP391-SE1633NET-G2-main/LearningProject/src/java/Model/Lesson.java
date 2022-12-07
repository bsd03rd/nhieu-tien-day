/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author vuman
 */
public class Lesson {
    private int lessonId;
    private int sectionId;
    private String lessonName;
    private boolean isDisable;
    private String type;
    private int time;
    private String videoLink;
    private String Content;
    private String Status;
    private Quiz quiz;
    
    public Lesson() {
    }
    
    public Lesson(int lessonId, int sectionId, String lessonName, boolean isDisable, String type,  int time, String Status) {
        this.lessonId = lessonId;
        this.sectionId = sectionId;
        this.lessonName = lessonName;
        this.isDisable = isDisable;
        this.type = type;
        this.time = time;
        this.Status = Status;
    }


    public Lesson(int lessonId, int sectionId, String lessonName, boolean isDisable, String type,  int time) {
        this.lessonId = lessonId;
        this.sectionId = sectionId;
        this.lessonName = lessonName;
        this.isDisable = isDisable;
        this.type = type;
        this.time = time;
    }

    public Lesson(int lessonId, int sectionId, String lessonName, boolean isDisable, String type, boolean isChecked, int time) {
        this.lessonId = lessonId;
        this.sectionId = sectionId;
        this.lessonName = lessonName;
        this.isDisable = isDisable;
        this.type = type;
        this.time = time;
    }

    public Lesson(int lessonId, int sectionId, String lessonName, boolean isDisable, String type, int time, String videoLink, String Content) {
        this.lessonId = lessonId;
        this.sectionId = sectionId;
        this.lessonName = lessonName;
        this.isDisable = isDisable;
        this.type = type;
        this.time = time;
        this.videoLink = videoLink;
        this.Content = Content;
    }

    public Lesson(int lessonId, int sectionId, String lessonName, String type, Quiz quiz) {
        this.lessonId = lessonId;
        this.sectionId = sectionId;
        this.lessonName = lessonName;
        this.type = type;
        this.quiz = quiz;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
    
    
    
    

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    
    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
    
    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public boolean isIsDisable() {
        return isDisable;
    }

    public void setIsDisable(boolean isDisable) {
        this.isDisable = isDisable;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
        public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    
}
