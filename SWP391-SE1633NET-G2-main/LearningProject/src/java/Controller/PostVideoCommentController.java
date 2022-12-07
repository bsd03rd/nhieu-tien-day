/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Comment;
import Model.Video;
import dal.CommentDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class PostVideoCommentController extends HttpServlet {

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
            out.println("<title>Servlet PostCommentVideoController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PostCommentVideoController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *` 
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        Date date = new Date();
//        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        Date d = new Date(); 
        
        String dateTime = sdf.format(d);
        
        UserDAO userDAO = new UserDAO();
        CommentDAO cmtDao = new CommentDAO();

      //  ArrayList<Comment> commentList = cmtDao.ListAllComment();
        HttpSession ses = request.getSession();

        //get all comment to display into screen
        String username = (String) ses.getAttribute("username");
        int userId = userDAO.getAllUserInformation(username).getUserId();
       
        int getLessonId = Integer.parseInt(request.getParameter("lessonID"));
        ArrayList<Comment> parentComment = cmtDao.ListAllParentCommentByLessonID(getLessonId);
        
        Video video = cmtDao.getVideoIdByLessonId(getLessonId);
        int videoId = video.getVideoId();

        //cmtList for comment      
        try {
            String comment = request.getParameter("comment");
            String op = request.getParameter("op");

            if (op.equals("Comment")) {
                cmtDao.insertIntoCommentContentReply(comment, videoId, userId, 0, dateTime);
            } else if (op.equals("Reply")) {
                //insert reply comment and the parent id
                String repComment = request.getParameter("repComment");
                int pId = Integer.parseInt(request.getParameter("pId"));
                //insert into comment that is a reply comment
                cmtDao.insertIntoCommentContentReply(repComment, videoId, userId, pId, dateTime);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("parentComment", parentComment);

        response.sendRedirect("WatchCourse?courseID=" + request.getParameter("courseID") 
                + "&sectionID=" + request.getParameter("sectionID") 
                + "&lessonID=" + request.getParameter("lessonID"));
//        response.sendRedirect("loadcomment?lessonid=" + request.getParameter("lessonID") );
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
