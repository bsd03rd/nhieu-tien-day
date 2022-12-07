/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author ASUS
 */
public class UnenrollController extends HttpServlet {
 
//NOT DONE BECAUSE I AM WAITING FRONT END FOR UNENROLL, THANK YOU
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        HttpSession ses = request.getSession();
        UserDAO u = new UserDAO();
        
        int CourseID = Integer.parseInt(request.getParameter("CourseID"));
        int UserID = u.getAllUserInformation(ses.getAttribute("username").toString()).getUserId();
        
        u.unenrollCourse(UserID, CourseID);
        
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.getRequestDispatcher("Lesson.jsp").forward(request, response);
    }

}
