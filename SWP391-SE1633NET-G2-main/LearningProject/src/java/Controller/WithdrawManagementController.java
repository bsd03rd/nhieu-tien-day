/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Payment;
import Model.User;
import dal.PaymentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Enumeration;

/**
 *
 * @author NamDepTraiVL
 */
@WebServlet(name = "WithdrawManagementController", urlPatterns = {"/withdrawmanagement"})
public class WithdrawManagementController extends HttpServlet {

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
        String searching = request.getParameter("searching");
        if (searching == null) {
            searching = "";
            } else {
            searching = request.getParameter("searching").trim();
        }
        
        HttpSession session = request.getSession();
        PaymentDAO paymentDAO = new PaymentDAO();
        User user = (User) session.getAttribute("user");
        if (!user.getRole().equals("Admin")) {
            response.sendRedirect("ErrorPage.jsp");
            return;
        }
     
        ArrayList<Payment> withdrawList = paymentDAO.getAllWithdraw(searching);
        request.setAttribute("withdrawList", withdrawList);
        request.getRequestDispatcher("AdminManageWithdraw.jsp").forward(request, response);
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
        PaymentDAO paymentDAO = new PaymentDAO();
        Enumeration paymentList = request.getParameterNames();
        while (paymentList.hasMoreElements()) {            
            paymentDAO.updatePaymentStatus(Integer.parseInt(paymentList.nextElement().toString()), 0);
        }
        doGet(request, response);
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
