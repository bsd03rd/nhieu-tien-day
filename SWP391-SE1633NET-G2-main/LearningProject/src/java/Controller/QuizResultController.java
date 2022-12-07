/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Course;
import Model.CurrentCourse;
import Model.Lesson;
import Model.Section;
import Model.User;
import Model.UserQuiz;
import dal.CourseDAO;
import dal.LessonDAO;
import dal.QuestionDAO;
import dal.QuizDAO;
import dal.SectionDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author vuman
 */
public class QuizResultController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            if (request.getSession().getAttribute("user") != null) {
                QuizDAO quizdao = new QuizDAO();
                QuestionDAO quesdao = new QuestionDAO();
                LessonDAO lessonDAO = new LessonDAO();
                CourseDAO courseDAO = new CourseDAO();
                SectionDAO sectionDAO = new SectionDAO();

                User user = (User) request.getSession().getAttribute("user");
                int quizId = Integer.parseInt(request.getParameter("quizid"));

                ArrayList<UserQuiz> quizHistoryList = quizdao.getQuizHistory(user.getUserId(), quizId);
                CurrentCourse current = quesdao.getDetailFromQuiz(quizId);
                Lesson lesson = lessonDAO.getLessonbyLessonID(current.getLessonID());
                Course c = courseDAO.getAllCourseInformation(current.getCourseID());
                ArrayList<Section> listSection = sectionDAO.getAllSectionOfCourse(current.getCourseID());
                ArrayList<Lesson> listLesson = new ArrayList<>();
                for (Section section : listSection) {
                    ArrayList<Lesson> tmp = lessonDAO.getAllLessonOfUserOFSection(section.getSectionId(), user.getUserId());
                    //ArrayList<Lesson> tmp = ldao.getAllLessonOfSection(section.getSectionId());
                    for (Lesson les : tmp) {
                        listLesson.add(les);
                    }
                }

                request.setAttribute("lesson", lesson);
                request.setAttribute("course", c);
                request.setAttribute("listSection", listSection);
                request.setAttribute("listLesson", listLesson);
                request.setAttribute("quizhislist", quizHistoryList);
                request.setAttribute("numofques", quesdao.getNumberQuesOfQuiz(quizId));
                request.setAttribute("quizid", quizId);
                request.getRequestDispatcher("QuizResult.jsp").forward(request, response);
                return;
            } else {
                response.sendRedirect("home");
            }
        } catch (Exception e) {
            request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

}
