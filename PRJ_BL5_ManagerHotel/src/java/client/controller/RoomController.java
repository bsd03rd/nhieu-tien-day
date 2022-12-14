/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.controller;

import dao.AccountDAO;
import dao.RoomDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import model.Account;
import model.Room;

/**
 *
 * @author l
 */
public class RoomController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Account acc = (Account) req.getSession().getAttribute("account");
        String id = req.getParameter("id");
        String from = req.getParameter("start");
        String end = req.getParameter("end");
        String num = req.getParameter("num");
        new RoomDAO().addbooking(id, String.valueOf(acc.getAid()), from, end, num);
        resp.sendRedirect("room?id="+id);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // SessionDBContext sessionDB = new SessionDBContext();
        // ArrayList<Session> sessions = sessionDB.getListSessionStudent(sid, from, to);
        // req.setAttribute("sessions", sessions);
        int aid = Integer.parseInt(req.getParameter("id"));
        RoomDAO roomdao = new RoomDAO();
        ArrayList<Room> room = roomdao.getHotelDetails(aid);
        if (req.getParameter("opAsc") != null) {
            String sort = req.getParameter("opAsc");
            if (sort.equals("A")) {
                room.sort((t1, t2) -> (t1.getPrice() > t2.getPrice()) ? -1 : 1);
            } else {
                room.sort((t1, t2) -> (t1.getPrice() < t2.getPrice()) ? -1 : 1);
            }
            req.setAttribute("opAsc", sort.equals("A"));
        }

        req.setAttribute("roomId", aid);
        req.setAttribute("room", room);
        req.getRequestDispatcher("client/room.jsp").forward(req, resp);
    }

}
