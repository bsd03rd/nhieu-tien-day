/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import context.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Acount_cloud;
import model.Product_Cloud;

/**
 *
 * @author 
 */
public class Home extends HttpServlet {


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
            
            try {
                //AUTO Sort LIST
                ArrayList<Product_Cloud> list_itemnew = new DAO().Get_Product_List_SEARCHCORE(0, 15, "create_date_product DESC", "none");
                request.setAttribute("list_itemnew", list_itemnew);
                request.setAttribute("list_itempopular", new DAO().Get_List_Core("select id_product,count(id_product)as totalorder from Order_product_details \n" +
"group by id_product",0, 10, "count(id_product) DESC", "none"));
                request.setAttribute("list_buyagaint", new DAO().Get_List_Core("select id_product from Order_product\n" +
"join Order_product_details on Order_product_details.Id_order=Order_product.Id_order",0, 0, "id_product", "gmail_Account_buy like'"+((Acount_cloud)request.getSession().getAttribute("ac")).getGmail_Account()+"'group by id_product"));
                request.setAttribute("list_search", new DAO().Get_List_SearchHistoryItems(((Acount_cloud)request.getSession().getAttribute("ac")).getGmail_Account(), 0, 0, "", ""));
                //
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            
            
            request.getRequestDispatcher("coloshop-master/Home.jsp").forward(request, response);
        } else {
            response.sendRedirect("Login");
        }
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

 
}
