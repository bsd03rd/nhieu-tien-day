/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Notification;
import dal.NotificationDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import utils.SHA256;

/**
 *
 * @author vuman
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("Login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UserDAO userDAO = new UserDAO();
            NotificationDAO noticeDAO = new NotificationDAO();
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if (userDAO.checkLogin(username, SHA256.SHA256(password))) {
                // save into session                
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("user", userDAO.getAllUserInformation(username));
                session.setAttribute("test", "This is text");               
                response.sendRedirect("home");
            } else {
                if (userDAO.isAccountExist(username)) {
                    request.setAttribute("result", "Wrong password, please try again!");
                } else {
                    request.setAttribute("result", "Login Failed, your account does not exist!!");
                }
                doGet(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
