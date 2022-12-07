/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author vuman
 */
public class Docs {
    private int docsId;
    private int lessonId;
    private String content;

    public Docs() {
    }

    public Docs(int docsId, int lessonId, String content) {
        this.docsId = docsId;
        this.lessonId = lessonId;
        this.content = content;
    }

    public int getDocsId() {
        return docsId;
    }

    public void setDocsId(int docsId) {
        this.docsId = docsId;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    }
