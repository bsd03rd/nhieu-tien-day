/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import Model.Notification;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NamDepTraiVL
 */
public class NotificationDAO extends DBContext {

    public ArrayList<Notification> getNotificationFromUser(int userID, int status) {
        ArrayList<Notification> noticeList = new ArrayList<>();
        UserDAO userDAO = new UserDAO();
        ResultSet rs = null;
        try {
            if (status == 0) {
                rs = executeQuery("select NoticeID, UserID, NoticeContent, NoticeDate, isSeen,Action from Notification\n"
                        + "where UserID = ? AND isSeen = 0 order by NoticeID desc", userID);
            } else {
                rs = executeQuery("select NoticeID, UserID, NoticeContent, NoticeDate, isSeen,Action from Notification\n"
                        + "where UserID = ? order by NoticeID desc", userID);
            }
            while (rs.next()) {
                Notification notice = new Notification();
                notice.setNoticeContent(rs.getString("NoticeContent"));
                notice.setNoticeDate(rs.getTimestamp("NoticeDate"));
                notice.setNoticeID(rs.getInt("NoticeID"));
                notice.setSeen(rs.getBoolean("isSeen"));
                notice.setAction(rs.getString("Action"));
                notice.setUserID(userDAO.getAllUserInformationByID(rs.getInt("UserID")));
                noticeList.add(notice);
            }
            return noticeList;
        } catch (SQLException ex) {
            Logger.getLogger(NotificationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return noticeList;
    }

    public void sendNotification(int userID, String content, String action) {

        java.util.Date date = new java.util.Date();        
        int status = 99;
        try {
            status = executeUpdate("INSERT INTO [dbo].[Notification]\n"
                    + "           ([UserID]\n"
                    + "           ,[NoticeContent]\n"
                    + "           ,[NoticeDate]\n"
                    + "           ,[isSeen]\n"
                    + "           ,[Action])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)", userID, content, new Timestamp(date.getTime()), false, action);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public void MarkAsSeen(int noticeID) {
        executeUpdate("update Notification\n"
                + "set isSeen = 1\n"
                + "where NoticeID = ?", noticeID);
    }
}
