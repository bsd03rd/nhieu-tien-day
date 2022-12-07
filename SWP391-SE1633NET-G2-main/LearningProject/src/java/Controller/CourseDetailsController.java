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
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author Dung
 */
@WebServlet(urlPatterns = {"/CourseDetails"}, name = "CourseDetailsController")
public class CourseDetailsController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CourseDetailsController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CourseDetailsController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CourseDAO cdao = new CourseDAO();
        SectionDAO sectionDao = new SectionDAO();
        LessonDAO lessonDAO = new LessonDAO();
        CourseDAO cDAO = new CourseDAO();
        UserDAO u = new UserDAO();

        int courseID = Integer.parseInt(request.getParameter("id"));

        HttpSession session = request.getSession();
        User user = new User();
        if (session.getAttribute("user") != null) {
            user = (User) session.getAttribute("user");
            //get user id and course id
            int UserID = u.getAllUserInformation(session.getAttribute("username").toString()).getUserId();
            int CourseID = Integer.parseInt(request.getParameter("id"));
            UserCourse UserCourse = cDAO.getUserCourseInformation(CourseID, UserID);
            //set UserCourse that the user enroll or unenroll
            request.setAttribute("UserCourse", UserCourse);
        }

        Course course = cdao.getCourseInformation(courseID);
        // Add course objectives
        String courseObjectives = course.getObjectives();
        String[] objective = courseObjectives.split("[/]+");
        request.setAttribute("objective", objective);

        // Get feedback list
        ArrayList<Feedback> feedbackList = cdao.getFeedBack(courseID);
        // Get section list
        ArrayList<Section> sectionList = sectionDao.getAllSectionOfCourse(courseID);
        // Get lesson list
        ArrayList<Lesson> lessonList = new ArrayList<Lesson>();
        for (Section section : sectionList) {
            ArrayList<Lesson> tmp = lessonDAO.getAllLessonOfSection(section.getSectionId());
            for (Lesson lesson : tmp) {
                lessonList.add(lesson);
            }
        }

        double avgStar = 0;
        for (Feedback feedback : feedbackList) {
            avgStar += feedback.getRating();
        }
        if(avgStar != 0){
            avgStar = avgStar / feedbackList.size();
        }
        
        String pageIndex = request.getParameter("pageIndex");
        int page;
        
        if(pageIndex==null){
            page=1;
        }else{
            page=Integer.parseInt(pageIndex);
        } 
        
        int size = feedbackList.size();
        final int PAGE_SIZE = 5;
        int numOfPages = ( size%PAGE_SIZE ==0 )? size/PAGE_SIZE : size/PAGE_SIZE+1;
        int start = (page - 1)*PAGE_SIZE;
        int end = Math.min(size, page*PAGE_SIZE);
        
        ArrayList<Feedback> listFeedbackByPage = cdao.getFeedbackByPage(feedbackList, start, end);
        
        request.setAttribute("numOfPages", numOfPages);
        request.setAttribute("listFeedbackByPage", listFeedbackByPage);
        request.setAttribute("averageStar", avgStar);
        request.setAttribute("avg", (int)avgStar);
        request.setAttribute("avgup", (int)avgStar + 1);
        request.setAttribute("feedbackList", feedbackList);
        request.setAttribute("checkDup", new UserDAO().checkDupFeedback(user.getUserId(), courseID));
        request.setAttribute("course", course);
        request.setAttribute("sectionList", sectionList);
        request.setAttribute("lessonList", lessonList);
        int time = cdao.getCourseTime(course.getCourseID());
        String totalTime = (time / 1000) / 60 / 60 % 24 + " hours " + (time / 1000) / 60 % 60 + " minutes " + (time / 1000) % 60 + " seconds ";
        request.setAttribute("totalTime", totalTime);
        request.getRequestDispatcher("CourseDetails.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            double star = Double.parseDouble(request.getParameter("star"));
            String feedback = request.getParameter("feedback");
            int courseid = Integer.parseInt(request.getParameter("courseid"));

            HttpSession session = request.getSession();
            User user = new User();
            if (session != null) {
                user = (User) session.getAttribute("user");
            }

            new UserDAO().insertFeedbackAndStar(user.getUserId(), courseid, star, feedback);

            response.sendRedirect("CourseDetails?id=" + courseid);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
