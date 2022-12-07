/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.User;
import dal.NotificationDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import utils.SendEmail;

/**
 *
 * @author Hieu Shin
 */
public class ManageAccountController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ManageAccountController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManageAccountController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        if (request.getSession().getAttribute("user") != null) {
            User user = (User) request.getSession().getAttribute("user");
            if (user.getRole().equals("Admin")) {
                UserDAO udao = new UserDAO();

                String searchingAccount = request.getParameter("searchingAccount");
                if (searchingAccount == null) {
                    searchingAccount = "";
                } else {
                    searchingAccount = (String)request.getParameter("searchingAccount").trim();
                }
                
                
                ArrayList<User> users = udao.getAllUserByEmail(searchingAccount);
                
                
                request.setAttribute("users", users);
                
                request.getRequestDispatcher("AdminManageAccount.jsp").forward(request, response);
            } else {
                response.sendRedirect("home");
            }
        } else {
            response.sendRedirect("home");
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
        UserDAO udao = new UserDAO();
        NotificationDAO noticeDAO = new NotificationDAO();
        SendEmail sendEmail = new SendEmail();
        int userid = 0;
        String isdisable = "";
        if (request.getParameter("userid") != null) {
            userid = Integer.parseInt(request.getParameter("userid"));
            isdisable = request.getParameter("isdisable");
            if(isdisable.compareToIgnoreCase("true") == 0) {
                udao.EnableAccount(userid);
                noticeDAO.sendNotification(userid, "Tài khoản của bạn đã được mở khóa, bạn có thể tham gia vào các khóa học bình thường.", "Account");
                sendEmail.sendEmail(udao.getAllUserInformationByID(userid).getEmail(), "Thông báo mở tài khoản","Tài khoản của đã được mở, bạn có thể tham gia vào các khóa học bình thường.");
            }
            else {
                udao.DisableAccount(userid);
                noticeDAO.sendNotification(userid, "Tài khoản của bạn đã bị khóa, vui lòng liên hệ với Admin để được mở khóa. ", "Account");
                sendEmail.sendEmail(udao.getAllUserInformationByID(userid).getEmail(), "Thông báo khóa tài khoản","Tài khoản của bạn đã bị khóa, vui lòng liên hệ với Admin để được mở khóa.");                
            }
            response.sendRedirect("manageaccount");
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
