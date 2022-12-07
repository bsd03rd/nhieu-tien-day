/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Docs;
import Model.Lesson;
import Model.Quiz;
import Model.Section;
import Model.User;
import Model.Video;
import dal.DocsDAO;
import dal.LessonDAO;
import dal.QuizDAO;
import dal.SectionDAO;
import dal.VideoDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author Hieu Shin
 */
public class AddLesson extends HttpServlet {

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
        if (request.getSession().getAttribute("user") != null) {
            User user = (User) request.getSession().getAttribute("user");
            if (user.getRole().equals("Admin")) {
                int sectionId = 0;
                int courseID = 0;
                if (request.getParameter("sectionID") != null && request.getParameter("courseID") != null) {
                    ArrayList<Lesson> lessons = new ArrayList<>();
                    ArrayList<Video> videolist = new ArrayList<Video>();
                    ArrayList<Docs> docslist = new ArrayList<Docs>();
                    ArrayList<Quiz> quizlist = new ArrayList<Quiz>();
                    
                    sectionId = Integer.parseInt(request.getParameter("sectionID"));
                    courseID = Integer.parseInt(request.getParameter("courseID"));
                    SectionDAO sectionDAO = new SectionDAO();
                    LessonDAO ldao = new LessonDAO();
                    VideoDAO vd = new VideoDAO();
                    DocsDAO dd = new DocsDAO();
                    QuizDAO qd = new QuizDAO();
                    lessons = ldao.getAllLessonOfSection(sectionId);
                    Section section = sectionDAO.getSectionBySectionID(sectionId);
                    
                    for (Lesson lesson : lessons) {
                        if (lesson.getType().equals("Video")) {
                            videolist.add(vd.getVideoOfLesson(lesson.getLessonId()));
                        } else if (lesson.getType().equals("Docs")) {
                            docslist.add(dd.getDocsOfLesson(lesson.getLessonId()));
                        } else {
                            quizlist.add(qd.getQuizOfLesson(lesson.getLessonId()));
                        }
                        
                    }
                    
                    request.setAttribute("quizlist", quizlist);
                    request.setAttribute("videolist", videolist);
                    request.setAttribute("docslist", docslist);
                    request.setAttribute("courseID", courseID);
                    request.setAttribute("lessons", lessons);
                    request.setAttribute("sectionID", sectionId);
                    request.setAttribute("section", section);
                    request.getRequestDispatcher("CreateLesson.jsp").forward(request, response);
                    return;
                }
                response.sendRedirect("AddLesson?courseID=" + courseID + "&sectionID=" + sectionId);
            } else {
                response.sendRedirect("home");
            }
        } else {
            response.sendRedirect("home");
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
        int sectionId = Integer.parseInt(request.getParameter("sectionID"));
        int courseID = Integer.parseInt(request.getParameter("courseID"));
        String type = request.getParameter("type");
        
        LessonDAO ldao = new LessonDAO();
        
        if (type != null) {
            if (type.compareTo("Video") == 0) {
                String videotitle = request.getParameter("video_title");
                String videolink = request.getParameter("video_url");
                int duration = Integer.parseInt(request.getParameter("duration"));
                ldao.addLessonVideo(sectionId, videotitle, videotitle, videolink, duration);
            }
            
            if (type.compareTo("Docs") == 0) {
                String lesson_tilte = request.getParameter("lesson_tilte");
                int time_to_read = Integer.parseInt(request.getParameter("time_to_read"));
                String lesson_content = request.getParameter("lesson_content");
                ldao.addLessonDoc(sectionId, lesson_tilte, time_to_read, lesson_content);
            }
            if (type.compareTo("Quiz") == 0) {
                String lesson_title = request.getParameter("lessonTitle");
                int lesson_time = Integer.parseInt(request.getParameter("lessonTime"));
                ldao.addLessonQuiz(new Lesson(0, sectionId, lesson_title, false, "Quiz", false, lesson_time));
                int lessonID = ldao.getNewestLessonID(sectionId);
                QuizDAO quizDAO = new QuizDAO();
                quizDAO.addQuiz(lessonID);
            }
        }
        
        if (request.getParameter("button") != null) {
            if (request.getParameter("button").equals("Update document")) {
                int lessonId = Integer.parseInt(request.getParameter("LessonDocsId"));
                String lessonName = request.getParameter("LessonDocsName");
                int time = Integer.parseInt(request.getParameter("Time"));
                String docsContent = request.getParameter("DocsContent");
                
                ldao.updateLessonDocs(lessonName, time, docsContent, lessonId);
            }
            if (request.getParameter("button").equals("Update video")) {
                int lessonId = Integer.parseInt(request.getParameter("LessonVideoId"));
                String lessonName = request.getParameter("LessonVideoName");
                String videoLink = request.getParameter("videolink");
                int time = Integer.parseInt(request.getParameter("time_duration"));
                
                ldao.updateLessonVideo(lessonName, videoLink, lessonId, time);
                
            }
            if (request.getParameter("button").equals("Update quiz")) {
                int lessonId = Integer.parseInt(request.getParameter("LessonQuizId"));
                String lessonName = request.getParameter("LessonQuizTitle");
                int time = Integer.parseInt(request.getParameter("LessonQuizTime"));
                
                ldao.updateLessonQuiz(lessonName, time, lessonId);
                
            }
            
        }
        
        response.sendRedirect("AddLesson?courseID=" + courseID + "&sectionID=" + sectionId);
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
