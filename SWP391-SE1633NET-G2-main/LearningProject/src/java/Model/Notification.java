/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author NamDepTraiVL
 */
public class Notification {

    private int NoticeID;
    private User UserID;
    private Date NoticeDate;
    private String NoticeContent;
    private boolean Seen;
    private String Action;

    public Notification(int NoticeID, User UserID, Date NoticeDate, String NoticeContent, boolean Seen, String Action) {
        this.NoticeID = NoticeID;
        this.UserID = UserID;
        this.NoticeDate = NoticeDate;
        this.NoticeContent = NoticeContent;
        this.Seen = Seen;
        this.Action = Action;
    }

    public String getAction() {
        return Action;
    }

    public void setAction(String Action) {
        this.Action = Action;
    }

    

    public Notification() {
    }

    public int getNoticeID() {
        return NoticeID;
    }

    public void setNoticeID(int NoticeID) {
        this.NoticeID = NoticeID;
    }

    public User getUserID() {
        return UserID;
    }

    public void setUserID(User UserID) {
        this.UserID = UserID;
    }

    public Date getNoticeDate() {
        return NoticeDate;
    }

    public void setNoticeDate(Date NoticeDate) {
        this.NoticeDate = NoticeDate;
    }

    public String getNoticeContent() {
        return NoticeContent;
    }

    public void setNoticeContent(String NoticeContent) {
        this.NoticeContent = NoticeContent;
    }

    public boolean isSeen() {
        return Seen;
    }

    public void setSeen(boolean Seen) {
        this.Seen = Seen;
    }

}
