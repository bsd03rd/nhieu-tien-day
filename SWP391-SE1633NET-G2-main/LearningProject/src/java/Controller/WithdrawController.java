/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.User;
import dal.PaymentDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author NamDepTraiVL
 */
public class WithdrawController extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        UserDAO userDAO = new UserDAO();
        PaymentDAO paymentDAO = new PaymentDAO();
        String string = request.getParameter("amount");
        int amount = Integer.parseInt(request.getParameter("amount"));

        User user = (User) session.getAttribute("user");
        if (user.getBalance() < amount) {
            out.println("<script type=\"text/javascript\">");
                out.println("alert('Số tiền yêu cầu rút nhiều hơn trong tài khoản, vui lòng nhập lại');");
                out.println("location='transaction';");
                out.println("</script>");
            return;
        }
        if (user.getRole().equals("User")) {
            request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
            return;
        }
        Date date = new Date();
        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        paymentDAO.userRecharge(user.getUserId(), sqldate, (-amount), 2, "Withdraw", "Withdraw from account " + user.getUserName());
        User newuser = userDAO.getAllUserInformationByID(user.getUserId());
        session.setAttribute("user", newuser);
        response.sendRedirect("transaction");
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
