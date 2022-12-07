/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.User;
import dal.UserDAO;
import dal.Validation;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.text.SimpleDateFormat;
import utils.SHA256;

/**
 *
 * @author vuman
 */
public class BecomeMentorController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("BecomeMentor.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Validation valid = new Validation();
            UserDAO userDAO = new UserDAO();
            SimpleDateFormat sdm = new SimpleDateFormat("yyyy-MM-dd");

            String userName = request.getParameter("username");
            String password = request.getParameter("password");
            String cfpassword = request.getParameter("cfpassword");
            String bankNum = request.getParameter("banknumber");
            String bankName = request.getParameter("bankname");
            Date date = new Date(sdm.parse(request.getParameter("dob")).getTime());
            HttpSession session = request.getSession();

            if (userDAO.isAccountExist(userName)) {
                request.setAttribute("result", "Tài khoản của bạn đã tồn tại, vui lòng thử lại");
            } else if (userName.length() < 3) {
                request.setAttribute("result", "Tên đăng nhập phải có nhiều hơn 3 kí tự");
            } else if (!valid.checkPasswordFormat(password)) {
                request.setAttribute("result", "Mật khẩu của bạn phải có độ dài từ 8 - 25 ký tự, bao gồm ít nhất 1 chữ cái viết hoa, 1 chữ thường, 1 chữ số và 1 ký tự đặc biệt");
            } else if (!cfpassword.equals(password)) {
                request.setAttribute("result", "Mật khẩu của bạn không trùng khớp, vui lòng thử lại");
            }
            else if(!valid.checkBirthDay(date)){
                request.setAttribute("result", "Bạn phải trên 16 tuổi mới có thể đăng ký tài khoản");
            }else {
                User user = new User("", "", "", "", "", "", "", date, "", 0, "", userName, SHA256.SHA256(password), "Mentor", bankNum, bankName, false);
                userDAO.addUser(user);
                response.sendRedirect(request.getContextPath() + "/login");
            }

            doGet(request, response);
        } catch (Exception e) {
            e.printStackTrace(response.getWriter());
        }
    }

}
