/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Answer;
import Model.Docs;
import Model.Lesson;
import Model.Question;
import Model.Quiz;
import Model.Section;
import Model.Video;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dal.AnswerDAO;
import dal.CourseDAO;
import dal.DocsDAO;
import dal.LessonDAO;
import dal.QuestionDAO;
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
 * @author vuman
 */
public class UpdateLessonController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SectionDAO sd = new SectionDAO();
        LessonDAO ld = new LessonDAO();
        VideoDAO vd = new VideoDAO();
        DocsDAO dd = new DocsDAO();
        QuizDAO qd = new QuizDAO();
        QuestionDAO qdao = new QuestionDAO();
        AnswerDAO ansdao = new AnswerDAO();

        int courseId = Integer.parseInt(request.getParameter("courseid"));
        int sectionId = Integer.parseInt(request.getParameter("sectionid"));

        if (request.getParameter("button") != null) {
            if (request.getParameter("lessonID") != null) {
                int lessonID = Integer.parseInt(request.getParameter("lessonID"));
                int quizID = ld.getQuizID(lessonID);
                ArrayList<Question> questionList = qdao.getQuestionsOfQuiz(quizID);
                ArrayList<Answer> answerList = new ArrayList<>();
                for (Question question : questionList) {
                    ArrayList<Answer> temp = ansdao.getAnswersOfQuestion(question.getQuestionId());
                    for (Answer answer : temp) {
                        answerList.add(answer);
                    }

                }

                Lesson ls = ld.getLessonbyLessonID(lessonID);

                request.setAttribute("sectionid", sectionId);
                request.setAttribute("courseid", courseId);
                request.setAttribute("lesson", ls);
                request.setAttribute("lessonID", lessonID);
                request.setAttribute("quizID", quizID);
                request.setAttribute("questionList", questionList);
                request.setAttribute("answerList", answerList);
                request.getRequestDispatcher("UpdateQuizQuestion.jsp").forward(request, response);
                return;
            }
        }

        Section section = sd.getAllSectionInformation(sectionId);

        ArrayList<Lesson> lessonlist = ld.getAllLessonOfSection(sectionId);
        ArrayList<Video> videolist = new ArrayList<Video>();
        ArrayList<Docs> docslist = new ArrayList<Docs>();
        ArrayList<Quiz> quizlist = new ArrayList<Quiz>();

        for (Lesson lesson : lessonlist) {
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
        request.setAttribute("courseid", courseId);
        request.setAttribute("section", section);
        request.setAttribute("lessonlist", lessonlist);

        request.getRequestDispatcher("UpdateLesson.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LessonDAO ld = new LessonDAO();
        CourseDAO cd = new CourseDAO();
        QuestionDAO qdao = new QuestionDAO();
        AnswerDAO ansdao = new AnswerDAO();

        if (request.getParameter("button") != null) {
            if (request.getParameter("button").equals("Delete")) {
                int sectionId = Integer.parseInt(request.getParameter("sectionid"));
                int courseId = Integer.parseInt(request.getParameter("courseid"));
                int lessonId = Integer.parseInt(request.getParameter("lessonid"));
                ld.disableLesson(lessonId);

                response.sendRedirect("updatelesson?courseid=" + courseId + "&sectionid=" + sectionId);
            }
            if (request.getParameter("button").equals("Update video")) {
                int sectionId = Integer.parseInt(request.getParameter("sectionid"));
                int courseId = Integer.parseInt(request.getParameter("courseid"));
                int lessonId = Integer.parseInt(request.getParameter("LessonVideoId"));
                String lessonName = request.getParameter("LessonVideoName");
                String videoLink = request.getParameter("videolink");
                int time = Integer.parseInt(request.getParameter("time_duration"));

                ld.updateLessonVideo(lessonName, videoLink, lessonId, time);

                response.sendRedirect("updatelesson?courseid=" + courseId + "&sectionid=" + sectionId);
            }
            if (request.getParameter("button").equals("Update document")) {
                int sectionId = Integer.parseInt(request.getParameter("sectionid"));
                int courseId = Integer.parseInt(request.getParameter("courseid"));
                int lessonId = Integer.parseInt(request.getParameter("LessonDocsId"));
                String lessonName = request.getParameter("LessonDocsName");
                int time = Integer.parseInt(request.getParameter("Time"));
                String docsContent = request.getParameter("DocsContent");

                ld.updateLessonDocs(lessonName, time, docsContent, lessonId);

                response.sendRedirect("updatelesson?courseid=" + courseId + "&sectionid=" + sectionId);
            }
            if (request.getParameter("button").equals("Update quiz")) {
                int sectionId = Integer.parseInt(request.getParameter("sectionid"));
                int courseId = Integer.parseInt(request.getParameter("courseid"));
                int lessonId = Integer.parseInt(request.getParameter("LessonQuizId"));
                String lessonName = request.getParameter("LessonQuizTitle");
                int time = Integer.parseInt(request.getParameter("LessonQuizTime"));

                ld.updateLessonQuiz(lessonName, time, lessonId);

                response.sendRedirect("updatelesson?courseid=" + courseId + "&sectionid=" + sectionId);
            }
            if (request.getParameter("button").equals("Updatequestion")) {
                int sectionId = Integer.parseInt(request.getParameter("sectionid"));
                int courseId = Integer.parseInt(request.getParameter("courseid"));
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
                        if (exist == false) {
                            qID = qdao.addQuestion(new Question(0, questionContent, quizID));
                        } else {
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
                }

                for (Integer i : listQuestionID) {
                    qdao.deleteQuestion(i.intValue());
                }
                
                response.sendRedirect("updatelesson?lessonID=" + lessonID + "&button=quiz&courseid=" + courseId + "&sectionid=" + sectionId);
            }
            if (request.getParameter("button").equals("Add video")) {
                int sectionId = Integer.parseInt(request.getParameter("sectionid"));
                int courseId = Integer.parseInt(request.getParameter("courseid"));
                String lessonName = request.getParameter("lessonvideoname");
                String videoURL = request.getParameter("video_url");
                int duration = Integer.parseInt(request.getParameter("duration"));

                ld.addLessonVideo(sectionId, lessonName, lessonName, videoURL, duration);

                response.sendRedirect("updatelesson?courseid=" + courseId + "&sectionid=" + sectionId);
            }
            if (request.getParameter("button").equals("Add document")) {
                int sectionId = Integer.parseInt(request.getParameter("sectionid"));
                int courseId = Integer.parseInt(request.getParameter("courseid"));
                String lessonName = request.getParameter("lessondocsname");
                int time = Integer.parseInt(request.getParameter("time"));
                String docsContent = request.getParameter("lessondocscontent");

                ld.addLessonDoc(sectionId, lessonName, time, docsContent);

                response.sendRedirect("updatelesson?courseid=" + courseId + "&sectionid=" + sectionId);
            }
            if (request.getParameter("button").equals("Add quiz")) {
                int sectionId = Integer.parseInt(request.getParameter("sectionid"));
                int courseId = Integer.parseInt(request.getParameter("courseid"));
                String lesson_title = request.getParameter("lessonTitle");
                int lesson_time = Integer.parseInt(request.getParameter("lessonTime"));
                ld.addLessonQuiz(new Lesson(0, sectionId, lesson_title, false, "Quiz", false, lesson_time));
                int lessonID = ld.getNewestLessonID(sectionId);
                QuizDAO quizDAO = new QuizDAO();
                quizDAO.addQuiz(lessonID);

                response.sendRedirect("updatelesson?courseid=" + courseId + "&sectionid=" + sectionId);
            }
            if (request.getParameter("button").equals("Save changes")) {
                int courseId = Integer.parseInt(request.getParameter("courseid"));
                cd.enableCourse(courseId);

                response.sendRedirect("home");
            }
        }
    }
}
