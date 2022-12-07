/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ASUS
 */
public class Report {
    private int ReportID;
    private int UserID;
    private String Action;
    private String ReportContent;

    public Report() {
        
    }

    public Report(int ReportID, int UserID, String Action, String ReportContent) {
        this.ReportID = ReportID;
        this.UserID = UserID;
        this.Action = Action;
        this.ReportContent = ReportContent;
    }

    public int getReportID() {
        return ReportID;
    }

    public void setReportID(int ReportID) {
        this.ReportID = ReportID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getAction() {
        return Action;
    }

    public void setAction(String Action) {
        this.Action = Action;
    }

    public String getReportContent() {
        return ReportContent;
    }

    public void setReportContent(String ReportContent) {
        this.ReportContent = ReportContent;
    }
    
  
    
    
    
    
    
    
}
