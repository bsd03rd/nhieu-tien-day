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
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author NamDepTraiVL
 */
@WebServlet(name = "LoadMoreAccount", urlPatterns = {"/loadmore"})
public class LoadMoreAccount extends HttpServlet {

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
            out.println("<title>Servlet LoadMoreAccount</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoadMoreAccount at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        UserDAO userDAO = new UserDAO();
        ArrayList<User> users = userDAO.getAllUser();
        for (User user : users) {
            out.println("<tr>\n"
                    + "                                                <td style=\"max-width: 180px\">\n"
                    + "                                                    <div class=\"d-flex align-items-center\">\n"
                    + "                                                        <img src=\"" + user.getAvatar() + "\" alt=\"\"\n"
                    + "                                                             style=\"width: 40px; height: 40px; object-fit: cover; border-radius: 50%;\">\n"
                    + "                                                        <div class=\"ms-2\">\n"
                    + "                                                            <div class=\"fw-bold\">" + user.getLastName() + " " + user.getFirstName() + "</div>\n"
                    + "                                                        </div>\n"
                    + "                                                    </div>\n"
                    + "                                                </td>\n"
                    + "                                                <td>\n"
                    + "                                                    <div>\n"
                    + "                                                        <div\n"
                    + "                                                            style=\"background-color: #4dd4ac; border-radius: 32px; padding: 4px 8px; color: white; width: fit-content; font-weight: 500;\">\n"
                    + "                                                            " + user.getRole() + "</div>\n"
                    + "                                                    </div>\n"
                    + "                                                </td>\n"
                    + "                                                <td>\n"
                    + "                                                    <div style=\"font-weight: 600\">" + user.getEmail() + "</div>\n"
                    + "                                                </td>\n"
                    + "                                                <td>\n"
                    + "                                                    <div>\n"
                    + "                                                        <div\n"
                    + "                                                            style=\"font-weight: 500;\">\n"
                    + "                                                            " + (user.getPhone() == null ? "" : user.getPhone()) + "</div>\n"
                    + "                                                    </div>\n"
                    + "                                                </td>\n"
                    + "                                                <td>\n"
                    + "                                                    <div>\n"
                    + "                                                        <div style=\"border-radius: 32px; padding: 4px 8px; color: white; width: fit-content; font-weight: 500;\">\n");
            if (!user.getIsDisable()) {
                out.println("<button type=\"submit\" class=\"bg-success\"\n style=\"border:none; border-radius: 32px; padding: 4px 8px; color: white; min-width: 100px; font-weight: 500;\">Enable</button>\n");
            } else {
                out.println("<button type=\"submit\" class=\"bg-danger\"\n style=\"border:none; border-radius: 32px; padding: 4px 8px; color: white; min-width: 100px; font-weight: 500;\">Disable</button>\n");
            }
            out.println("                                                      </div>\n"
                    + "                                                </td>\n"
                    + "                                                <td>\n"
                    + "                                                    <div>                                                        \n"
                    + "                                                        <input type=\"checkbox\" name=\"email\" value=\"" + user.getEmail() + "\">\n"
                    + "                                                        <input type=\"hidden\" name=\"userid\" value=\"" + user.getUserId() + "\">\n"
                    + "                                                    </div>\n"
                    + "                                                    </div>\n"
                    + "                                                </td>\n"
                    + "                                            </tr>");
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
