/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import context.DAO;
import context.libDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Acount_cloud;

/**
 *
 * @author BachDuc
 */
public class LoadDistrict extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        request.setAttribute("city", request.getParameter("city"));
//        request.getRequestDispatcher("Proflie").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Acount_cloud ac = (Acount_cloud) request.getSession().getAttribute("ac");
        if(request.getParameter("insertadress")!=null){
            if(request.getParameter("city_register").equals("none")||request.getParameter("district_register").equals("none")||request.getParameter("Adress_register")==null||request.getParameter("Adress_register").trim().isEmpty()){
                 request.getSession().setAttribute("notice2", "Please fill all data to add new adress");
                 response.sendRedirect("Proflie");
                 return;
            }
            
            try {
                new DAO().Add_Adress_Account(ac.getGmail_Account(), request.getParameter("city_register"),
                        request.getParameter("district_register"),
                        request.getParameter("Adress_register"));
            } catch (SQLException ex) {
                Logger.getLogger(LoadDistrict.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LoadDistrict.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        try {
            request.setAttribute("city", new DAO().Get_City_Address_byCity(request.getParameter("city_register")));
//            response.getWriter().print( request.getAttribute("city"));
            request.getRequestDispatcher("Proflie").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoadDistrict.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoadDistrict.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
