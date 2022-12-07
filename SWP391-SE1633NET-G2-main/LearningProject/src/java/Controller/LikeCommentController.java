/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import Model.Report;
import Model.UserComment;
import dal.CommentDAO;
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
 * @author ASUS
 */
public class LikeCommentController extends HttpServlet {
   
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
            out.println("<title>Servlet LikeCommentController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LikeCommentController at " + request.getContextPath () + "</h1>");
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
        CommentDAO cmtDAO = new CommentDAO();
        UserDAO uDAO = new UserDAO();
        
        HttpSession ses = request.getSession();
        String username = (String)ses.getAttribute("username");
        int userId = uDAO.getAllUserInformation(username).getUserId();
        
        int CommentID = Integer.parseInt(request.getParameter("CommentID"));
        
        String op = request.getParameter("op");
       
        String commentContent = request.getParameter("commentContent");
        
        //get all cmtId that User Liked
        ArrayList<UserComment> listUserComment = cmtDAO.getAllUserCommentByUserId(userId);
        ArrayList<Integer> userCmtId = new ArrayList<>();
        //get all cmtId that User Reported
        
        ArrayList<Report> listReport = cmtDAO.getAllReportByUserId(userId);
        
        ArrayList<String> userCommentReport = new ArrayList<>();
        
        //Get all cmtID by userID        
        for (UserComment userComment : listUserComment) {
            userCmtId.add(userComment.getCommentId());
        }
        
        //update
        if (op.equals("Save")) {
               cmtDAO.updateCommentContentByCommentId(commentContent, CommentID);
        }
        
        //like and dislike
        if (op.equals("Like")) {
            cmtDAO.updateLikesOfCommentIncreaseByCommentId(CommentID);
            cmtDAO.insertIntoUserComment(CommentID, userId, 1);
        } else if (op.equals("Liked")) {
            cmtDAO.updateLikesOfCommentDecreaseByCommentId(CommentID);
            cmtDAO.deleteIntoUserComment(CommentID, userId);
        }
        
        if (op.equals("Delete")) {
//            cmtDAO.deleteIntoUserComment(CommentID, userId);
//            cmtDAO.deleteIntoReport(userId, CommentID);
            cmtDAO.deleteIntoComment(CommentID);
        }
        
        
        //list all cmtId by UserID in report
        for (Report report : listReport) {
            userCommentReport.add(report.getAction());
        }
        
        
        //insert and delete into report
        if (op.equals("Report")) {
            cmtDAO.insertIntoReport(userId, "Comment " + CommentID);
        } else if (op.equals("Reported")) {
            cmtDAO.deleteIntoReport(userId, "Comment " + CommentID);
        }
        
        //get all cmtID in Report of User
        request.setAttribute("userCommentReport", userCommentReport);
        
        //get all cmtID in UserComment of User
        request.setAttribute("userCmtId", userCmtId);
        response.sendRedirect("WatchCourse?courseID=" + request.getParameter("courseID") 
                + "&sectionID=" + request.getParameter("sectionID") 
                + "&lessonID=" + request.getParameter("lessonID"));
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
        processRequest(request, response);
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
