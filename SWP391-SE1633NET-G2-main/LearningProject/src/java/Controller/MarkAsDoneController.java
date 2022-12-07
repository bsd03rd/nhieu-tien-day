/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.User;
import dal.LessonDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author NamDepTraiVL
 */
@WebServlet(name = "MarkAsDoneController", urlPatterns = {"/markasdone"})
public class MarkAsDoneController extends HttpServlet {

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
        HttpSession session = request.getSession();
        LessonDAO lessonDAO = new LessonDAO();
        User user = (User) session.getAttribute("user");
        int lessonID = Integer.parseInt(request.getParameter("lessonID"));
        int courseID = Integer.parseInt(request.getParameter("courseID"));
        int sectionID = Integer.parseInt(request.getParameter("sectionID"));
        lessonDAO.UpdateMarkAs(lessonID, user.getUserId(), "Done");
        if (lessonDAO.getNextLessonInSection(sectionID, lessonID) != null) {            
            lessonID = lessonDAO.getNextLessonInSection(sectionID, lessonID);
        }else if(lessonDAO.getNextSectionOfCourse(sectionID, courseID) != null){
            sectionID = lessonDAO.getNextSectionOfCourse(sectionID, courseID);
            lessonID = lessonDAO.getNextLessonInSection(sectionID, 0);
        }
        response.sendRedirect("WatchCourse?courseID=" + courseID + "&sectionID=" + sectionID + "&lessonID=" + lessonID);
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
