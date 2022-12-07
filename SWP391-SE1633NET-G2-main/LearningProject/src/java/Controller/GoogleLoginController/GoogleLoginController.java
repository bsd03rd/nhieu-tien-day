/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.GoogleLoginController;

import Model.GoogleUser;
import Model.User;
import dal.UserDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import utils.GoogleUtils;
import utils.SHA256;

/**
 *
 * @author NamDepTraiVL
 */
public class GoogleLoginController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String code = request.getParameter("code");
        if (code == null || code.isEmpty()) {
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        } else {
            String accessToken = GoogleUtils.getToken(code);
            GoogleUser ggUser = GoogleUtils.getUserInfo(accessToken);            
            UserDAO userDAO = new UserDAO();
            if (userDAO.isAccountExist(ggUser.getId())) {
                HttpSession session = request.getSession();
                session.setAttribute("username", ggUser.getId());
                session.setAttribute("user", userDAO.getAllUserInformation(ggUser.getId()));
                response.sendRedirect("home");
            } else {
                try {
                    Date date = new Date(serialVersionUID);
                    User user = new User(ggUser.getGiven_name(), ggUser.getFamily_name(), ggUser.getEmail(), "", "", "", "", date, "", 0, ggUser.getPicture(), ggUser.getId(), SHA256.SHA256(ggUser.getId()), "User", "", "", false);
                    userDAO.addGoogleUser(user);                    
                    HttpSession session = request.getSession();
                    session.setAttribute("username", user.getUserName());
                    session.setAttribute("user", userDAO.getAllUserInformation(user.getUserName()));
                    response.sendRedirect("home");
                } catch (Exception ex) {
                    request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
                }
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        doGet(request, response);
    }

}
