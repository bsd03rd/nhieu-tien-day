/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import Model.Blog;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class BlogDAO extends DBContext {

    public void addBlog(int userid, Timestamp date, String content, String tilte,
            String description, String image, String category, String status) {
        try {
            execute("INSERT INTO [Blog] \n"
                    + "	([UserID],\n"
                    + "	[BlogDate],\n"
                    + "	[BlogContent],\n"
                    + "	[BlogTilte],\n"
                    + "	[BlogDescription],\n"
                    + "	[BlogImage],\n"
                    + "	[Category],\n"
                    + "	[Status])\n"
                    + "VALUES (\n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?, \n"
                    + "	?)", userid, date, content, tilte, description, image, category, status);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteBlog(int blogId) {
        try {
            executeUpdate("DELETE FROM [dbo].[Blog] WHERE [BlogID] = ?", blogId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Blog getBlogInformation(int blogId) {
        try {
            ResultSet rs = executeQuery("SELECT [UserID], [BlogDate], [BlogContent], [BlogTilte], [BlogDescription], [BlogImage], [Category], [Status] "
                    + "FROM [dbo].[Blog] WHERE [BlogID] = ?", blogId);

            if (rs.next()) {
                return new Blog(blogId,
                        rs.getInt("UserID"),
                        rs.getTimestamp("BlogDate"),
                        rs.getNString("BlogContent"),
                        rs.getNString("BlogTilte"),
                        rs.getNString("BlogDescription"),
                        rs.getString("BlogImage"),
                        rs.getString("Category"),
                        rs.getString("Status"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateBlog(String content, String tilte, String description, String image, String category, int blogId) {
        try {
            executeUpdate("UPDATE [dbo].[Blog] "
                    + "SET [BlogContent] = ?,"
                    + "[BlogTilte] = ?,"
                    + "[BlogDescription] = ?,"
                    + "[BlogImage] = ?,"
                    + "[Category] = ? "
                    + "WHERE [BlogID] = ?", content, tilte, description, image, category, blogId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Blog> getBlogListReported() {
        ArrayList<Blog> blogListReport = new ArrayList();
        UserDAO udao = new UserDAO();
        try {
            ResultSet rs = executeQuery("SELECT [BlogID]\n"
                    + "      ,[UserID]\n"
                    + "      ,[BlogDate]\n"
                    + "      ,[BlogContent]\n"
                    + "      ,[BlogTilte]\n"
                    + "      ,[BlogDescription]\n"
                    + "      ,[BlogImage]\n"
                    + "      ,[Category]\n"
                    + "      ,[Status]\n"
                    + "      ,[isReported]\n"
                    + "  FROM [dbo].[Blog]\n"
                    + "  WHERE isReported = 1");
            while (rs.next()) {
                blogListReport.add(new Blog(rs.getInt("BlogID"),
                        rs.getTimestamp("BlogDate"),
                        rs.getString("BlogContent"),
                        rs.getString("BlogTilte"),
                        rs.getString("BlogDescription"),
                        rs.getString("BlogImage"),
                        rs.getString("Category"),
                        rs.getString("Status"),
                        udao.getAllUserInformationByID(rs.getInt("UserID"))));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return blogListReport;
    }

    public ArrayList<Blog> ListAllBlogs() {
        try {
            ArrayList<Blog> blogs = new ArrayList<>();
            ResultSet rs = executeQuery("SELECT \n"
                    + "	[BlogID],\n"
                    + "	[UserID],\n"
                    + "	[BlogDate],\n"
                    + "	[BlogContent],\n"
                    + "	[BlogTilte],\n"
                    + "	[BlogDescription],\n"
                    + "	[BlogImage],\n"
                    + "	[Category]\n"
                    + "FROM [Blog]\n"
                    + "WHERE [Status] = 'Enabled'");
            while (rs.next()) {
                blogs.add(new Blog(rs.getInt("BlogID"), rs.getInt("UserID"),
                        rs.getTimestamp("BlogDate"), rs.getNString("BlogContent"),
                        rs.getNString("BlogTilte"), rs.getNString("BlogDescription"),
                        rs.getString("BlogImage"), rs.getString("Category"), "Enabled"));
            }
            return blogs;
        } catch (SQLException ex) {
            Logger.getLogger(BlogDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Blog> ListAllBlogsOnWebs() {
        try {
            ArrayList<Blog> blogs = new ArrayList<>();
            ResultSet rs = executeQuery("SELECT \n"
                    + "	[BlogID],\n"
                    + "	[UserID],\n"
                    + "	[BlogDate],\n"
                    + "	[BlogContent],\n"
                    + "	[BlogTilte],\n"
                    + "	[BlogDescription],\n"
                    + "	[BlogImage],\n"
                    + "	[Category],\n"
                    + " [Status] \n"
                    + "FROM [Blog]");
            while (rs.next()) {
                blogs.add(new Blog(rs.getInt("BlogID"), rs.getInt("UserID"),
                        rs.getTimestamp("BlogDate"), rs.getNString("BlogContent"),
                        rs.getNString("BlogTilte"), rs.getNString("BlogDescription"),
                        rs.getString("BlogImage"), rs.getString("Category"), rs.getString("Status")));
            }
            return blogs;
        } catch (SQLException ex) {
            Logger.getLogger(BlogDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Blog> ListAllBlogsByCategory(String category) {
        try {
            ArrayList<Blog> blogs = new ArrayList<>();
            ResultSet rs = executeQuery("SELECT \n"
                    + "	[BlogID],\n"
                    + " [UserID],\n"
                    + "	[BlogDate],\n"
                    + "	[BlogContent],\n"
                    + "	[BlogTilte],\n"
                    + "	[BlogDescription],\n"
                    + "	[BlogImage],\n"
                    + "	[Category]\n"
                    + "FROM [Blog]\n"
                    + "WHERE [Category] = ?\n"
                    + "AND [Status] = 'Enabled'", category);
            while (rs.next()) {
                blogs.add(new Blog(rs.getInt("BlogID"), rs.getInt("UserID"),
                        rs.getTimestamp("BlogDate"), rs.getNString("BlogContent"),
                        rs.getNString("BlogTilte"), rs.getNString("BlogDescription"),
                        rs.getString("BlogImage"), rs.getString("Category"), "Enabled"));
            }
            return blogs;
        } catch (SQLException ex) {
            Logger.getLogger(BlogDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Blog getBlogByBlogID(int id) {
        try {
            ResultSet rs = executeQuery("SELECT \n"
                    + "	[UserID],\n"
                    + "	[BlogDate],\n"
                    + "	[BlogContent],\n"
                    + "	[BlogTilte],\n"
                    + "	[BlogDescription],\n"
                    + "	[BlogImage],\n"
                    + "	[Category]\n"
                    + "FROM [Blog]\n"
                    + "WHERE [Status] = 'Enabled'\n"
                    + "AND [BlogID] = ?", id);
            if (rs.next()) {
                return new Blog(id, rs.getInt("UserID"),
                        rs.getTimestamp("BlogDate"), rs.getNString("BlogContent"),
                        rs.getNString("BlogTilte"), rs.getNString("BlogDescription"),
                        rs.getString("BlogImage"), rs.getString("Category"), "Enable");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BlogDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Blog> listUserBlogByID(int id) {
        try {
            ArrayList<Blog> blogs = new ArrayList<>();
            ResultSet rs = executeQuery("SELECT \n"
                    + "	[BlogID],\n"
                    + "	[UserID],\n"
                    + "	[BlogDate],\n"
                    + "	[BlogContent],\n"
                    + "	[BlogTilte],\n"
                    + "	[BlogDescription],\n"
                    + "	[BlogImage],\n"
                    + "	[Category]\n"
                    + "FROM [Blog]\n"
                    + "WHERE [Status] != 'Disabled'\n"
                    + "AND [UserID] = ?", id);
            while(rs.next()) {
                blogs.add(new Blog(rs.getInt("BlogID"), rs.getInt("UserID"),
                        rs.getTimestamp("BlogDate"), rs.getNString("BlogContent"),
                        rs.getNString("BlogTilte"), rs.getNString("BlogDescription"),
                        rs.getString("BlogImage"), rs.getString("Category"), "Enabled"));
            }
            return blogs;
        } catch (SQLException ex) {
            Logger.getLogger(BlogDAO.class.getName()).log(Level.SEVERE, null, ex);
             return null;
        }
       
    }
    
    public void updateBlogStatus(String status, int blogID) {
        try {
            int updateStatus = executeUpdate("UPDATE [dbo].[Blog]\n"
                    + "   SET [Status] = ?\n"
                    + " WHERE BlogID = ?", status, blogID);
            if(updateStatus < 0) {
                throw new Exception();
            }
            System.out.println("Update success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
