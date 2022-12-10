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
 * @author BachDuc
 */
public class AutoLogin extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException, NoSuchAlgorithmException {
       //GET COOKIES
        Cookie[] cookies = request.getCookies();
        String gmail_Account;
        String password_account;
        if (cookies != null) {
            for (Cookie i : cookies) {
                if (i.getName().equals("gmail_Account")) {
                    request.getSession().setAttribute("gmail_Account", i.getValue());
                }
                if (i.getName().equals("password_account")) {
                    request.getSession().setAttribute("password_account", i.getValue());
                }
            }
        }
        if(request.getSession().getAttribute("gmail_Account")!=null&&request.getSession().getAttribute("password_account")!=null){
           Acount_cloud ac = new DAO().Login_Account_Cloud((String)request.getSession().getAttribute("gmail_Account"),new SHA_256().MySHA256((String)request.getSession().getAttribute("password_account")));
            if(ac!=null){
                 request.getSession().setAttribute("ac", ac);
            }
        }   
//END GET COOKIES
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AutoLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AutoLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AutoLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AutoLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AutoLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AutoLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
