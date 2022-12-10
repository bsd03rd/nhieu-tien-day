/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import context.DAO;
import context.libDao;
import core.CurrentDate;
import core.SHA_256;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Acount_cloud;

/**
 *
 * @author BachDuc
 */
public class Pay_Cart extends HttpServlet {

//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException, SQLException, ClassNotFoundException, NoSuchAlgorithmException {
//       String btn=request.getParameter("paybtn");
//        if(btn!=null){
//            Acount_cloud ac = (Acount_cloud) request.getSession().getAttribute("ac");
//        String gmail = request.getParameter("Shop");
//        String idadd = request.getParameter("Idadd");
//        String[] IDPD = request.getParameterValues("IDPD");
//        String[] IDPD_value = request.getParameterValues("IDPD_value");
//        String fee = request.getParameter("fee");
//        String idOD = new SHA_256().MySHA256(new CurrentDate().GetDate());
//        String date = new CurrentDate().GetDate();
//        new DAO().CreateOrder(idOD, new libDao().Get_Product(IDPD[0], "").getGmail_Account(), ac.getGmail_Account(), date);
//        for (int i = 0; i < IDPD.length; i++) {
//            if (new libDao().Get_Product(IDPD[i], "").getGmail_Account().equals(gmail)) {
//                new DAO().AddOrderDetail(idOD, IDPD[i]);
//            }
//        }
//        new DAO().AddOrderShip(idOD, idadd, fee);
//
//        request.setAttribute("sp", new DAO().Get_Ship_info(idOD));
//        request.setAttribute("date", date);
//        request.setAttribute("idod", idOD);
//        request.setAttribute("IDPD", IDPD);
//        request.setAttribute("IDPD_value", IDPD_value);
//
////        response.getWriter().print(request.getAttribute("sp"));
//        request.getRequestDispatcher("view/Create_Order.jsp").forward(request, response);
////        response.sendRedirect("view/Create_Order.jsp"); 
//        }else{
//                    response.sendRedirect("Cart"); 
//        }
//       
//
//    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect("Cart");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String btn = request.getParameter("paybtn");
        if (btn != null) {
            if(request.getParameter("totalincludeship")==null||request.getParameter("totalincludeship").trim().isEmpty()||request.getParameter("totalincludeship").trim().equals("NaN")){
                request.getSession().setAttribute("notice2", " Please chosse all required payment to order !");
                response.sendRedirect("Cart");
                return;
            }
             if(request.getParameter("Idadd")==null||request.getParameter("Idadd").trim().isEmpty()){
                request.getSession().setAttribute("notice2", " Please choose address or go to profile to set new adress !");
                response.sendRedirect("Cart");
                return;
            }
            Acount_cloud ac = (Acount_cloud) request.getSession().getAttribute("ac");
            if( Float.valueOf(request.getParameter("totalincludeship").trim()) > Float.valueOf(ac.getAccount_info().getBalance())){
                request.getSession().setAttribute("notice2", " Balance Not Enought money !");
                response.sendRedirect("Cart");
                return;
            }
            String gmail = request.getParameter("Shop");
            String idadd = request.getParameter("Idadd");
            String[] IDPD = request.getParameterValues("IDPD");
            String[] IDPD_value = request.getParameterValues("IDPD_value");
            String fee = request.getParameter("fee");
            String totalincludeship = request.getParameter("totalincludeship");
            
            String idOD = null;
            // select items
            String IDPDselect[] = new String[IDPD.length];
            String IDPDvaluesselect[] = new String[IDPD_value.length];
            int count = 0;
            for (int i = 0; i < IDPD.length; i++) {
                try {
                    if (new libDao().Get_Product(IDPD[i], "").getGmail_Account().equals(gmail)) {
                        IDPDselect[count] = IDPD[i];
                        IDPDvaluesselect[count] = IDPD_value[i];
                        count += 1;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Pay_Cart.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Pay_Cart.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            int size = 0;
            for (int i = 0; i < IDPDselect.length; i++) {
                if (IDPDselect[i] == null) {
                    size = i;
                    IDPDselect = Arrays.copyOf(IDPDselect, size);
                    IDPDvaluesselect = Arrays.copyOf(IDPDvaluesselect, size);
                }
            }
            for (int i = 0; i < IDPDselect.length; i++) {
                System.out.println(IDPDselect[i]);
            }
            //
            try {
                idOD = new SHA_256().MySHA256(new CurrentDate().GetDate());
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Pay_Cart.class.getName()).log(Level.SEVERE, null, ex);
            }
            String date = new CurrentDate().GetDate();
            try {
                new DAO().CreateOrder(idOD, new libDao().Get_Product(IDPD[0], "").getGmail_Account(), ac.getGmail_Account(), date);
            } catch (SQLException ex) {
                Logger.getLogger(Pay_Cart.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Pay_Cart.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (int i = 0; i < IDPD.length; i++) {
                try {
                    if (new libDao().Get_Product(IDPD[i], "").getGmail_Account().equals(gmail)) {
                        for (int j = 0; j < Integer.parseInt(IDPD_value[i]); j++) {
                            new DAO().AddOrderDetail(idOD, IDPD[i]);
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Pay_Cart.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Pay_Cart.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                float feeship = 0;
                for (int i = 0; i < IDPDselect.length; i++) {
                    feeship += Float.parseFloat(new libDao().Get_Product(IDPDselect[i], "").getValue_product_perunit()) * Float.parseFloat(IDPDvaluesselect[i]);
                }
                feeship+=Float.parseFloat(fee);

                new DAO().AddOrderShip(idOD, idadd,String.valueOf(feeship) );
            } catch (SQLException ex) {
                Logger.getLogger(Pay_Cart.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Pay_Cart.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                request.setAttribute("sp", new DAO().Get_Ship_info(idOD));
            } catch (SQLException ex) {
                Logger.getLogger(Pay_Cart.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Pay_Cart.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            for (int i = 0; i < IDPDselect.length; i++) {
                try {
                    new DAO().Update_AmountProduct(IDPDselect[i],Integer.parseInt(new libDao().Get_Product(IDPDselect[i], "").getAmount_product())-Integer.parseInt(IDPDvaluesselect[i]));
                } catch (SQLException ex) {
                    Logger.getLogger(Pay_Cart.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Pay_Cart.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            // select items
//            String IDPDselect[] = new String[IDPD.length];
//            String IDPDvaluesselect[] = new String[IDPD_value.length];
//            int count = 0;
//            for (int i = 0; i < IDPD.length; i++) {
//                try {
//                    if (new libDao().Get_Product(IDPD[i], "").getGmail_Account().equals(gmail)) {
//                        IDPDselect[count] = IDPD[i];
//                        IDPDvaluesselect[count] = IDPD_value[i];
//                        count += 1;
//                    }
//                } catch (SQLException ex) {
//                    Logger.getLogger(Pay_Cart.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (ClassNotFoundException ex) {
//                    Logger.getLogger(Pay_Cart.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            int size = 0;
//            for (int i = 0; i < IDPDselect.length; i++) {
//                if (IDPDselect[i] == null) {
//                    size = i;
//                    IDPDselect = Arrays.copyOf(IDPDselect, size);
//                    IDPDvaluesselect = Arrays.copyOf(IDPDvaluesselect, size);
//                }
//            }
//            for (int i = 0; i < IDPDselect.length; i++) {
//                System.out.println(IDPDselect[i]);
//            }
            //
            request.getSession().setAttribute("date", date);
            request.getSession().setAttribute("idod", idOD);
            request.getSession().setAttribute("IDPD", IDPDselect);
            request.getSession().setAttribute("IDPD_value", IDPDvaluesselect);
            request.getSession().setAttribute("totalincludeship", totalincludeship);
            request.getSession().setAttribute("fee", fee);

//        response.getWriter().print(request.getAttribute("sp"));
//        request.getRequestDispatcher("view/Create_Order.jsp").forward(request, response);
            response.sendRedirect("view/Create_Order.jsp");
        } else {
            response.sendRedirect("Cart");
        }
    }

}
