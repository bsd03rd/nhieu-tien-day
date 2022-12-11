/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import context.DAO;
import context.libDao;
import java.io.IOException;
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
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Acount_cloud;
import model.Cart_Model;

/**
 *
 * @author 
 */
public class Cart extends HttpServlet {

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

//            Acount_cloud ac = (Acount_cloud) request.getSession().getAttribute("ac");
//            ArrayList<Cart_Model> list = new ArrayList<Cart_Model>();
//            Cookie[] cookies = request.getCookies();
//            boolean pass;
//            if (cookies != null) {
//                for (Cookie i : cookies) {
//                    if (i.getName().contains("ProductCart_")) {
//                        pass = true;
//                        if (list.isEmpty()!=true) {
//                            for (Cart_Model o : list) {
//                                if (o.getPd().getId_product().equals(i.getValue())) {
//                                    pass = false;
//                                }
//                            }
//                        }
//                        if (pass == true) {
//                            try {
//                                if( new libDao().Get_Product(i.getValue(), "").getGmail_Account().equals(ac.getGmail_Account())){
//                                    
//                                }else{
//                                     list.add(new Cart_Model(new libDao().Get_Product(i.getValue(), ac.getGmail_Account()), 1));
//                                }
//                            } catch (SQLException ex) {
//                                Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
//                            } catch (ClassNotFoundException ex) {
//                                Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
//                            }
//                        }
//                        if (pass != true) {
//                            for (Cart_Model o2 : list) {
//                                if (i.getValue().equals(o2.getPd().getId_product())) {
//                                    o2.setAmoun(o2.getAmoun() + 1);
//                                }
//                            }
//                        }
//
//                    }
//                }
//            }
    
//new code begin
//end new code
            ArrayList<Cart_Model> list = new ArrayList<Cart_Model>();
            Acount_cloud ac = (Acount_cloud) request.getSession().getAttribute("ac");
            Connection con = null;
            try {
                con = new DAO().Connect();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
            }
            PreparedStatement pr = null;
            ResultSet rs = null;
            try {
                pr = con.prepareStatement("select * from Cart where gmail_Account like ?");
                pr.setString(1, ac.getGmail_Account());
                rs = pr.executeQuery();
                while (rs.next()) {
                    list.add(new Cart_Model(new libDao().Get_Product(rs.getString(1), ac.getGmail_Account()), rs.getInt(2)));
                }
                          Collections.sort(list, new Comparator<Cart_Model>() {
                @Override
                public int compare(Cart_Model o1, Cart_Model o2) {
                   return o1.getPd().getGmail_Account().compareTo(o2.getPd().getGmail_Account());
                }
        }); 
            } catch (Exception e) {
            }

            request.setAttribute("list", list);
//            response.getWriter().print(list.toString());
            request.getRequestDispatcher("view/Cart.jsp").forward(request, response);
//            response.sendRedirect("view/Cart.jsp");
        } else {
            response.sendRedirect("Login");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
            ArrayList<Cart_Model> list = new ArrayList<Cart_Model>();
            Cookie[] cookies = request.getCookies();
            boolean pass;
            if (cookies != null) {
                for (Cookie i : cookies) {
                    if (i.getName().contains("ProductCart_")) {
                        pass = true;
                        if (list.isEmpty() != true) {
                            for (Cart_Model o : list) {
                                if (o.getPd().getId_product().equals(i.getValue())) {
                                    pass = false;
                                }
                            }
                        }
                        if (pass == true) {
                            try {
                                list.add(new Cart_Model(new libDao().Get_Product(i.getValue(), ac.getGmail_Account()), 1));
                            } catch (SQLException ex) {
                                Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        if (pass != true) {
                            for (Cart_Model o2 : list) {
                                if (i.getValue().equals(o2.getPd().getId_product())) {
                                    o2.setAmoun(o2.getAmoun() + 1);
                                }
                            }
                        }

                    }
                }
            }
            Collections.sort(list, new Comparator<Cart_Model>() {
                @Override
                public int compare(Cart_Model o1, Cart_Model o2) {
                    return o1.getPd().getGmail_Account().compareTo(o2.getPd().getGmail_Account());
                }
            });
            request.setAttribute("list", list);
            request.getRequestDispatcher("view/Cart.jsp").forward(request, response);
//            response.sendRedirect("view/Cart.jsp");
        } else {
            response.sendRedirect("Login");
        }

    }

}
