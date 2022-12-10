/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import context.CommonDAO;
import context.DBContext;
import context.libDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Acount_cloud;

/**
 *
 * @author BachDuc
 */
public class GetDetailsOrder extends HttpServlet {

    Connection connection = new CommonDAO().CommonDAO();

    public GetDetailsOrder() throws ClassNotFoundException {
//        try {
//            //Change the username password and url to connect your own database
//            String username = "sa";
//            String password = "123";
//            String url = "jdbc:sqlserver://DESKTOP-T2PMA24:1433;databaseName=ShopeBee";
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            connection = DriverManager.getConnection(url, username, password);
//        } catch (SQLException ex) {
//            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {

        String id = request.getParameter("id");
        //--------------------------------------------------------------------
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "";
        Acount_cloud ac = new Acount_cloud();
        sql = "select * from Order_product where Id_order like ?";
        pr = connection.prepareStatement(sql);
        pr.setString(1, id);
        rs = pr.executeQuery();
        rs.next();
        request.getSession().setAttribute("date", rs.getString(4));
        request.getSession().setAttribute("idod", rs.getString(1));
        //---------------------------------------------------------------------
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
        request.getSession().setAttribute("IDPD", IDPD);
        request.getSession().setAttribute("IDPD_value", IDPD_value);
        //----------------------------------------------------------------------
        sql = "select * from Ship_info where Id_order like ?";
        pr = connection.prepareStatement(sql);
        pr.setString(1, id);
        rs = pr.executeQuery();
        rs.next();
        String totalincludeship=rs.getString(5);
           request.getSession().setAttribute("totalincludeship", totalincludeship);     

        float feeship=0;
        for (int i = 0; i < IDPD.length; i++) {
            feeship+=Float.parseFloat(new libDao().Get_Product(IDPD[i], "").getValue_product_perunit())* Float.parseFloat(IDPD_value[i]) ;
        }
        feeship=Float.parseFloat(totalincludeship)-feeship;
        request.getSession().setAttribute("fee",feeship);
        response.sendRedirect("view/Create_Order.jsp"); 
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
            Logger.getLogger(GetDetailsOrder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GetDetailsOrder.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(GetDetailsOrder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GetDetailsOrder.class.getName()).log(Level.SEVERE, null, ex);
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
