/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Answer;
import Model.Course;
import Model.CurrentCourse;
import Model.Lesson;
import Model.Question;
import Model.Section;
import Model.User;
import dal.AnswerDAO;
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
import jakarta.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author vuman
 */
public class QuizResultReviewController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();

            if (session.getAttribute("user") != null) {
                QuestionDAO quesdao = new QuestionDAO();
                AnswerDAO ad = new AnswerDAO();
                LessonDAO lessonDAO = new LessonDAO();
                CourseDAO courseDAO = new CourseDAO();
                SectionDAO sectionDAO = new SectionDAO();

                User user = (User) session.getAttribute("user");
                int userQuizId = Integer.parseInt(request.getParameter("userquizid"));
                int quizId = Integer.parseInt(request.getParameter("quizid"));

                ArrayList<Question> quesList = quesdao.getQuestionsOfQuiz(quizId);
                ArrayList<Answer> answerList = ad.getAnswersOfQuiz(quizId);
                ArrayList<Answer> correctAnswerList = ad.getCorrectAnswersOfQuiz(quizId);
                ArrayList<Integer> userAnswerList = ad.getUserAnswerList(user.getUserId(), userQuizId);
                
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

                request.setAttribute("useranswerlist", userAnswerList);
                request.setAttribute("queslist", quesList);
                request.setAttribute("answerlist", answerList);
                request.setAttribute("correctanswerlist", correctAnswerList);
                request.setAttribute("userquizid", userQuizId);
                request.setAttribute("quizid", quizId);
                request.getRequestDispatcher("QuizResultReview.jsp").forward(request, response);

            } else {
                response.sendRedirect("home");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

}
