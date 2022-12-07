/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Course;
import Model.Feedback;
import Model.Lesson;
import Model.Section;
import Model.User;
import Model.UserCourse;
import dal.CourseDAO;
import dal.LessonDAO;
import dal.SectionDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author Dung
 */
public class CreateCoursePreviewController extends HttpServlet {

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
            out.println("<title>Servlet CreateCoursePreviewServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateCoursePreviewServlet at " + request.getContextPath() + "</h1>");
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
            if(user.getRole().equals("Admin")) {
                CourseDAO cdao = new CourseDAO();
                SectionDAO sectionDao = new SectionDAO();
                LessonDAO lessonDAO = new LessonDAO();
                CourseDAO cDAO = new CourseDAO();
                UserDAO u = new UserDAO();

                int id = Integer.parseInt(request.getParameter("id"));

                HttpSession session = request.getSession();
                Course course = cdao.getCourseInformation(id);
                // Add course objectives
                String courseObjectives = course.getObjectives();
                String[] objective = courseObjectives.split("[/]+");
                request.setAttribute("objective", objective);
                ArrayList<Section> sectionList = sectionDao.getAllSectionOfCourse(id);

                ArrayList<Lesson> lessonList = new ArrayList<Lesson>();
                for (Section section : sectionList) {
                    ArrayList<Lesson> tmp = lessonDAO.getAllLessonOfSection(section.getSectionId());
                    for (Lesson lesson : tmp) {
                        lessonList.add(lesson);
                    }
                }

                request.setAttribute("course", course);
                request.setAttribute("sectionList", sectionList);
                request.setAttribute("lessonList", lessonList);
                int time = cdao.getCourseTime(course.getCourseID());
                String totalTime = (time / 1000) / 60 / 60 % 24 + " hours " + (time / 1000) / 60 % 60 + " minutes " + (time / 1000) % 60 + " seconds ";
                request.setAttribute("totalTime", totalTime);
                request.getRequestDispatcher("CreateCoursePreview.jsp").forward(request, response);
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
