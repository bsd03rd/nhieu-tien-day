/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import context.DAO;
import core.SHA_256;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Acount_cloud;

/**
 *
 * @author 
 */
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("view/Login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("btn").equals("Register")) {
            response.sendRedirect("Register");
            return;
        }
        String username = request.getParameter("gmail_Account");
        String password = request.getParameter("password_account");
        if (username.isEmpty()||username==null) {
                    request.getSession().setAttribute("notice", "Chua nhap gi ca");
                    response.sendRedirect("Login");
                    return;
                }
        try {
            Acount_cloud ac = new DAO().Login_Account_Cloud(username, new SHA_256().MySHA256(password));
            if (ac != null) {
                request.getSession().setAttribute("ac", ac);
                //Add to Cookies
                Cookie username_login = new Cookie("gmail_Account", username);
                Cookie password_login = new Cookie("password_account", password);
                username_login.setMaxAge(60 * 60 * 24);
                password_login.setMaxAge(60 * 60 * 24);
                response.addCookie(username_login);
                response.addCookie(password_login);
                request.getSession().setAttribute("gmail_Account", username);
                request.getSession().setAttribute("password_account", password);
                request.getSession().setAttribute("notice", "");
                response.sendRedirect("Proflie");
            } else {
                request.getSession().setAttribute("notice", "Invalid username or password");
                response.sendRedirect("Login");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
