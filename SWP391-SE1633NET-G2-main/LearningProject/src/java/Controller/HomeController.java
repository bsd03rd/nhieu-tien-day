package Controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import Model.Course;
import Model.Notification;
import Model.User;
import dal.CourseDAO;
import dal.NotificationDAO;
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
 * @author Hieu Shin
 */
@WebServlet(name = "HomeController", urlPatterns = {"/home"})
public class HomeController extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HomeController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HomeController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CourseDAO cdao = new CourseDAO();
        UserDAO userDAO = new UserDAO();
        
        String courseName = request.getParameter("searching");
        if (courseName == null) {
            courseName = "";
        } else {
            courseName = request.getParameter("searching").trim();
        }
        
        //get all the Courses by CourseName - Searching
        ArrayList<Course> courses = cdao.getAllCoursesByCourseName(courseName);
        
        
        HttpSession session = request.getSession();

        if (session.getAttribute("username") != null) {
            String username = session.getAttribute("username").toString();
            NotificationDAO noticeDAO = new NotificationDAO();            
            ArrayList<Course> courseList = cdao.getAllUserCourse(username);
            ArrayList<Integer> courseIDs = new ArrayList<>();

            for (Course course : courseList) {
                courseIDs.add(course.getCourseID());
            }

            
            // if (session != null) {
            User user = (User) session.getAttribute("user");
            String avatar = user.getAvatar();

            request.setAttribute("usercourselist", cdao.getListUserCourseOfUser(user.getUserId(), ""));
            request.setAttribute("avatar", avatar);
            //}                        
            request.setAttribute("courseIDs", courseIDs);                        
            user = userDAO.getAllUserInformation(user.getUserName());
            request.setAttribute("user", user);            
        }
        request.setAttribute("courses", courses);       
        if(request.getParameter("sortby")!=null){
            if(request.getParameter("sortby").equals("Newst")){
                ArrayList<Course> courses1 = cdao.getAllCoursesByTime(courseName,"DESC");
                 request.setAttribute("courses", courses1);    
            }
            if(request.getParameter("sortby").equals("Oldest")){
                 ArrayList<Course> courses2 = cdao.getAllCoursesByTime(courseName,"ASC");
                 request.setAttribute("courses", courses2);    
            }
        }
        request.getRequestDispatcher("HomePage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            UserDAO ud = new UserDAO();
            String favourite = request.getParameter("favour");
            int courseId = Integer.parseInt(request.getParameter("courseID"));
            boolean isLike = false;
            if (session.getAttribute("username") != null) {
                User user = (User) session.getAttribute("user");
            
                if (favourite.equals("like")) {
                    ud.likeCourse(courseId, user.getUserId());
                    isLike = true;
                }
                else{
                    ud.unLikeCourse(courseId, user.getUserId());
                }
            }
            
            try (PrintWriter pw = response.getWriter()) {
                pw.print(isLike);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
