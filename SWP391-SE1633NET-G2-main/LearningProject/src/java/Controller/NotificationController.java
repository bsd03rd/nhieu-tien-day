/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Notification;
import Model.User;
import dal.NotificationDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author NamDepTraiVL
 */
@WebServlet(name = "NotificationController", urlPatterns = {"/notification"})
public class NotificationController extends HttpServlet {

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
            out.println("<title>Servlet NotificationController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NotificationController at " + request.getContextPath() + "</h1>");
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
        String value = request.getParameter("value");        
        ArrayList<Notification> noticeList = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy HH:mm:ss");
        NotificationDAO noticeDAO = new NotificationDAO();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(value.trim().equals("all")) noticeList = noticeDAO.getNotificationFromUser(user.getUserId(), 1);
        else if(value.trim().equals("unseen")) noticeList = noticeDAO.getNotificationFromUser(user.getUserId(), 0);
        for (Notification notice : noticeList) {
            out.println("<form action=\"notification\" method=\"POST\" id=\"submit-notice\">\n"
                    + "                        <div class=\"notification\">\n"
                    + "                            <div class=\"noti-icon\">\n"
                    + "                                <img src=\"assets/img/f8-logo.png\" alt=\"\">\n"
                    + "                            </div>\n"
                    + "                            <div class=\"noti-content\">\n"
                    + "                                <p>" + notice.getNoticeContent() + "</p>\n"
                    + "                                <div class=\"noti-time\">\n"
                    + "                                    " + formatter.format(notice.getNoticeDate()) + "\n"
                    + "                                </div>\n"
                    + "                            </div>                                    \n"
                    + "                            <button class=\"btn btn-primary\" type=\"submit\">Go</button>\n");
            if (!notice.isSeen()) {
                out.print("<div class=\"noti-remind\"></div>");
            }
            out.println("</div>\n"
                    + "                        <input type=\"hidden\" name=\"noticeid\" value=\""+notice.getNoticeID()+"\">\n"
                    + "                        <input type=\"hidden\" name=\"action\" value=\""+notice.getAction()+"\">\n"
                    + "                    </form>");
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
        NotificationDAO noticeDAO = new NotificationDAO();
        String action = request.getParameter("action");
        String noticeID = request.getParameter("noticeid");
        noticeDAO.MarkAsSeen(Integer.parseInt(noticeID));
        String[] actionList = action.split("\\s+");
        if (actionList[0].equals("Recharge")) {
            response.sendRedirect("transaction");
            return;
        } else if (actionList[0].equals("Enroll") || actionList[0].equals("Verify")) {
            response.sendRedirect("CourseDetails?id=" + actionList[1]);
            return;
        } else if(actionList[0].equals("Reply")){
            response.sendRedirect("WatchCourse?lessonID=" + actionList[1]);
        } else if(actionList[0].equals("Withdraw") || actionList[0].equals("Recharge")){
            response.sendRedirect("transaction");
        } else{
            response.sendRedirect("home");
        }
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
