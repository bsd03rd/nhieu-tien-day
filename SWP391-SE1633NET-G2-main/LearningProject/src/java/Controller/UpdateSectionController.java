/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Course;
import Model.Section;
import dal.CourseDAO;
import dal.SectionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author vuman
 */
public class UpdateSectionController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SectionDAO sd = new SectionDAO();
        CourseDAO cd = new CourseDAO();

        int courseId = Integer.parseInt(request.getParameter("courseid"));
        Course course = cd.getAllCourseInformation(courseId);
        ArrayList<Section> sectionList = sd.getAllSectionOfCourse(courseId);

        request.setAttribute("course", course);
        request.setAttribute("sectionlist", sectionList);

        request.getRequestDispatcher("UpdateSection.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SectionDAO sd = new SectionDAO();
        CourseDAO cd = new CourseDAO();
        
        int courseId = Integer.parseInt(request.getParameter("courseid"));

        if (request.getParameter("button") != null) {
            if (request.getParameter("button").equals("Edit")) {
                int sectionId = Integer.parseInt(request.getParameter("sectionid"));
                String sectionName = request.getParameter("sectionname");

                sd.editSectionName(sectionId, sectionName);
                
                response.sendRedirect("updatesection?courseid=" + courseId);
            }
            if (request.getParameter("button").equals("Delete")) {
                int sectionId = Integer.parseInt(request.getParameter("sectionid"));
                sd.disableSection(sectionId);
                
                response.sendRedirect("updatesection?courseid=" + courseId);
            }
            if (request.getParameter("button").equals("Add section")) {
                String sectionName = request.getParameter("SectionName");
                Section section = new Section(0, courseId, sectionName, false);
                sd.addSection(section);
                
                response.sendRedirect("updatesection?courseid=" + courseId);
            }
            if (request.getParameter("button").equals("Save changes")) {
                
                cd.enableCourse(courseId);

                response.sendRedirect("home");
            }
        }

        
    }

}
