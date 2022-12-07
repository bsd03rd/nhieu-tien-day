/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Course;
import dal.CourseDAO;
import dal.LessonDAO;
import dal.SectionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author vuman
 */
public class UpdateCourseController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            CourseDAO cd = new CourseDAO();
            int courseId = Integer.parseInt(request.getParameter("courseid"));

            if (request.getParameter("button") != null) {
                cd.enableCourse(courseId);

                response.sendRedirect("home");
            } else {
                Course course = cd.getAllCourseInformation(courseId);

                if (course.getStatus().equals("Enabled   ")) {
                    cd.disableCourse(courseId);
                    int newCourseId = cd.createClone(courseId);
                    course = cd.getAllCourseInformation(newCourseId);
                }

                String tmp = course.getObjectives();
                String[] objectiveList = tmp.split("[/]+");

                request.setAttribute("course", course);
                request.setAttribute("objectivelist", objectiveList);

                request.getRequestDispatcher("UpdateCourse.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            CourseDAO cd = new CourseDAO();

            int courseId = Integer.parseInt(request.getParameter("courseid"));
            Course course = cd.getAllCourseInformation(courseId);

            if (request.getParameter("button") != null) {
                if (request.getParameter("button").equals("Add Objectives")) {
                    String courseName = course.getCourseName();
                    if (request.getParameter("CourseTitle") != null) {
                        courseName = request.getParameter("CourseTitle");
                    }
                    String description = course.getDescription();
                    if (request.getParameter("CourseDes") != null) {
                        description = request.getParameter("CourseDes");
                    }
                    String image = course.getCourseImage();
                    if (request.getParameter("imageBase64") != null) {
                        image = request.getParameter("imageBase64");
                    }
                    String category = course.getCategory();
                    if (request.getParameter("category") != null) {
                        category = request.getParameter("category");
                    }
                    double price = course.getCoursePrice();
                    if (request.getParameter("CoursePrice") != null) {
                        price = Double.parseDouble(request.getParameter("CoursePrice"));
                    }

                    cd.updateSaveChangesCourse(courseId, courseName, description, image, category, "Disabled", price);
                    String objective = request.getParameter("objectivename");
                    cd.insertNewObjective(objective, courseId);

                    response.sendRedirect("updatecourse?courseid=" + courseId);
                }
                if (request.getParameter("button").equals("Delete course")) {
                    response.sendRedirect("home");
                }
                if (request.getParameter("button").equals("Save changes")) {
                    String courseName = course.getCourseName();
                    if (request.getParameter("CourseTitle") != null) {
                        courseName = request.getParameter("CourseTitle");
                    }
                    String description = course.getDescription();
                    if (request.getParameter("CourseDes") != null) {
                        description = request.getParameter("CourseDes");
                    }
                    String image = course.getCourseImage();
                    if (request.getParameter("imageBase64") != null) {
                        image = request.getParameter("imageBase64");
                    }
                    String category = request.getParameter("category");
                    if (request.getParameter("category") != null) {
                        category = request.getParameter("category");
                    }
                    double price = course.getCoursePrice();
                    if (request.getParameter("CoursePrice") != null) {
                        price = Double.parseDouble(request.getParameter("CoursePrice"));
                    }

                    cd.updateSaveChangesCourse(courseId, courseName, description, image, category, "Enabled", price);

                    response.sendRedirect("home");
                }
                if(request.getParameter("button").equals("Delete")){
                    cd.disableCourse(courseId);
                    response.sendRedirect("mentordashboard");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
