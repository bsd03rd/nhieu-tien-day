/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import core.RandomNumber;
import core.SHA_256;
import core.SendMail;
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

/**
 *
 * @author 
 */
public class ConfirmEmail extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("view/ConfirmEmail.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie i : cookies) {
                if (i.getName().equals("Code_register")) {
                    try {
                        if (SHA_256.MySHA256(request.getParameter("Code_register")).equals(i.getValue())) {
                            //
                            new Add_Account().processRequest(request, response);
                            //
                            response.sendRedirect("Login");
                            return;
                        }
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(ConfirmEmail.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(ConfirmEmail.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ConfirmEmail.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        response.getWriter().print("Not OK");

    }

}
