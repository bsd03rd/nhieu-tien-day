/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Comment;
import Model.Report;
import Model.User;
import Model.UserComment;
import Model.Video;
import dal.CommentDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
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
@WebServlet(name = "LoadCommentController", urlPatterns = {"/loadcomment"})
public class LoadCommentController extends HttpServlet {

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
            out.println("<title>Servlet LoadCommentController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoadCommentController at " + request.getContextPath() + "</h1>");
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
        CommentDAO commentDAO = new CommentDAO();
        HttpSession session = request.getSession();
        UserDAO userDAO = new UserDAO();
        User user = (User) session.getAttribute("user");
        int userId = user.getUserId();
        int lessonid = Integer.parseInt(request.getParameter("lessonid"));
        CommentDAO cmtDAO = new CommentDAO();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = new Date();

        String dateTime = sdf.format(d);

        Video video = commentDAO.getVideoIdByLessonId(lessonid);
        int videoId = video.getVideoId();

        String comment = request.getParameter("CommentContent");
        String commentContentReply = request.getParameter("commentContentReply");
        String CommentUpdate = request.getParameter("CommentUpdate");
        String CommentId = request.getParameter("CommentId");
        String op = request.getParameter("op");
        
        if (op == null) {
            op = "";
        }
        
       if (op.equals("Report")) {
           int CommentID = Integer.parseInt(CommentId);
            cmtDAO.insertIntoReport(userId, "Comment " + CommentID);
        } else if (op.equals("Reported")) {
            int CommentID = Integer.parseInt(CommentId);
            cmtDAO.deleteIntoReport(userId, "Comment " + CommentID);
        }
        
        if (op.equals("Like")) {
            int CommentID = Integer.parseInt(CommentId);
            cmtDAO.updateLikesOfCommentIncreaseByCommentId(CommentID);
            cmtDAO.insertIntoUserComment(CommentID, userId, 1);
        } else if (op.equals("Liked")) {
            int CommentID = Integer.parseInt(CommentId);
            cmtDAO.updateLikesOfCommentDecreaseByCommentId(CommentID);
            cmtDAO.deleteIntoUserComment(CommentID, userId);
        }

        if (CommentUpdate != null && CommentUpdate != "") {
            int CommentID = Integer.parseInt(CommentId);
            cmtDAO.updateCommentContentByCommentId(CommentUpdate, CommentID);
        }

        if (CommentId != null && CommentId != "" && op.equals("Delete")) {
            int CommentID = Integer.parseInt(CommentId);
            cmtDAO.deleteIntoComment(CommentID);
        }

        if (comment != null && comment != "") {
            commentDAO.insertIntoCommentContentReply(comment, videoId, userId, 0, dateTime);
        }

        if (commentContentReply != null && commentContentReply != "") {
            int parentCommentId = Integer.parseInt(request.getParameter("parentCommentId"));
            commentDAO.insertIntoCommentContentReply(commentContentReply, videoId, userId, parentCommentId, dateTime);
        }

        ArrayList<Comment> getAllComment = commentDAO.ListAllCommentByLessonID(lessonid);

        //get the ReportID by the user logined in the session
        ArrayList<Report> listReport = commentDAO.getAllReportByUserId(userId);
        ArrayList<String> cmtIdByUserReport = new ArrayList<>();

        for (Report rp : listReport) {
            cmtIdByUserReport.add(rp.getAction());
        }

        //get CommentID by the user logined in the session  
        ArrayList<UserComment> listUserComment = commentDAO.getAllUserCommentByUserId(userId);
        ArrayList<Integer> userCmtId = new ArrayList<>();
        for (UserComment userComment : listUserComment) {
            userCmtId.add(userComment.getCommentId());
        }

        //get All Parent Comment
        ArrayList<Comment> commentList = commentDAO.ListAllParentCommentByLessonID(lessonid);

        commentList.sort((o1, o2) -> o2.getCommentDate().compareTo(o1.getCommentDate()));
        getAllComment.sort((o1, o2) -> o2.getCommentDate().compareTo(o1.getCommentDate()));

        out.print("<div class=\"course-comment-list d-flex flex-column w-100 gap-4\" id=\"commentform\">\n");
        for (Comment parentComment : commentList) {
            out.println("                               \n"
                    + "                                <div class=\"comment d-flex align-items-start\">\n"
                    + "                                    <img src=\"" + parentComment.getUser().getAvatar() + "\" alt=\"none\" class=\"user-avatar\">\n"
                    + "                                    <div class=\"comment-content\">\n"
                    + "                                            <div class=\"comment-user\">\n"
                    + "                                                <div class=\"user-name\">\n"
                    + "                                                    " + parentComment.getUser().getLastName() + " " + parentComment.getUser().getFirstName() + "\n"
                    + "                                                </div>\n"
                    + "                                                <input name=\"commentContent\" style=\"border:none\" id=\"cmt" + parentComment.getCommentId() + "\" type=\"text\" value=\"" + parentComment.getCommentContent() + "\" disabled>\n"
                    + "                                            </div>\n"
                    + "                                            <div class=\"comment-action\">\n"
                    + "                                                <div id=\"Like" + parentComment.getCommentId() + "\">\n"
                    + "                                                    <input type=\"hidden\" name=\"lessonID\" value=\"${lessonID}\">\n"
                    + "                                                    <input type=\"hidden\" name=\"courseID\" value=\"${courseID}\">\n"
                    + "                                                    <input type=\"hidden\" name=\"sectionID\" value=\"${sectionID}\">\n"
                    + "                                                    <input type=\"hidden\" name=\"CommentID\" value=\"${parentComment.getCommentId()}\">\n");
            if (!userCmtId.contains(parentComment.getCommentId())) {
                out.println("<input style=\"border: none;background-color: white; color: #FD803A;\" type=\"button\" data-cmt-id=\"" + parentComment.getCommentId() + "\" onclick=\"likeComment(this)\" value=\"Like\"> ");
            } else {
                out.println("<input style=\"border: none;background-color: white; color: #FD803A;\" type=\"button\" data-cmt-id=\"" + parentComment.getCommentId() + "\" class=\"comment-action-content\" onclick=\"dislikeComment(this)\" value=\"Liked\">");
            }
            out.println("                                                </div>\n"
                    + "                                                    <div id=\"NumberLikes" + parentComment.getCommentId() + "\">" + parentComment.getLikes() + "</div>\n"
                    + "                                                <div class=\"comment-action-content comment-action-content-reply d-none\" id=\"Cancel" + parentComment.getCommentId() + "\" data-cmt-cancel-id=\"" + parentComment.getCommentId() + "\" onclick=\"disableOff(this)\"> Cancel</div>\n"
                    + "                                                <div class=\"dot\">.</div>\n");

            if (userId == parentComment.getUser().getUserId()) {
                out.print("                                                <div class=\"comment-action-content comment-action-content-reply\" id=\"Edit" + parentComment.getCommentId() + "\" data-cmt-id=\"" + parentComment.getCommentId() + "\" onclick=\"disableOn(this)\">Edit</div>\n"
                        + "                                                <input style=\"border: none;background-color: white; color: #FD803A;\" class=\"d-none\" id=\"Save" + parentComment.getCommentId() + "\" type=\"button\" name=\"op\" data-cmt-id=\"" + parentComment.getCommentId() + "\" onclick=\"saveComment(this)\" value=\"Save\">\n"
                        + "                                                <div class=\"dot\">.</div>\n");
            }

            out.print(
                    "                                                <div class=\"comment-action-content comment-action-content-reply\" id=\"Reply" + parentComment.getCommentId() + "\" data-cmt-reply=\"" + parentComment.getCommentId() + "\" onclick=\"show_reply_post_comment(this)\">Reply</div>\n"
                    + "                                                <div class=\"dot\" id=\"dotReply" + parentComment.getCommentId() + "\">.</div>\n"
                    + "                                                <div id=\"Report" + parentComment.getCommentId() + "\">\n"
                    + "                                                    \n"
                    + "                                                    <!--<form action=\"Report\" method=\"GET\">-->\n");

            if (cmtIdByUserReport.contains(parentComment.getCommentId())) {
                out.println("<input style=\"border: none;background-color: white; color: #FD803A;\" type=\"submit\" name=\"op\" class=\"comment-action-content\" value=\"Reported\">");
            } else {
                out.println("<input style=\"border: none;background-color: white; color: #FD803A;\" type=\"button\" data-cmt-id=\""+ parentComment.getCommentId() +"\" onclick=\"reportComment(this)\" class=\"comment-action-content\" value=\"Report\">");
            }
            out.println(
                    "                                                        \n"
                    + "                                                    <!--</form>-->\n"
                    + "                                                </div>\n"
                    + "                                                <div class=\"dot\" id=\"dotReport" + parentComment.getCommentId() + "\">.</div>\n");

            if (userId == parentComment.getUser().getUserId()) {
                out.print(
                        " <input style=\"border: none;background-color: white; color: #FD803A;\" type=\"button\" data-cmt-id=\"" + parentComment.getCommentId() + "\" onclick=\"deleteComment(this)\" class=\"comment-action-content\" value=\"Delete\">       \n"
                        + "      <div class=\"dot\" id=\"dotReport" + parentComment.getCommentId() + "\">.</div>\n");
            }

            out.println(
                    "                                                <div class=\"comment-create-day\" style=\"color: rgba(0, 0, 0, 0.4); font-weight: 600;\">" + parentComment.getCommentDate() + "</div>\n"
                    + "                                            </div>\n"
                    + "                                        <!-- Reply Comment -->\n"
                    + "\n"
                    + "                                        <div class=\"reply-comment d-none\" id=\"ShowReply" + parentComment.getCommentId() + "\">\n"
                    + "                                                <input type=\"hidden\" name=\"lessonID\" value=\"${lessonID}\">\n"
                    + "                                                <input type=\"hidden\" name=\"courseID\" value=\"${courseID}\">\n"
                    + "                                                <input type=\"hidden\" name=\"sectionID\" value=\"${sectionID}\">\n"
                    + "                                                <input type=\"hidden\"  name=\"videoID\" value=\"${videoID}\">\n"
                    + "                                                <div class=\"course-post-comment-container\">\n"
                    + "                                                    <div class=\"course-comment-postcomment d-flex justify-content-between\">\n"
                    + "                                                        <img src=\"" + user.getAvatar() + "\" alt=\"none\" class=\"user-avatar\">\n"
                    + "                                                        <!-- <input type=\"text\" class=\"content\" placeholder=\"Comment\" style=\"    width: 90%;\n"
                    + "                                                        border: none;\n"
                    + "                                                        border-bottom: 1px solid rgba(0, 0, 0, 0.2); outline: none;\"> -->\n"
                    + "                                                        <textarea name=\"repComment\" id=\"commentContentReply" + parentComment.getCommentId() + "\" oninput=\"auto_height(this); active_comment_button(this)\"></textarea>"
                    + "                                                    </div>\n"
                    + "                                                    <div class=\"course-postcomment-action\" style=\"float: right;\">\n"
                    + "                                                        <div class=\"post-cancel d-inline-block me-4 fw-bold\" data-cmt-cancel-id=\"" + parentComment.getCommentId() + "\" onclick=\"CancelReply(this)\">Cancel</div>\n"
                    + "\n"
                    + "                                                       <button name=\"op\" value=\"Reply\" onclick=\"ReplyComment(this)\" data-cmt-id=\"" + parentComment.getCommentId() + "\" class=\"submit-comment\">Reply</button>                                     \n"
                    + "                                                        <input type=\"hidden\" id=\"parentCommentId" + parentComment.getCommentId() + "\" name=\"pId\" value=\"" + parentComment.getCommentId() + "\">\n"
                    + "                                                    </div>\n"
                    + "                                                </div>\n"
                    + "                                        </div>\n"
                    + "                                        <!-- Reply Comment -->\n"
                    + "\n"
                    + "\n"
                    + "                                        <!-- Show Reply Comment -->\n"
                    + "                                        <div class=\"show-reply-comment \" style=\"margin-left: 20px; margin-top: 10px;\">\n"
                    + "                                            <!--                                            <h6>Show reply comment<i class=\"fa-solid fa-chevron-down\"></i></h6>-->\n"
                    + "                                            <div class=\"show-reply-comment-content\">\n"
                    + "                                                <!-------------------------- Begin: Comment ------------------------------------------>\n"
                    + "\n");

            for (Comment allComment : getAllComment) {
                if (allComment.getParentId() == parentComment.getCommentId()) {
                    out.println(
                            "                                                        <div class=\"comment d-flex align-items-start\">\n"
                            + "                                                            <img src=\"" + allComment.getUser().getAvatar() + "\" alt=\"none\" class=\"user-avatar\">\n"
                            + "                                                            <div class=\"comment-content\">\n"
                            + "\n"
                            + "                                            <div class=\"comment-user\">\n"
                            + "                                                <div class=\"user-name\">\n"
                            + allComment.getUser().getLastName() + " " + allComment.getUser().getFirstName()
                            + "                                                </div>\n"
                            + "                                                <input name=\"commentContent\" style=\"border:none\" id=\"cmt" + allComment.getCommentId() + "\" type=\"text\" value=\"" + allComment.getCommentContent() + "\" disabled>\n"
                            + "                                            </div>\n"
                            + "                                            <div class=\"comment-action\">\n"
                            + "                                                <div id=\"Like" + allComment.getCommentId() + "\">\n"
                            + "                                                    <input type=\"hidden\" name=\"lessonID\" value=\"${lessonID}\">\n"
                            + "                                                    <input type=\"hidden\" name=\"courseID\" value=\"${courseID}\">\n"
                            + "                                                    <input type=\"hidden\" name=\"sectionID\" value=\"${sectionID}\">\n"
                            + "                                                    <input type=\"hidden\" name=\"CommentID\" value=\"${commentOfLesson.getCommentId()}\">\n");

                    if (!userCmtId.contains(allComment.getCommentId())) {
                out.println("<input style=\"border: none;background-color: white; color: #FD803A;\" type=\"button\" data-cmt-id=\"" + allComment.getCommentId() + "\" onclick=\"likeComment(this)\" value=\"Like\"> ");
            } else {
                out.println("<input style=\"border: none;background-color: white; color: #FD803A;\" type=\"button\" data-cmt-id=\"" + allComment.getCommentId() + "\" class=\"comment-action-content\" onclick=\"dislikeComment(this)\" value=\"Liked\">");
            }

                    out.println(
                            "                                                </div>\n"
                            + "                                                    <div id=\"NumberLikes" + allComment.getCommentId() + "\">" + allComment.getLikes() + "</div>\n"
                            + "                                                <div class=\"comment-action-content comment-action-content-reply d-none\" id=\"Cancel" + allComment.getCommentId() + "\" data-cmt-cancel-id=\"" + allComment.getCommentId() + "\" onclick=\"disableOff(this)\"> Cancel</div>\n"
                            + "                                                <div class=\"dot\">.</div>\n"
                            + "                                                <div class=\"comment-action-content comment-action-content-reply\" id=\"Edit" + allComment.getCommentId() + "\" data-cmt-id=\"" + allComment.getCommentId() + "\" onclick=\"disableOn(this)\">Edit</div>\n"
                            + "                                                <input style=\"border: none;background-color: white; color: #FD803A;\" class=\"d-none\" id=\"Save" + allComment.getCommentId() + "\" type=\"button\" data-cmt-id=\"" + allComment.getCommentId() + "\" onclick=\"saveComment(this)\"  value=\"Save\">\n"
                            + "                                                <div class=\"dot\">.</div>\n"
                            + "                                                <div class=\"comment-action-content comment-action-content-reply\" id=\"Reply" + allComment.getCommentId() + "\" onclick=\"show_reply_post_comment(this)\">Reply</div>\n"
                            + "                                                <div class=\"dot\" id=\"dotReply" + allComment.getCommentId() + "\">.</div>\n"
                            + "                                                <div id=\"Report" + allComment.getCommentId() + "\">\n"
                            + "                                                    <!--<form action=\"Report\" method=\"GET\">-->\n"
                            + "\n");

                    if (cmtIdByUserReport.contains(allComment.getCommentId())) {
                        out.println("<input style=\"border: none;background-color: white; color: #FD803A;\" type=\"submit\" name=\"op\" class=\"comment-action-content\" value=\"Reported\">");
                    } else {
                        out.println("<input style=\"border: none;background-color: white; color: #FD803A;\" type=\"button\" data-cmt-id=\""+allComment.getCommentId()+"\" onclick=\"reportComment(this)\" class=\"comment-action-content\" value=\"Report\">");
                    }

                    out.println(
                            "                                                    <!--</form>-->\n"
                            + "                                                </div>\n"
                            + "                                                <div class=\"dot\" id=\"dotReport" + allComment.getCommentId() + "\">.</div>\n");

                    if (userId == allComment.getUser().getUserId()) {
                        out.print(
                                " <input style=\"border: none;background-color: white; color: #FD803A;\" type=\"button\" data-cmt-id=\"" + allComment.getCommentId() + "\" onclick=\"deleteComment(this)\" class=\"comment-action-content\" value=\"Delete\">       \n"
                                + "      <div class=\"dot\" id=\"dotReport" + allComment.getCommentId() + "\">.</div>\n");
                    }

                    out.print(
                            "                                                <div class=\"comment-create-day\" style=\"color: rgba(0, 0, 0, 0.4); font-weight: 600;\">" + allComment.getCommentDate() + "</div>\n"
                            + "                                            </div>\n"
                            + "\n"
                            + "                                                                <!-- Reply Comment -->\n"
                            + "\n"
                            + "                                                                <div class=\"reply-comment d-none\">\n"
                            + "                                                                    <div class=\"course-post-comment-container\">\n"
                            + "                                                                        <div class=\"course-comment-postcomment d-flex justify-content-between\">\n"
                            + "                                                                            <img src=\"assets/img/f8-logo.png\" alt=\"\" class=\"user-avatar\">\n"
                            + "                                                                            <!-- <input type=\"text\" class=\"content\" placeholder=\"Comment\" style=\"    width: 90%;\n"
                            + "                                                                            border: none;\n"
                            + "                                                                            border-bottom: 1px solid rgba(0, 0, 0, 0.2); outline: none;\"> -->\n"
                            + "                                                                            <textarea id=\"commentContentReply\" name=\"repComment\" oninput=\"auto_height(this); active_comment_button(this)\"></textarea>\n"
                            + "                                                                        </div>\n"
                            + "                                                                        <div class=\"course-postcomment-action\" style=\"float: right;\">\n"
                            + "                                                                            <p class=\"post-cancel d-inline-block me-4 fw-bold\">Cancel</p>\n"
                            + "\n"
                            + "                                                                            <input type=\"submit\" name=\"\" value=\"Reply\" class=\"submit-comment\">                                     \n"
                            + "\n"
                            + "                                                                        </div>\n"
                            + "                                                                    </div>\n"
                            + "                                                                </div>\n"
                            + "                                                                <!-- Reply Comment -->\n"
                            + "\n"
                            + "\n"
                            + "                                                                <!-- Show Reply Comment -->\n"
                            + "                                                                <div class=\"show-reply-comment d-none\" style=\"margin-left: 20px; margin-top: 10px;\">\n"
                            + "                                                                    <h6>Show reply comment<i class=\"fa-solid fa-chevron-down\"></i></h6>\n"
                            + "                                                                    <div class=\"show-reply-comment-content\">\n"
                            + "\n"
                            + "                                                                    </div>\n"
                            + "                                                                </div>\n"
                            + "                                                                <!-- Show Reply Comment -->\n"
                            + "                                                            </div>\n"
                            + "                                                        </div>\n");
                }
            }
            out.println(
                    "\n"
                    + "                                                <!---------------------------------------- End: Comment ---------------------------------->\n"
                    + "                                            </div>\n"
                    + "                                        </div>\n"
                    + "                                        <!-- Show Reply Comment -->\n"
                    + "                                    </div>\n"
                    + "                                </div>\n"
                    + "\n");
        }

        out.print("</div>\n");

        out.print("<script src=\"assets/js/course_watch.js\"></script>");

        out.print("<script>\n");
        out.print(
                "        function loadAllComment() {\n"
                + "            var Comment = document.getElementById(\"commentContent\").value;\n"
                + "            \n"
                + "            $.ajax({\n"
                + "                url: \"/LearningProject/loadcomment\",\n"
                + "                type: 'GET',\n"
                + "                data:'lessonid=${lessonID}&&CommentContent='+Comment, \n"
                + "                success: function (data) {\n"
                + "                    var row = document.getElementById(\"commentform\");\n"
                + "                    row.innerHTML = data;\n"
                + "                },\n"
                + "                error: function () {\n"
                + "                    console.log('Error');\n"
                + "                }\n"
                + "            });\n"
                + "            document.getElementById(\"commentContent\").value='';\n"
                + "        }\n"
                + "        \n"
                + "        function ReplyComment(input) {\n"
                + "            var ReplyComment = document.querySelector('#commentContentReply' + input.getAttribute(\"data-cmt-id\")).value;\n"
                + "            var parentCommentId = document.querySelector('#parentCommentId' + input.getAttribute(\"data-cmt-id\")).value;         \n"
                + "            \n"
                + "            $.ajax({\n"
                + "                url: \"/LearningProject/loadcomment\",\n"
                + "                type: 'GET',\n"
                + "                data:'lessonid=${lessonID}&&commentContentReply='+ReplyComment+'&&parentCommentId='+parentCommentId, \n"
                + "                success: function (data) {\n"
                + "                    var row = document.getElementById(\"commentform\");\n"
                + "                    row.innerHTML = data;\n"
                + "                },\n"
                + "                error: function () {\n"
                + "                    console.log('Error');\n"
                + "                }\n"
                + "            });\n"
                + "        }\n");

        out.print(" function saveComment(input) {\n"
                + "            var CommentUpdate = document.querySelector('#cmt' + input.getAttribute(\"data-cmt-id\")).value;\n"
                + "            var CommentId =  input.getAttribute(\"data-cmt-id\");         \n"
                + "            \n"
                + "            $.ajax({\n"
                + "                url: \"/LearningProject/loadcomment\",\n"
                + "                type: 'GET',\n"
                + "                data:'lessonid=${lessonID}&&CommentUpdate='+CommentUpdate+'&&CommentId='+CommentId, \n"
                + "                success: function (data) {\n"
                + "                    var row = document.getElementById(\"commentform\");\n"
                + "                    row.innerHTML = data;\n"
                + "                },\n"
                + "                error: function () {\n"
                + "                    console.log('Error');\n"
                + "                }\n"
                + "            });\n"
                + "        }");

        out.println(" function deleteComment(input) {\n"
                + "            \n"
                + "            var CommentId =  input.getAttribute(\"data-cmt-id\");         \n"
                + "            \n"
                + "            $.ajax({\n"
                + "                url: \"/LearningProject/loadcomment\",\n"
                + "                type: 'GET',\n"
                + "                data:'lessonid=${lessonID}&&CommentId='+CommentId+'&&op=Delete', \n"
                + "                success: function (data) {\n"
                + "                    var row = document.getElementById(\"commentform\");\n"
                + "                    row.innerHTML = data;\n"
                + "                },\n"
                + "                error: function () {\n"
                + "                    console.log('Error');\n"
                + "                }\n"
                + "            });\n"
                + "        }");

        out.print(" function likeComment(input) {\n"
                + "            \n"
                + "            var CommentId =  input.getAttribute(\"data-cmt-id\");         \n"
                + "            \n"
                + "            $.ajax({\n"
                + "                url: \"/LearningProject/loadcomment\",\n"
                + "                type: 'GET',\n"
                + "                data:'lessonid=${lessonID}&&CommentId='+CommentId+'&&op=Like', \n"
                + "                success: function (data) {\n"
                + "                    var row = document.getElementById(\"commentform\");\n"
                + "                    row.innerHTML = data;\n"
                + "                },\n"
                + "                error: function () {\n"
                + "                    console.log('Error');\n"
                + "                }\n"
                + "            });\n"
                + "        }\n"
                + "        \n"
                + "        function dislikeComment(input) {\n"
                + "            \n"
                + "            var CommentId =  input.getAttribute(\"data-cmt-id\");         \n"
                + "            \n"
                + "            $.ajax({\n"
                + "                url: \"/LearningProject/loadcomment\",\n"
                + "                type: 'GET',\n"
                + "                data:'lessonid=${lessonID}&&CommentId='+CommentId+'&&op=Liked', \n"
                + "                success: function (data) {\n"
                + "                    var row = document.getElementById(\"commentform\");\n"
                + "                    row.innerHTML = data;\n"
                + "                },\n"
                + "                error: function () {\n"
                + "                    console.log('Error');\n"
                + "                }\n"
                + "            });\n"
                + "        }");

        out.print("function reportComment(input) {\n" +
"            \n" +
"            var CommentId =  input.getAttribute(\"data-cmt-id\");         \n" +
"            \n" +
"            $.ajax({\n" +
"                url: \"/LearningProject/loadcomment\",\n" +
"                type: 'GET',\n" +
"                data:'lessonid=${lessonID}&&CommentId='+CommentId+'&&op=Report', \n" +
"                success: function (data) {\n" +
"                    var row = document.getElementById(\"commentform\");\n" +
"                    row.innerHTML = data;\n" +
"                },\n" +
"                error: function () {\n" +
"                    console.log('Error');\n" +
"                }\n" +
"            });\n" +
"        }");
        
        out.println(
                "        </script>");

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
        processRequest(request, response);
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
