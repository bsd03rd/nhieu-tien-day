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
 * @author BachDuc
 */
public class categories extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        
        
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
        int amount = 12;
        String orderby = "value_product_perunit ASC";
        String where = "none";
        String content = "";
        String city = "";
        String price = "";
        String cate="";
        float min=0;
        float max=1000000;
        if (request.getParameter("amountitems") != null) {
            amount = Integer.parseInt((String) request.getParameter("amountitems"));
        }
        if (request.getParameter("orderby") != null) {
            orderby = request.getParameter("orderby");
        }

        if (request.getParameter("content") != null) {
            content = request.getParameter("content");
        }
        if (request.getParameter("where") != null) {
            where = request.getParameter("where");
        }
//        ArrayList<Product_Cloud> dflist = new DAO().Get_Product_List_SEARCHCORE(0, 0, orderby, where);
        
        if (request.getParameter("searchbar") != null && !request.getParameter("searchbar").isEmpty() && !request.getParameter("searchbar").trim().equals("")) {
            content = request.getParameter("searchbar");
            if (!where.equals("none")) {
                where += " and " + "(freetext(product.*,N'" + content + "') )";
            } else {
                where = "(freetext(product.*,N'" + content + "'))";
            }
            new DAO().Insert_History(((Acount_cloud)request.getSession().getAttribute("ac")).getGmail_Account(), content);

        }
        if (request.getParameter("city") != null && !request.getParameter("city").isEmpty() && !request.getParameter("city").trim().equals("") && !request.getParameter("city").trim().equals("all")) {
            city = request.getParameter("city");
            if (!where.equals("none")) {
                where += " and " + "((select count(*) from Address_Account where Address_Account.gmail_Account like product.gmail_Account  and ID_City_Address like '" + request.getParameter("city") + "')  !=0 )";
            } else {
                where = "((select count(*) from Address_Account where Address_Account.gmail_Account like product.gmail_Account  and ID_City_Address like '" + request.getParameter("city") + "')  !=0 )";
            }
        }

        if (request.getParameter("minprice") != null && !request.getParameter("minprice").isEmpty() && !request.getParameter("minprice").trim().equals("") && request.getParameter("maxprice") != null && !request.getParameter("maxprice").isEmpty() && !request.getParameter("maxprice").trim().equals("")) {
            try {
                min = Float.parseFloat(request.getParameter("minprice"));
                max = Float.parseFloat(request.getParameter("maxprice"));
                if (!where.equals("none")) {
                    where += " and " + " (product.value_product_perunit>=" + min + " and product.value_product_perunit<=" + max+ ") ";
                } else {
                    where = " (product.value_product_perunit>=" + min + " and product.value_product_perunit<=" +max + ") ";
                }
            } catch (Exception e) {
            }
        }
        
        if (request.getParameter("cate") != null && !request.getParameter("cate").trim().isEmpty()) {
           cate= request.getParameter("cate") ;
            if (!where.equals("none")) {
                where += " and " + " (product.id_categories like '"+cate+"') ";
            } else {
                where = " (product.id_categories like '"+cate+"') ";
            }
        }

        if (request.getParameter("page") != null) {
             ArrayList<Product_Cloud> dflistpagesize = new DAO().Get_Product_List_SEARCHCORE(0, 0, orderby, where);
             //list nay dung de lay zise cua list 
            ArrayList<Product_Cloud> dflistpage = new DAO().Get_Product_List_SEARCHCORE(Integer.parseInt(request.getParameter("page")) * amount, amount, orderby, where);
            // List nay luon tra ve size = 12 thoi do chon page 
            request.setAttribute("dflist", dflistpage);
            System.err.println("Loi o day ne:~~~~~~~~~~~~~~~~~~"+dflistpagesize.size());
            request.setAttribute("size", dflistpagesize.size());
            request.setAttribute("amount", amount);
            request.setAttribute("orderby", orderby);
            request.setAttribute("content", content);
            request.setAttribute("city", city);
            request.setAttribute("min", min);
            request.setAttribute("max", max);
            request.setAttribute("cate", cate);
            request.setAttribute("test", dflistpagesize.size());
            request.getRequestDispatcher("coloshop-master/categories.jsp").forward(request, response);
        } else {
            response.sendRedirect("categories?orderby=" + orderby + "&amountitems=" + amount + "&page=0&where=" + where + "&content=" + content + "&city=" + city + "&minprice=" + min+ "&maxprice=" + max +"&cate=" + cate);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(categories.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(categories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(categories.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(categories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
