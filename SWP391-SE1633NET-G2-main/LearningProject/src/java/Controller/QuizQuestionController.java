/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Answer;
import Model.Lesson;
import Model.Question;
import Model.User;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dal.AnswerDAO;
import dal.LessonDAO;
import dal.QuestionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author Dung
 */
@WebServlet(name = "QuizQuestionController", urlPatterns = "/QuizQuestion")
public class QuizQuestionController extends HttpServlet {

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
            out.println("<title>Servlet QuizQuestionController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet QuizQuestionController at " + request.getContextPath() + "</h1>");
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

        User u = (User) request.getSession().getAttribute("user");

        LessonDAO ldao = new LessonDAO();
        QuestionDAO qdao = new QuestionDAO();
        AnswerDAO ansdao = new AnswerDAO();
//        // Check Mentor role
//        if (u.getRole().equals("Mentor")) {
            if (request.getParameter("lessonID") != null) {
                int lessonID = Integer.parseInt(request.getParameter("lessonID"));
                int quizID = ldao.getQuizID(lessonID);
                ArrayList<Question> questionList = qdao.getQuestionsOfQuiz(quizID);
                ArrayList<Answer> answerList = new ArrayList<>();
                for (Question question : questionList) {
                    ArrayList<Answer> temp = ansdao.getAnswersOfQuestion(question.getQuestionId());
                    for (Answer answer : temp) {
                        answerList.add(answer);
                    }

                }

                Lesson ls = ldao.getLessonbyLessonID(lessonID);

                request.setAttribute("lesson", ls);
                request.setAttribute("lessonID", lessonID);
                request.setAttribute("quizID", quizID);
                request.setAttribute("questionList", questionList);
                request.setAttribute("answerList", answerList);
                request.getRequestDispatcher("QuizQuestion.jsp").forward(request, response);
            }

//        } else {
//            response.sendRedirect("home");
//        }
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
        User u = (User) request.getSession().getAttribute("user");

        LessonDAO ldao = new LessonDAO();
        QuestionDAO qdao = new QuestionDAO();
        AnswerDAO ansdao = new AnswerDAO();

        // Check Mentor role
//        if (u.getRole().equals("Mentor")) {
        int lessonID = Integer.parseInt(request.getParameter("lessonID"));
        int quizID = Integer.parseInt(request.getParameter("quizID"));
        ArrayList<Integer> listQuestionID = qdao.getListQuestionID(quizID);
        String JsonData = request.getParameter("jsonQuestions");
        JsonArray json = new JsonParser().parse(JsonData).getAsJsonArray();
        for (JsonElement jsonElement : json) {
            JsonObject question = jsonElement.getAsJsonObject();
            String questionID = question.get("ques").getAsJsonArray().get(0).getAsJsonObject().get("questionID").getAsString();
            String questionContent = question.get("ques").getAsJsonArray().get(0).getAsJsonObject().get("questionContent").getAsString();

            // If question id from frontend send is null then add to DB
            if (questionID.equals("null")) {
                boolean exist = qdao.isThereAnyQuestions();
                int qID = 0;
                if(exist == false){
                    qID = qdao.addQuestion(new Question(0, questionContent, quizID));
                }
                else{
                    qID = qdao.addQuestion(new Question(0, questionContent, quizID)) + 1;
                }
                
                for (JsonElement jsonElement1 : question.get("ans").getAsJsonArray()) {
                    JsonObject answer = jsonElement1.getAsJsonObject();
                    String answerID = answer.get("answerID").getAsString();
                    String answerValue = answer.get("val").getAsString();
                    boolean isAnswer = answer.get("isCorrect").getAsBoolean();

                    ansdao.addAnswer(new Answer(0, answerValue, qID, isAnswer));
                }
            } else {
                int qID = Integer.parseInt(questionID);
                for (Integer i : listQuestionID) {
                    if (qID == i) {
                        listQuestionID.remove(i);
                        break;
                    }
                }
                // Update Q ID
                qdao.updateQuestionByQuestionID(qID, questionContent);
                ArrayList<Integer> listAnswerID = ansdao.getAnswerListID(qID);

                for (JsonElement jsonElement1 : question.get("ans").getAsJsonArray()) {
                    JsonObject answer = jsonElement1.getAsJsonObject();
//                    response.getWriter().println(answer.get("answerID").getAsString() + "   " + answer.get("val").getAsString() + " " + answer.get("isCorrect").getAsBoolean());

                    String answerID = answer.get("answerID").getAsString();
                    String answerValue = answer.get("val").getAsString();
                    boolean isAnswer = answer.get("isCorrect").getAsBoolean();

                    if (answerID.equals("null")) {
                        ansdao.addAnswer(new Answer(0, answerValue, qID, isAnswer));
                    } else {
                        int ansID = Integer.parseInt(answerID);
                        for (Integer i : listAnswerID) {
                            if (ansID == i) {
                                listAnswerID.remove(i);
                                break;
                            }
                        }
                        ansdao.updateAnswerByAnswerID(ansID, answerValue, isAnswer);

                    }
                }

                // When list answer id have id inside, then remove it in DB
                for (Integer i : listAnswerID) {
                    ansdao.deleteAnswer(i.intValue());
                }
            }


//            for (JsonElement jsonElement1 : question.get("ans").getAsJsonArray()) {
//                JsonObject answer = jsonElement1.getAsJsonObject();
//                response.getWriter().println(answer.get("answerID").getAsString() + "   " + answer.get("val").getAsString() + " " + answer.get("isCorrect").getAsBoolean());
//
//                String answerID = answer.get("answerID").getAsString();
//                String answerValue = answer.get("val").getAsString();
//                boolean isAnswer = answer.get("isCorrect").getAsBoolean();
//
//                if (questionID.equals("null") && answerID.equals("null")) {
//
//                }
//            }
        }

        for (Integer i : listQuestionID) {
            qdao.deleteQuestion(i.intValue());
        }
        
        response.sendRedirect("QuizQuestion?lessonID="+lessonID);
        
//       } else {
//           response.sendRedirect("home");
//        }
        
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

//    private void viewQuestion(HttpServletRequest request, PrintWriter out) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        QuestionDAO qdao = new QuestionDAO();
//        Question q = qdao.getQuestionAndAnswer(id);
//        
//    }
}
