/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Blog;
import dal.BlogDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author Hieu Shin
 */
public class FilterBlog extends HttpServlet {

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
            out.println("<title>Servlet FilterBlog</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FilterBlog at " + request.getContextPath() + "</h1>");
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
        try ( PrintWriter out = response.getWriter()) {
            String category = request.getParameter("category");
            BlogDAO bdao = new BlogDAO();
            UserDAO udao = new UserDAO();
            ArrayList<Blog> blogs = bdao.ListAllBlogsByCategory(category);
            

            for (Blog blog : blogs) {
                out.println("<div class=\"card card-body p-3 shadow-sm mb-4\"> \n"
                        + "                                    <div class=\"d-flex align-items-center justify-content-between\">\n"
                        + "                                        <!-- User post -->\n"
                        + "                                        <div class=\"d-flex align-items-center\">\n"
                        + "                                            <img src=\""+udao.getAllUserInformationByID(blog.getUserid()).getAvatar()+"\" alt=\"\" style=\"width: 24px; height: 24px; object-fit: cover; border-radius: 50%;\">\n"
                        + "                                            <span style=\"font-size: 12px; font-weight: 600  ;\" class=\"ms-2\">"+udao.getAllUserInformationByID(blog.getUserid()).getLastName()+ " " + udao.getAllUserInformationByID(blog.getUserid()).getFirstName()+"</span>\n"
                        + "                                        </div>\n"
                        + "\n"
                        + "                                        <!-- User post -->\n"
                        + "\n"
                        + "                                        <!-- Action -->\n"
                        + "                                        <i class=\"fa-solid fa-ellipsis\"></i>\n"
                        + "                                        <!-- Action -->\n"
                        + "                                    </div>\n"
                        + "\n"
                        + "                                    <!-- Content -->\n"
                        + "                                    <div class=\"mt-3 d-flex justify-content-between align-items-center\">\n"
                        + "                                        <!-- Content left -->\n"
                        + "                                        <div class=\"\" style=\"width: 78%;\">\n"
                        + "                                            <a style=\"font-size: 20px;\" class=\"fw-bolder\" href=\"blogdetail?id="+blog.getBlogid()+"\">"+blog.getTitle()+"</a>\n"
                        + "                                            <p class=\"text-black-50\" style=\"font-size: 15px;\">"+ blog.getDescription() +"</p>\n"
                        + "                                        </div>\n"
                        + "                                        <!-- Content left -->\n"
                        + "                                        <div style=\"width: 20%; height: 80px;\">\n"
                        + "                                            <img src=\""+ blog.getImage() +"\" class=\"rounded-3\" alt=\"\" style=\"width: 100%; max-height: 120px; object-fit: cover;\">\n"
                        + "                                        </div>\n"
                        + "                                        <!-- Content right -->\n"
                        + "                                        <div>\n"
                        + "\n"
                        + "                                        </div>\n"
                        + "                                        <!-- Content right -->\n"
                        + "\n"
                        + "                                    </div>\n"
                        + "                                    <!-- Content -->\n"
                        + "\n"
                        + "                                    <div class=\"d-flex align-items-center\">\n"
                        + "                                        <div class=\"tag bg-primary fw-bold text-white\" style=\"padding: 6px 12px; width: fit-content; border-radius: 16px; font-size: 14px;\">\n"
                        + "                                            "+ blog.getCategory() +"\n"
                        + "                                        </div>\n"
                        + "                                        <span class=\"ms-2\">\n"
                        + "                                            .\n"
                        + "                                        </span>\n"
                        + "                                        <div class=\"ms-2 d-inline-block\" style=\"font-size: 14px;\">\n"
                        + "                                            "+ blog.getDate() +"\n"
                        + "                                        </div>\n"
                        + "                                    </div>\n"
                        + "                                </div>");
            }
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
