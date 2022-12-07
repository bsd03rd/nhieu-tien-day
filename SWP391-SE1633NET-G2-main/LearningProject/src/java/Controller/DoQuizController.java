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
import Model.UserQuiz;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.annotations.JsonAdapter;
import dal.AnswerDAO;
import dal.CourseDAO;
import dal.QuestionDAO;
import dal.LessonDAO;
import dal.QuizDAO;
import dal.SectionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Dung
 */
public class DoQuizController extends HttpServlet {

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
            out.println("<title>Servlet DoQuizController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DoQuizController at " + request.getContextPath() + "</h1>");
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
        
        QuestionDAO qdao = new QuestionDAO();
        AnswerDAO ansdao = new AnswerDAO();
        
        int quizID = Integer.parseInt(request.getParameter("quizid"));
        
        ArrayList<Question> questionList = qdao.getQuestionsOfQuiz(quizID);
        ArrayList<Answer> answerList = new ArrayList<>();
        for (Question question : questionList) {
            ArrayList<Answer> temp = ansdao.getAnswersOfQuestion(question.getQuestionId());
            for (Answer answer : temp) {
                answerList.add(answer);
            }

        }
        
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
        request.setAttribute("quizID", quizID);
        request.setAttribute("questionList", questionList);
        request.setAttribute("answerList", answerList);
        
        request.getRequestDispatcher("CourseWatch.jsp").forward(request, response);
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
        QuizDAO qzdao = new QuizDAO();
        LessonDAO lessonDAO = new LessonDAO();
        int lessonID = 0;

        if (request.getParameter("jsonQuestions") != null) {
            int quizID = 0;
            if (request.getParameter("quizID") != null) {
                quizID = Integer.parseInt(request.getParameter("quizID"));
                lessonID = qzdao.getLessonID(quizID);
            }
            HashMap<Integer, ArrayList<Integer>> data = new HashMap<>();

            String JsonData = request.getParameter("jsonQuestions");
            JsonArray json = new JsonParser().parse(JsonData).getAsJsonArray();
            for (JsonElement jsonElement : json) {
                JsonObject question = jsonElement.getAsJsonObject();
                String questionID = question.get("ques").getAsJsonArray().get(0).getAsJsonObject().get("questionID").getAsString();
                JsonArray answers = question.get("ans").getAsJsonArray();
                ArrayList<Integer> answerList = new ArrayList();
                for (JsonElement answerJsonElement : answers) {
                    JsonObject answer = answerJsonElement.getAsJsonObject();
                    int answerID = Integer.parseInt(answer.get("ansID").getAsString());
                    boolean isChecked = answer.get("isCorrect").getAsBoolean();

                    if (isChecked) {
                        answerList.add(answerID);
                    }
                }

                data.put(Integer.parseInt(questionID), answerList);

            }

            // Lay tu db
            HashMap<Integer, ArrayList<Integer>> dataOnDB = qzdao.getAnswers(quizID);

            int numberOfRightQuestion = 0;
            for (Map.Entry<Integer, ArrayList<Integer>> entry : data.entrySet()) {
                Object quesIdUser = entry.getKey();
                Object ansIdUser = entry.getValue();
                for (Map.Entry<Integer, ArrayList<Integer>> entry1 : dataOnDB.entrySet()) {
                    Object quesIdDB = entry1.getKey();
                    Object ansIdDB = entry1.getValue();
                    if (quesIdUser.equals(quesIdDB)) {
                        if (ansIdUser.equals(ansIdDB)) {
                            numberOfRightQuestion++;
                        }
                    }
                }
            }

            // Tinh diem
            int datasize = data.size();
            double mark = ((double) numberOfRightQuestion / (double) datasize) * 10;
            User u = (User) request.getSession().getAttribute("user");
            Date date = new Date();
            Timestamp doDate = new Timestamp(date.getTime());
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Date parsedDate = dateFormat.parse(dateFormat.format(date).toString());
                doDate = new java.sql.Timestamp(parsedDate.getTime());
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Add DB
            qzdao.insertUserQuiz(u.getUserId(), quizID, mark, numberOfRightQuestion, doDate);
            // return user quizID
            int userQuizID = qzdao.getUserQuizID(doDate, u.getUserId(), quizID);

            // Add to User Answer in DB
            String query = "INSERT INTO [dbo].[User_Answer]\n"
                    + "           ([UserID]\n"
                    + "           ,[AnswerID]\n"
                    + "           ,[UserQuizID])\n"
                    + "     VALUES ";
            boolean isFirst = true;
            for (JsonElement jsonElement : json) {
                JsonObject question = jsonElement.getAsJsonObject();
                JsonArray answers = question.get("ans").getAsJsonArray();

                for (JsonElement answerJsonElement : answers) {

                    JsonObject answer = answerJsonElement.getAsJsonObject();
                    int answerID = Integer.parseInt(answer.get("ansID").getAsString());
                    boolean isChecked = answer.get("isCorrect").getAsBoolean();
                    if (isChecked) {
                        if (!isFirst) {
                            query += ", ";
                        }
                        isFirst = false;
                        query += "(" + u.getUserId() + ", " + answerID + ", " + userQuizID + ")";
                    }
                    lessonDAO.UpdateMarkAs(lessonID, u.getUserId(), "Done");
                }
            }
            qzdao.insertUserAnswer(query);
            response.sendRedirect("quizresult?quizid=" + quizID);
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