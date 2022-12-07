/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import Model.Course;
import Model.Section;
import Model.User;
import dal.CourseDAO;
import dal.LessonDAO;
import dal.SectionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import javax.mail.Session;

/**
 *
 * @author Dung
 */
public class CreateCourseController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateCourseController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateCourseController at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        // Check if mentor
        if(request.getSession().getAttribute("user") != null) {
            User user= (User) request.getSession().getAttribute("user");
            if(user.getRole().equals("Admin")) {
                request.getSession().setAttribute("idcup","-1");
                try {
                    if(request.getParameter("idc")!=null){
                    CourseDAO cdao = new CourseDAO();
                    if(cdao.getCourseInformation(Integer.parseInt(request.getParameter("idc")))!=null){
                         request.getSession().setAttribute("idcup", request.getParameter("idc"));
                    }
                    }
                } catch (Exception e) {
                }
                response.sendRedirect("CreateCourse.jsp");
            } else {
                response.sendRedirect("home");
            }
        } else {
            response.sendRedirect("home");
        }
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        CourseDAO cdao = new CourseDAO();
        // Check if mentor then accept
        if(request.getSession().getAttribute("user") != null) {
            User author = (User) request.getSession().getAttribute("user");
            if(author.getRole().equals("Admin")) {
                String courseTitle = request.getParameter("CourseTitle");
                String courseDes = request.getParameter("CourseDes");
                String[] courseObjectives = request.getParameterValues("Objectives");
                String objective = "";
                for(String s : courseObjectives) {
                    objective += s + "/";
                }
                String image = request.getParameter("imageBase64");
                Date date = new Date();
                Timestamp createdDate = new Timestamp(date.getTime());
                String category = request.getParameter("category");
                int coursePrice = Integer.parseInt(request.getParameter("CoursePrice"));
                int numberEnroll = 0;
                String status = "Pending";
                String difficulty = request.getParameter("difficulty");
                double courseProgress = 0;
                int newCourseID = cdao.getNewCourseID() + 1;
                
                
                cdao.addNewCourse(new Course(0, courseTitle, createdDate, category, 
                        numberEnroll, coursePrice, image, status, author, courseProgress, 
                        courseDes, objective, difficulty));
                response.sendRedirect("CreateSection?courseId=" + newCourseID);

            } else {
                response.sendRedirect("home");
            }
        } else {
            response.sendRedirect("home");
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
