/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Timestamp;

/**
 *
 * @author Hieu Shin
 */
public class Blog {

    private int blogid;
    private int userid;
    private Timestamp date;
    private String content;
    private String title;
    private String description;
    private String image;
    private String category;
    private String status;
    private User user;

    public Blog() {
    }

    public Blog(int blogid, int userid, Timestamp date, String content, String tilte, String description, String image, String category, String status) {
        this.blogid = blogid;
        this.userid = userid;
        this.date = date;
        this.content = content;
        this.title = tilte;
        this.description = description;
        this.image = image;
        this.category = category;
        this.status = status;
    }

    public Blog(int blogid, Timestamp date, String content, String title, String description, String image, String category, String status, User user) {
        this.blogid = blogid;
        this.date = date;
        this.content = content;
        this.title = title;
        this.description = description;
        this.image = image;
        this.category = category;
        this.status = status;
        this.user = user;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getBlogid() {
        return blogid;
    }

    public void setBlogid(int blogid) {
        this.blogid = blogid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTilte(String tilte) {
        this.title = tilte;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
