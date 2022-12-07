/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Course;
import Model.User;
import dal.CourseDAO;
import dal.QuizDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author vuman
 */
public class MentorDashboardController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            if (session.getAttribute("user") != null) {
                CourseDAO cd = new CourseDAO();
                QuizDAO quizDAO = new QuizDAO();
                User user = (User) session.getAttribute("user");
                ArrayList<Course> list = cd.getAllMentorCourse(user.getUserId());                

                request.setAttribute("numofcourses", cd.getMentorNumberOfCourse(user.getUserId()));
                request.setAttribute("numofstudents", cd.getMentorNumberOfStudent(user.getUserId()));
                request.setAttribute("numofblogs", cd.getMentorNumberOfBlog(user.getUserId()));
                request.setAttribute("numofquizs", cd.getMentorNumberOfQuiz(user.getUserId()));
                request.setAttribute("courses", list);                
                request.getRequestDispatcher("MentorDashboard.jsp").forward(request, response);
            } else {
                response.sendRedirect("home");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

}
