/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import context.DAO;
import context.DBContext;
import context.libDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Acount_cloud;

/**
 *
 * @author BachDuc
 */
public class CancelOrder extends HttpServlet {

    Connection connection;

    public CancelOrder() throws ClassNotFoundException {
        try {
            //Change the username password and url to connect your own database
            String username = "sa";
            String password = "123";
            String url = "jdbc:sqlserver://DESKTOP-DVQ2APJ:1433;databaseName=ShopeBee";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String id = request.getParameter("id");
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "";
        //----------------------------------------------
         ArrayList<String> IDPDli = new ArrayList<>();
        ArrayList<String> IDPD_valueli = new ArrayList<>();
        sql = "select id_product,count(*) from Order_product_details where Id_order like ?\n"
                + "group by id_product";
        pr = connection.prepareStatement(sql);
        pr.setString(1, id);
        rs = pr.executeQuery();
        while (rs.next()) {
            IDPDli.add(rs.getString(1));
            IDPD_valueli.add(rs.getString(2));
        }
        String[] IDPD = new String[IDPDli.size()];
        String[] IDPD_value = new String[IDPD_valueli.size()];
        for (int i = 0; i < IDPD.length; i++) {
            IDPD[i] = IDPDli.get(i);
        }
        for (int i = 0; i < IDPD_value.length; i++) {
            IDPD_value[i] = IDPD_valueli.get(i);
        }
        for (int i = 0; i < IDPD.length; i++) {
                try {
                    new DAO().Update_AmountProduct(IDPD[i],Integer.parseInt(new libDao().Get_Product(IDPD[i], "").getAmount_product())+Integer.parseInt(IDPD_value[i]));
                } catch (SQLException ex) {
                    Logger.getLogger(Pay_Cart.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Pay_Cart.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        //-----------------------------------------------
        Acount_cloud ac = new Acount_cloud();
        sql = "update Ship_info set ShippedDate_Ship_info=-1 where Id_order like ?";
        pr = connection.prepareStatement(sql);
        pr.setString(1, id);
        pr.executeUpdate();
        response.sendRedirect("Manager_Order");
        //---------------------------------------------------
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
            Logger.getLogger(CancelOrder.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CancelOrder.class.getName()).log(Level.SEVERE, null, ex);
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
