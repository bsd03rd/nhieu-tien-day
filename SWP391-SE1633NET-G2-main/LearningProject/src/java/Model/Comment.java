/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Timestamp;
import java.util.Date;



/**
 *
 * @author vuman
 */
public class Comment {
    private int commentId;
    private int videoId;
    private User User;
    private int ParentId;
    private String commentContent;
    private Timestamp commentDate;
    private int likes;
    private boolean isReported;
    private boolean isDisable;
    

    public Comment() {
    }

    public Comment(int commentId, int videoId, User User, int ParentId, String commentContent, Timestamp commentDate, int likes, boolean isReported, boolean isDisable) {
        this.commentId = commentId;
        this.videoId = videoId;
        this.User = User;
        this.ParentId = ParentId;
        this.commentContent = commentContent;
        this.commentDate = commentDate;
        this.likes = likes;
        this.isReported = isReported;
        this.isDisable = isDisable;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User User) {
        this.User = User;
    }

    public int getParentId() {
        return ParentId;
    }

    public void setParentId(int ParentId) {
        this.ParentId = ParentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Timestamp getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Timestamp commentDate) {
        this.commentDate = commentDate;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public boolean isIsReported() {
        return isReported;
    }

    public void setIsReported(boolean isReported) {
        this.isReported = isReported;
    }

    public boolean isIsDisable() {
        return isDisable;
    }

    public void setIsDisable(boolean isDisable) {
        this.isDisable = isDisable;
    }

    

    
    
    
}
