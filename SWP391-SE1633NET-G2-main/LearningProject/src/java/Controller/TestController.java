/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.User;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dal.PaymentDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.InputStream;
import java.nio.Buffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dung
 */
@WebServlet(urlPatterns = {"/test"}, name = "TestController")
public class TestController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        request.setAttribute("userid", user.getUserId());
        request.getRequestDispatcher("testTransaction.jsp").forward(request, response);
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
            HttpSession session = request.getSession();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            int status=99;
            
            //read the post content
            String securetoken = request.getHeader("secure-token");
            if (!securetoken.equals("Th1sIs4learningProject")) {
                return;
            }
            int contentLength = Integer.parseInt(request.getHeader("Content-Length"));
            InputStream inputStream = request.getInputStream();
            byte[] bytes = new byte[contentLength];
            inputStream.read(bytes);
            String text = new String(bytes, "utf-8");
            Gson gson = new Gson();
            JsonObject jobj = gson.fromJson(text, JsonObject.class).getAsJsonArray("data").get(0).getAsJsonObject();
            UserDAO userDAO = new UserDAO();
            PaymentDAO paymentDAO = new PaymentDAO();

            //get the transaction data
            int amount = Integer.parseInt(jobj.get("amount").toString());
            String content = jobj.get("description").toString().replaceAll("[\\\\,\\.,\"]", "");
            String[] description = jobj.get("description").toString().replaceAll("[\\\\,\\.]", "").split("\\s+");
            String username = "";
            int userid = 1;
            for (int i = 0; i < description.length; i++) {
                if (description[i].equals("NAP") && (i+1)<=description.length) {
                    username = description[i + 1];
                    break;
                }
            }
            
            if (userDAO.getAllUserInformation(username) != null) {
                userid = userDAO.getAllUserInformation(username).getUserId();
                status=0;
            }

            String when = jobj.get("when").toString().replaceAll("\"", "");
            Date date = sdf.parse(when);
            java.sql.Date sqldate = new java.sql.Date(date.getTime());
            paymentDAO.userRecharge(userid, sqldate, amount, status, "Recharge",content);
        } catch (ParseException ex) {
            Logger.getLogger(TestController.class.getName()).log(Level.SEVERE, null, ex);
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
