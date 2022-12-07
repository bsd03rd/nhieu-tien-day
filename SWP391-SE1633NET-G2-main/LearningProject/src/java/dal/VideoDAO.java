/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import Model.Lesson;
import Model.Video;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vuman
 */
public class VideoDAO extends DBContext{
       
    
    public Video getVideoOfLesson(int lessonId){
        try(ResultSet rs = executeQuery("SELECT [VideoID], [VideoName], [VideoLink] FROM [dbo].[Video] WHERE [LessonID] = ?", lessonId)){
            if(rs.next()){
                return new Video(rs.getInt("VideoID"), lessonId, rs.getNString("VideoName"), rs.getString("VideoLink"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    
    public ArrayList<Video> getAllVideo() {
        ArrayList<Video> vList =new ArrayList<>();
        try (ResultSet rs = executeQuery("SELECT [VideoID], [LessonID], [VideoName], [VideoLink] FROM [Video]")){
            
            while (rs.next()) {
                Video v = new Video(rs.getInt("VideoID"), rs.getInt("LessonID"),rs.getNString("VideoName"),rs.getString("VideoLink"));
                vList.add(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vList;
    }
}
