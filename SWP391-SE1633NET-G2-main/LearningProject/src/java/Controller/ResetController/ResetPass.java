/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.ResetController;

import utils.HMACSHA256;
import dal.AccountDBContext;
import dal.Validation;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NamDepTraiVL
 */
public class ResetPass extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String token = request.getParameter("token");
        if (isTokenValid(token)) {
            request.setAttribute("token", token);
            request.getRequestDispatcher("ResetPass.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
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
            Validation val = new Validation();
            String newpassword = request.getParameter("password");
            if (val.checkPasswordFormat(newpassword)) {
                String password = HMACSHA256.textToSHA256(newpassword);
                String username = getUserFromToken(request.getParameter("token"));
                AccountDBContext accDB = new AccountDBContext();
                accDB.update(username, password);
                request.getRequestDispatcher("PasswordResetSuccess.jsp").forward(request, response);
            }else{
                String status = "Password format wrong, please re-input password";
                request.setAttribute("status", status);
                doGet(request, response);
            }
        } catch (Exception ex) {
            request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
        }
    }

    private boolean isTokenValid(String token) {
        try {
            Base64.Decoder decoder = Base64.getDecoder();

            //Decode the token
            String decode = new String(decoder.decode(token));
            //Base64(Payload);Signature

            //Split the decode token into payload and signature
            String[] decodeArr = decode.split(";");
            String sig = decodeArr[1];
            
            //Split the payload and decode Base64 to get the expire time, username
            String payload = new String(decoder.decode(decodeArr[0]));
            String[] sarray = payload.split("\\s");
            String username = sarray[1];
            AccountDBContext accDb = new AccountDBContext();
            
            
            String key = accDb.findOldPassWithUsername(username);
            String checksig = HMACSHA256.hmacWithJava(payload, key);
            long exp = Long.parseLong(sarray[3]);
            long now = new Date().getTime();
            if (checksig.equals(sig) && exp > now) {
                return true;
            }
        } catch (Exception ex) {
            return false;
        }
        return false;
    }

    private String getUserFromToken(String token) {
        Base64.Decoder decoder = Base64.getDecoder();

        //Decode the token
        String decode = new String(decoder.decode(token));

        //Split the decode token into payload and signature
        String[] decodeArr = decode.split(";");
        String payload = new String(decoder.decode(decodeArr[0]));
        String sig = decodeArr[1];

        //Split the payload and get the expire time, username
        String[] sarray = payload.split("\\s");
        String email = sarray[1];
        return email;
    }
}
