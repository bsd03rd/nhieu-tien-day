/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import context.DAO;
import context.libDao;
import jakarta.servlet.http.Cookie;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Acount_cloud;

/**
 *
 * @author 
 */
public class Add_Cart_Cookies extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {

//        Acount_cloud ac= (Acount_cloud)request.getSession().getAttribute("ac");
//        if(new libDao().Get_ProductCONSTGMAIL(request.getParameter("idpd"), ac.getGmail_Account())!=null){
//            response.sendRedirect("Home");
//            return;
//        }
//        Cookie[] cookies = request.getCookies();
//        int lastID=0;
//        if (cookies != null) {
//            for (Cookie i : cookies) {
//                if (i.getName().contains("ProductCart_")) {
//                   String cokname[]=i.getName().split("_");
//                   int id=Integer.parseInt(cokname[1]);
//                  if(lastID<id){
//                      lastID=id;
//                  }
//                }
//            }
//        }
//        Cookie Product_Cart = new Cookie("ProductCart_"+(lastID+1), request.getParameter("idpd"));
//        Product_Cart.setMaxAge(60 * 60 * 24);
//        response.addCookie(Product_Cart);
//        response.sendRedirect(request.getParameter("crpage"));
//        bat dau code moi 
        try {
            new AutoLogin().processRequest(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(Proflie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Proflie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Proflie.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (request.getSession().getAttribute("ac") == null) {
            response.sendRedirect("Login");
            return;
        }
        Acount_cloud ac = (Acount_cloud) request.getSession().getAttribute("ac");
        Connection con = new DAO().Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "";
        if (new libDao().Get_ProductCONSTGMAIL(request.getParameter("idpd"), ac.getGmail_Account()) != null) {
            response.sendRedirect("Home");
            return;
        }
        //check already product in list ?
        pr = con.prepareStatement("select * from Cart where id_product like ? and gmail_Account like ?");
        pr.setInt(1, Integer.parseInt(request.getParameter("idpd")));
        pr.setString(2, ac.getGmail_Account());
        rs=pr.executeQuery();
        if(rs.next()){
             pr = con.prepareStatement("update Cart set amount+=1 where gmail_Account like ? and id_product like ?");
             pr.setString(1, ac.getGmail_Account());
             pr.setInt(2, Integer.parseInt(request.getParameter("idpd")));
             pr.executeUpdate();
        }else{
            // Add cart
        pr = con.prepareStatement("insert into Cart(id_product,amount,gmail_Account) values(?,?,?)");
        pr.setInt(1, Integer.parseInt(request.getParameter("idpd")));
        pr.setInt(2, 1);
        pr.setString(3, ac.getGmail_Account());
        pr.executeUpdate();
        }
        System.err.println("Current page:"+request.getParameter("crpage"));
        response.sendRedirect(request.getParameter("crpage"));
        

//        ket thuc codemoi
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
            Logger.getLogger(Add_Cart_Cookies.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Add_Cart_Cookies.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Add_Cart_Cookies.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Add_Cart_Cookies.class.getName()).log(Level.SEVERE, null, ex);
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
