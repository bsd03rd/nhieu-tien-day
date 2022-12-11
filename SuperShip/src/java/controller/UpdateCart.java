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
import jakarta.servlet.http.Cookie;
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
public class UpdateCart extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException, InterruptedException {
        try {
            new AutoLogin().processRequest(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(Proflie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Proflie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Proflie.class.getName()).log(Level.SEVERE, null, ex);
        }
        Acount_cloud ac = (Acount_cloud) request.getSession().getAttribute("ac");
        if (request.getSession().getAttribute("ac") == null) {
            response.sendRedirect("Login");
            return;
        }
        
        
        try {
            if (request.getParameter("updatecartbtn").equals("Update Cart")) {
            String[] IDPD = request.getParameterValues("IDPD");
            String[] IDPD_value = request.getParameterValues("IDPD_value");
            
          
            //Check oveload amount product
            for (int i = 0; i < IDPD.length; i++) {
                if (Integer.parseInt(IDPD_value[i]) > Integer.parseInt(new libDao().Get_Product(IDPD[i], "").getAmount_product())) {
                    request.getSession().setAttribute("notice", "Product: " + new libDao().Get_Product(IDPD[i], "").getName_product() + " has only : " + new libDao().Get_Product(IDPD[i], "").getAmount_product() + " left ");
                    response.sendRedirect("Cart");
                    return;
                }
            }

            for (int i = 0; i < IDPD.length; i++) {
                Connection con = new DAO().Connect();
                PreparedStatement pr = null;
                ResultSet rs = null;
                if (Integer.parseInt(IDPD_value[i]) == 0) {
                    pr = con.prepareStatement("delete from Cart where gmail_Account like ? and id_product like ?");
                    pr.setString(1, ac.getGmail_Account());
                    pr.setString(2, IDPD[i]);
                    pr.executeUpdate();
                }
                pr = con.prepareStatement("update Cart set amount=? where gmail_Account like ? and id_product like ?");
                pr.setInt(1, Integer.parseInt(IDPD_value[i]));
                pr.setString(2, ac.getGmail_Account());
                pr.setString(3, IDPD[i]);
                pr.executeUpdate();
            }

//            int count=0;
//              for (int i = 0; i < IDPD.length; i++) {
//                  count+=Integer.parseInt(IDPD_value[i]) ;
//                if (count > 50) {
//                    request.setAttribute("notice", "Maxium 50 product per Order");
//                    request.getRequestDispatcher("Cart").forward(request, response);
//                    return;
//                }
//            }
            //
//            Cookie[] cookies = request.getCookies();
//            if (cookies != null) {
//                for (Cookie i : cookies) {
//                    if (i.getName().contains("ProductCart_")) {
//                        i.setValue("");
//                        i.setPath("/SuperShip");
//                        i.setMaxAge(0);
//                        response.addCookie(i);
//                    }
//                }
//            }
//            int lastItems = 0;
//            if (IDPD != null) {
//                for (int i = 0; i < IDPD.length; i++) {
//                    for (int j = 0; j < Integer.parseInt(IDPD_value[i]); j++) {
//                        Cookie Product_Cart = new Cookie("ProductCart_" + lastItems, IDPD[i]);
//                        Product_Cart.setMaxAge(60 * 60 * 24);
//                        response.addCookie(Product_Cart);
//                        lastItems += 1;
////                    response.getWriter().print(IDPD[i].split(",")[0]+" "+IDPD[i].split(",")[1]+"\n");
//                    }
//                }
//            }
        }
        } catch (Exception e) {
        }
        
        
        response.sendRedirect("Cart");
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
            Logger.getLogger(UpdateCart.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateCart.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(UpdateCart.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UpdateCart.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateCart.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(UpdateCart.class.getName()).log(Level.SEVERE, null, ex);
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
