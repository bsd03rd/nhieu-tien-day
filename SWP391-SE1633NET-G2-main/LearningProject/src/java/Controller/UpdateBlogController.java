/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import Model.Blog;
import Model.User;
import dal.BlogDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author vuman
 */
public class UpdateBlogController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int blogId = Integer.parseInt(request.getParameter("blogid"));
            if(request.getParameter("button") != null){
                BlogDAO bd = new BlogDAO();
                if(request.getParameter("button").equals("Delete")){
                    bd.deleteBlog(blogId);
                    
                    response.sendRedirect("userdashboard");
                }
                else{   
                    Blog blog = bd.getBlogInformation(blogId);
                    request.setAttribute("blog", blog);
                    request.getRequestDispatcher("UpdateBlog.jsp").forward(request, response);
                    return;
                }
            }
            else{
                response.sendRedirect("home");
            }
        } catch (Exception e) {
            request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
        }
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            User user = (User) request.getSession().getAttribute("user");
            int blogId = Integer.parseInt(request.getParameter("blogid"));
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String category = request.getParameter("category");
            String content = request.getParameter("content");
            String image = request.getParameter("imageBase64");
            
            BlogDAO bdao = new BlogDAO();
            
            bdao.updateBlog(content, title, description, image, category, blogId);
            
            response.sendRedirect("userdashboard");
        }
        else {
            response.sendRedirect("home");
        }
    }

}
