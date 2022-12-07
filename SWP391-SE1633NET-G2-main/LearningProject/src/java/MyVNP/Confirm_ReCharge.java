/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package MyVNP;

import Model.User;
import MyVNP.Config;
import dal.AccountDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BachDuc
 */
public class Confirm_ReCharge extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        Map fields = new HashMap();
        for (Enumeration params = request.getParameterNames(); params.hasMoreElements();) {
            String fieldName = (String) params.nextElement();
            String fieldValue = request.getParameter(fieldName);
            if ((fieldValue != null) && (fieldValue.length() > 0)) {
                fields.put(fieldName, fieldValue);
            }
        }
        String vnp_SecureHash = request.getParameter("vnp_SecureHash");
        if (fields.containsKey("vnp_SecureHashType")) {
            fields.remove("vnp_SecureHashType");
        }
        if (fields.containsKey("vnp_SecureHash")) {
            fields.remove("vnp_SecureHash");
        }
        String signValue = Config.hashAllFields(fields);

        //My modify
        String IDORDER = request.getParameter("vnp_TxnRef");
        int Amount = Integer.parseInt(request.getParameter("vnp_Amount"));
        String content = request.getParameter("vnp_OrderInfo");
//        Acount_cloud ac = ((Acount_cloud)request.getSession().getAttribute("ac")).getGmail_Account();
//        new DAO().ReChargeAccount(((Acount_cloud)request.getSession().getAttribute("ac")).getGmail_Account(), Amount);
        try {
            AccountDBContext acd = new AccountDBContext();
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            acd.updateBalance(Amount, String.valueOf(user.getUserId()));
        } catch (Exception e) {
            System.err.println(e);
        }

        request.getRequestDispatcher("VNPAY/vnpay_return.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Confirm_ReCharge.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Confirm_ReCharge.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Confirm_ReCharge.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Confirm_ReCharge.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
