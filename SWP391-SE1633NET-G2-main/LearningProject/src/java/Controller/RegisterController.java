/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import dal.UserDAO;
import Model.User;
import dal.Validation;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import utils.SHA256;
import utils.VerifyCaptcha;

/**
 *
 * @author vuman
 */
public class RegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("Register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Validation valid = new Validation();
            UserDAO userDAO = new UserDAO();
            SimpleDateFormat sdm = new SimpleDateFormat("yyyy-MM-dd");
            VerifyCaptcha verifyCaptcha = new VerifyCaptcha();

            String userName = request.getParameter("username");
            String firstName = request.getParameter("firstname");
            String lastName = request.getParameter("lastname");
            Date date = new Date(sdm.parse(request.getParameter("dob")).getTime());
            String password = request.getParameter("password");
            String cfpassword = request.getParameter("cfpassword");
            String email = request.getParameter("email");
            String gRecaptchaResponse = request.getParameter("g-recaptcha-response");

            if (userDAO.isAccountExist(userName)) {
                request.setAttribute("result", "Tài khoản của bạn đã tồn tại, vui lòng thử lại");
            } else if (verifyCaptcha.verify(gRecaptchaResponse) == false) {
                request.setAttribute("result", "Captcha unavailable");
            } else if (userName.length() < 3) {
                request.setAttribute("result", "Tên đăng nhập phải có nhiều hơn 3 kí tự");
            } else if (!valid.checkBirthDay(date)) {
                request.setAttribute("result", "Bạn phải trên 16 tuổi mới có thể đăng ký tài khoản");
            } else if (!valid.checkPasswordFormat(password)) {
                request.setAttribute("result", "Mật khẩu của bạn phải có độ dài từ 8 - 25 ký tự, bao gồm ít nhất 1 chữ cái viết hoa, 1 chữ thường, 1 chữ số và 1 ký tự đặc biệt");
            } else if (!cfpassword.equals(password)) {
                request.setAttribute("result", "Mật khẩu của bạn không trùng khớp, vui lòng thử lại");
            } else {
                User user = new User(firstName, lastName, email, "", "", "", "", date, "", 0, "", userName, SHA256.SHA256(password), "User", "", "", false);
                userDAO.addUser(user);
                response.sendRedirect("login");
            }

            doGet(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
