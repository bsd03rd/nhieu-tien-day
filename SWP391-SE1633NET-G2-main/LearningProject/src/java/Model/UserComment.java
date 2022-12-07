/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


public class UserComment {
    private int CommentId;
    private int UserID;
    private boolean isLiked;

    public UserComment() {
    }

    
    
    public UserComment(int CommentId, int UserID, boolean isLiked) {
        this.CommentId = CommentId;
        this.UserID = UserID;
        this.isLiked = isLiked;
    }

    public int getCommentId() {
        return CommentId;
    }

    public void setCommentId(int CommentId) {
        this.CommentId = CommentId;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public boolean isIsLiked() {
        return isLiked;
    }

    public void setIsLiked(boolean isLiked) {
        this.isLiked = isLiked;
    }
    
    
    
}
