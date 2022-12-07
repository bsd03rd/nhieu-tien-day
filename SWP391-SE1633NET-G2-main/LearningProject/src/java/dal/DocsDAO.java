/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import Model.Docs;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author vuman
 */
public class DocsDAO extends DBContext{
    public Docs getDocsOfLesson(int lessonId){
        try(ResultSet rs = executeQuery("SELECT [DocsID], [Content] FROM [dbo].[Docs] WHERE [LessonID] = ?", lessonId)){
            if(rs.next()){
                return new Docs(rs.getInt("DocsID"), lessonId, rs.getNString("Content"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
