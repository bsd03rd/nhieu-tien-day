/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author 
 */
public class Logout extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Remove cookies
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie i : cookies) {
                if (i.getName().equals("gmail_Account")) {
                        i.setValue("");
                        i.setPath("/SuperShip");
                        i.setMaxAge(0);
                        response.addCookie(i);

                }
                   if (i.getName().equals("password_account")) {
                        i.setValue("");
                        i.setPath("/SuperShip");
                        i.setMaxAge(0);
                        response.addCookie(i);
                    }
                }
            }
        //Endremove cookies
        
        //Remove Session
        request.getSession().removeAttribute("gmail_Account");
        request.getSession().removeAttribute("password_account");
        request.getSession().removeAttribute("ac");
        //End Remove Session
        try {
            response.sendRedirect("Login");
        } catch (Exception e) {
            request.getRequestDispatcher("Login").forward(request, response);
        }
        

    }

}
