/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.User;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hieu Shin
 */
public class AccountProfile extends HttpServlet {

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
            out.println("<title>Servlet AccountProfile</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AccountProfile at " + request.getContextPath() + "</h1>");
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
         UserDAO userDAO = new UserDAO();
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            String username = (String) session.getAttribute("username");
            request.setAttribute("user", userDAO.getAllUserInformation(username));
            request.getRequestDispatcher("AccountProfile.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath()+"/login");
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
            SimpleDateFormat sdm = new SimpleDateFormat("yyyy-MM-dd");
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            Date dob = new Date(sdm.parse(request.getParameter("dob")).getTime());
            String country = request.getParameter("country");
            String city = request.getParameter("city");
            String address = request.getParameter("address");
            String postcode = request.getParameter("postcode");
            String phonenumber = request.getParameter("phonenumber");
            String email = request.getParameter("email");
            
            User user = new User();
            user.setUserId(((User) (request.getSession().getAttribute("user"))).getUserId());
            user.setFirstName(firstname);
            user.setLastName(lastname);
            user.setDob(dob);
            user.setCountry(country);
            user.setCity(city);
            user.setAddress(address);
            user.setPostCode(postcode);
            user.setPhone(phonenumber);
            user.setEmail(email);
            
            UserDAO udao = new UserDAO();
            udao.updateProfile(user);
            
            response.sendRedirect("AccountProfile");
        } catch (ParseException ex) {
            Logger.getLogger(AccountProfile.class.getName()).log(Level.SEVERE, null, ex);
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
