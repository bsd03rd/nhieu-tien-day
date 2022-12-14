/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.controller;

import dao.AccountDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import model.Account;

/**
 *
 * @author l
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("client/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        
        AccountDAO accdao = new AccountDAO();
        Account acc = accdao.check(username, password);
        HttpSession session = req.getSession();
        session.setAttribute("account", acc);
        
        ArrayList<Account> account = accdao.listAccount();
        session.setAttribute("name", account);
        
        if (acc == null) {
            req.setAttribute("error", "Account not existed!");
            req.getRequestDispatcher("client/login.jsp").forward(req, resp);
        } else {
            if (acc.getRoleID() == 1) {
                resp.sendRedirect("home");
            } else {
                resp.sendRedirect("admin");
            }
            /// thiếu getRoleAccount, chưa insert vào servlet và dao 
//            request.getRequestDispatcher("client/home.jsp").forward(request, response);
//            response.sendRedirect("home");
        }
    }

}
