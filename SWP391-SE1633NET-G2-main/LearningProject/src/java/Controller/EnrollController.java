/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Course;
import Model.User;
import Model.UserCourse;
import dal.CourseDAO;
import dal.NotificationDAO;
import dal.PaymentDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Date;
import org.apache.tomcat.util.net.SSLSupport;
import utils.SendEmail;

/**
 *
 */
public class EnrollController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Enroll in Course Detail
        CourseDAO cDAO = new CourseDAO();
        UserDAO u = new UserDAO();
        HttpSession ses = request.getSession();
        //enroll in course detail
        String op = request.getParameter("op");
        int CourseID = Integer.parseInt(request.getParameter("id"));
        if (op.equals("Enroll") && ses.getAttribute("username") != null) {
            int UserID = u.getAllUserInformation(ses.getAttribute("username").toString()).getUserId();
            u.insertIntoUserCourse(UserID, CourseID);
            cDAO.UpdateNumberEnrolledCourse(CourseID);
            request.getRequestDispatcher("CourseDetails").forward(request, response);
        } else {
            response.sendRedirect("login");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //Enroll in home page
        UserDAO u = new UserDAO();
        CourseDAO cDAO = new CourseDAO();
        NotificationDAO noticeDAO = new NotificationDAO();
        HttpSession ses = request.getSession();
        int CourseID = Integer.parseInt(request.getParameter("courseID"));
        String op = request.getParameter("op");
        SendEmail sendemail = new SendEmail();

        PaymentDAO paymentDAO = new PaymentDAO();
        Course course = cDAO.getAllCourseInformation(CourseID);
        if (op.equals("Enroll") && ses.getAttribute("username") != null) {
            int UserID = u.getAllUserInformation(ses.getAttribute("username").toString()).getUserId();
            //noticeDAO.sendNotification(user.getUserId(), "C???m ??n b???n ???? tham gia kh??a h???c" + course.getCourseName(), "Enroll "+CourseID);            
            
            u.insertIntoUserCourse(UserID, CourseID);
            cDAO.UpdateNumberEnrolledCourse(CourseID);
            response.sendRedirect("home");

        } else if (op.equals("Go to Course") && ses.getAttribute("username") != null) {
            response.sendRedirect("WatchCourse?courseID=" + CourseID);
        } else if ((op.equals("Buy now") && ses.getAttribute("username") != null)) {
            User tmp = (User) ses.getAttribute("user");
            User user = u.getAllUserInformationByID(tmp.getUserId());
            double coursePrice = course.getCoursePrice();
            System.err.println("khoa hoc nay co gia laaaaaaaaaaaaaaaa:"+course.getCoursePrice());
            if (user.getBalance() < coursePrice) {
                PrintWriter out = response.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("alert('T??i kho???n kh??ng ????? ti???n ????? mua kh??a h???c, vui l??ng n???p th??m');");
                out.println("location='recharge';");
                out.println("</script>");
                return;
            }
            Date date = new Date();
            java.sql.Date sqldate = new java.sql.Date(date.getTime());
            paymentDAO.userRecharge(user.getUserId(), sqldate, (-coursePrice), 0, "Buy", "Buy course " + course.getCourseName());
            //noticeDAO.sendNotification(user.getUserId(), "C???m ??n b???n ???? mua kh??a h???c" + course.getCourseName(), "Enroll "+CourseID);            
            u.insertIntoUserCourse(user.getUserId(), CourseID);
            sendemail.sendEmail(user.getEmail(), "Mua kh??a h???c th??nh c??ng", "C???m ??n b???n ???? mua kh??a h???c "+course.getCourseName()+" t??? trang web ch??ng t??i!");
            
            User newuser = u.getAllUserInformationByID(user.getUserId());
            ses.setAttribute("user", newuser);
            response.sendRedirect("home");
        } else {
            response.sendRedirect("login");
        }

    }

}
