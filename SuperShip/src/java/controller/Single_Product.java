/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import context.DAO;
import context.libDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Acount_cloud;

/**
 *
 * @author BachDuc
 */
public class Single_Product extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            new AutoLogin().processRequest(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(Proflie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Proflie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Proflie.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (request.getSession().getAttribute("ac") != null) {
            Acount_cloud ac = (Acount_cloud) request.getSession().getAttribute("ac");

//            if(request.getParameter("submitcomment")!=null&&!request.getParameter("submitcomment").isEmpty()&&request.getParameter("comment")!=null&&!request.getParameter("comment").isEmpty()){
//                try {
//                    new DAO().Insert_Comment(request.getParameter("idpd"), ac.getGmail_Account(), request.getParameter("comment"), Integer.parseInt(request.getParameter("grade")));
//                } catch (SQLException ex) {
//                    System.err.println(ex);
//                } catch (ClassNotFoundException ex) {
//                      System.err.println(ex);
//                }
//            }
            try {
                if (request.getParameter("idpd") == null) {
                    response.sendRedirect("Home");
                    return;
                }

                if (request.getParameter("submitcomment") != null && !request.getParameter("submitcomment").isEmpty() && request.getParameter("comment") != null && !request.getParameter("comment").isEmpty()) {
                    try {
//                        new DAO().Insert_Comment("324","user@gmail.com","dmm",7);
                        new DAO().Insert_Comment(request.getParameter("idpd"), ac.getGmail_Account(), request.getParameter("comment").trim(), Integer.parseInt(request.getParameter("grade").trim()));
                    } catch (SQLException ex) {
                        System.err.println(ex);
                    } catch (ClassNotFoundException ex) {
                        System.err.println(ex);
                    }
                }

                request.setAttribute("singlePD", new libDao().Get_Product(request.getParameter("idpd"), ac.getGmail_Account()));
//                response.getWriter().print(request.getAttribute("singlePD").toString());
            } catch (SQLException ex) {
                Logger.getLogger(Single_Product.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Single_Product.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.getRequestDispatcher("coloshop-master/single.jsp").forward(request, response);
        } else {
            response.sendRedirect("Login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
