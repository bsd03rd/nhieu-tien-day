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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Acount_cloud;

/**
 *
 * @author 
 */
public class TESTINGJSP extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      

// try {
     
//         URL url = new URL("https://dantri.com.vn/");
//      //Retrieving the contents of the specified page
//      Scanner sc = new Scanner(url.openStream());
//      //Instantiating the StringBuffer class to hold the result
//      StringBuffer sb = new StringBuffer();
//      while(sc.hasNext()) {
//         sb.append(sc.next());
//         //System.out.println(sc.next());
//      }
//      //Retrieving the String from the String Buffer object
//      String result = sb.toString();
//      System.out.println(result);
//      //Removing the HTML tags
//      result = result.replaceAll("<[^>]*>", "");
//      System.out.println("Contents of the web page: "+result);

//String filePath = "myimages/test.txt";
//
//  // file to byte[], Path
//  byte[] bytes = Files.readAllBytes(Paths.get(filePath));
//        System.out.println(filePath);

//try {
//    new AutoLogin().processRequest(request, response);
//    
//} catch (SQLException ex) {
//    Logger.getLogger(Proflie.class.getName()).log(Level.SEVERE, null, ex);
//} catch (ClassNotFoundException ex) {
//    Logger.getLogger(Proflie.class.getName()).log(Level.SEVERE, null, ex);
//} catch (NoSuchAlgorithmException ex) {
//    Logger.getLogger(Proflie.class.getName()).log(Level.SEVERE, null, ex);
//}

//byte[] byt= new DAO().Get_Account_CloudNOPASS("admin@gmail.com").getAccount_info().getImg();
//
//response.getWriter().print(byt);
//
//String s = Base64.getEncoder().encodeToString(byt);
//
//byte[] decode = Base64.getDecoder().decode(s);
//response.getWriter().print(decode);

//        byte[] byt = new DAO().Get_Account_CloudNOPASS("Dungbanga@gmail.com").getAccount_info().getImg();
//        String s = Base64.getEncoder().encodeToString(byt);
//        response.getWriter().print(s);
//        System.out.println(s);
//        byte[] decode = Base64.getDecoder().decode(s);


// } catch (SQLException ex) {
//            Logger.getLogger(TESTINGJSP.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(TESTINGJSP.class.getName()).log(Level.SEVERE, null, ex);
     request.getRequestDispatcher("VNPAY/vnpay_index.jsp").forward(request, response);  
// }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
