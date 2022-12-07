/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.ResetController;

import Model.User;
import dal.DBContext;
import dal.AccountDBContext;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Date;
import utils.HMACSHA256;
import utils.SendEmail;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.VerifyCaptcha;

/**
 *
 * @author NamDepTraiVL
 */
public class ForgotPass extends HttpServlet {

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
        request.getRequestDispatcher("ForgotPass.jsp").forward(request, response);
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
        String username = request.getParameter("username");
        String status = "";
        String payload = "";
        AccountDBContext accDB = new AccountDBContext();
        String token = "";
        VerifyCaptcha verifyCaptcha = new VerifyCaptcha();
        String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
        if (accDB.findAccWithUsername(username) != null) {
            if (verifyCaptcha.verify(gRecaptchaResponse)) {

                try {
                    UserDAO userDAO = new UserDAO();
                    String password = accDB.findOldPassWithUsername(username);
                    User user = userDAO.getAllUserInformation(username);                    
                    //response.getWriter().println(password);
                    long now = new Date().getTime() + 5 * 60 * 1000;
                    payload += "user: " + username + " ex: " + String.valueOf(now);
                    String sig = HMACSHA256.hmacWithJava(payload, password);
                    String res = Base64.getEncoder().encodeToString(payload.getBytes()) + ";" + sig;
                    String encode = Base64.getEncoder().encodeToString(res.getBytes());
                    SendEmail sendemail = new SendEmail();
//                sendemail.send("elearningswp391@gmail.com", "Verify Account","Test send email", "elearningswp391@gmail.com", "jtjnnqdicshtevlw");                            
                    token = "http://localhost:8080/LearningProject/resetpass?token=" + encode;
                    sendemail.sendEmail(user.getEmail(), "Reset Password", token);
                    request.setAttribute("username", username);
                    request.getRequestDispatcher("CheckYourMail.jsp").forward(request, response);
                    response.getWriter().println("Decode: " + encode);
                } catch (Exception ex) {
                    request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("status", "Captcha unavailable");
                doGet(request, response);
            }
        } else {
            request.setAttribute("status", "Email not found");
            doGet(request, response);
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
