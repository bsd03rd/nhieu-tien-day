/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import com.oracle.wls.shaded.org.apache.bcel.generic.AALOAD;
import context.DAO;
import core.ImagesString;
import core.RandomNumber;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Account_Address_Cloud;
import model.Account_info_Cloud;
import model.Acount_cloud;
import model.Product_Cloud;
import model.Register_information;

/**
 *
 * @author 
 */
public class Add_Account extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        String email_register = null;
        String password_register = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie i : cookies) {
                if (i.getName().equals("email_register")) {
                    email_register = i.getValue();
                }
                if (i.getName().equals("password_register")) {
                    password_register = i.getValue();
                }
            }
        }
        //

//        byte[] byt = new DAO().Get_Account_CloudNOPASS("admin@gmail.com").getAccount_info().getImg();
//        String s = Base64.getEncoder().encodeToString(byt);
//        byte[] decode = Base64.getDecoder().decode(s);
        //

        new DAO().Add_Account_Cloud(email_register, password_register);
        new DAO().Insert_Account_Cloud(new Acount_cloud(email_register, "user",
                password_register, new Account_info_Cloud(email_register, "User"+new RandomNumber().RandNum(5),
                        "Name", "maleGender",
                        "0", "123456789", Base64.getDecoder().decode(new ImagesString().getDefaultAvatar()), ""), new ArrayList<Account_Address_Cloud>(), new ArrayList<Product_Cloud>()));
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Add_Account.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Add_Account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Add_Account.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Add_Account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
