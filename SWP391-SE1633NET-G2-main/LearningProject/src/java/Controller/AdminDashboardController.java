/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import Model.User;
import dal.CourseDAO;
import dal.PaymentDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class AdminDashboardController extends HttpServlet {
   
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(!user.getRole().equals("Admin")){
            response.sendRedirect("ErrorPage.jsp");
        }
        CourseDAO courseDAO = new CourseDAO();
        UserDAO userDAO = new UserDAO();
        PaymentDAO paymentDAO = new PaymentDAO();
        
        int totalCourse = courseDAO.ListAllCourses().size();
        int totalUser = userDAO.getTotalUser();
        int totalWithdrawPending = paymentDAO.getPendingWithdraw("").size();
        request.setAttribute("totalUser", totalUser);
        request.setAttribute("totalCourse", totalCourse);
        request.setAttribute("totalWithdrawPending", totalWithdrawPending);       
        request.getRequestDispatcher("AdminDashboard.jsp").forward(request, response);
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

   

}
