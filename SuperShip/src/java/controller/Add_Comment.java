///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
// */
//package controller;
//
//import context.DAO;
//import java.io.IOException;
//import java.io.PrintWriter;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.security.NoSuchAlgorithmException;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
// *
// * @author 
// */
//public class Add_Comment extends HttpServlet {
//
//    
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        
//        try {
//            new AutoLogin().processRequest(request, response);
//
//        } catch (SQLException ex) {
//            Logger.getLogger(Proflie.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Proflie.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (NoSuchAlgorithmException ex) {
//            Logger.getLogger(Proflie.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        if (request.getSession().getAttribute("ac") == null) {
//            response.sendRedirect("Login");
//        }
//        else{
//            new DAO().Insert_Comment(idpd, ac, comment, 0)
//            
//        }
//    }
//
//   
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        
//        
//        
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        
//        
//        
//        
//    }
//
//    
//
//}
