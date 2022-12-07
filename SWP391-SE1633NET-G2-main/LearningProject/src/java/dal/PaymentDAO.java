/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import Model.Payment;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NamDepTraiVL
 */
public class PaymentDAO extends DBContext {

    public PaymentDAO() {
    }

    public ArrayList<Payment> getPaymentListFromUser(int userid) {
        ArrayList<Payment> paymentList = new ArrayList<>();
        UserDAO userDAO = new UserDAO();
        try {
            ResultSet rs = executeQuery("select * from Recharge\n"
                    + "where UserID = ?", userid);
            while (rs.next()) {
                Payment payment = new Payment();
                payment.setUser(userDAO.getAllUserInformationByID(userid));
                payment.setAmount(rs.getInt("Amount"));
                payment.setContent(rs.getString("Content"));
                payment.setMethod(rs.getString("Method"));
                payment.setStatus(rs.getInt("Status"));
                payment.setPaymentID(rs.getInt("RechargeID"));
                payment.setRechargeDate(rs.getTimestamp("RechargeDate"));
                paymentList.add(payment);
            }
        } catch (SQLException ex) {
            return paymentList;
        }
        return paymentList;
    }

    public ArrayList<Payment> getPendingWithdraw(String searchingName) {
        ArrayList<Payment> paymentList = new ArrayList<>();
        UserDAO userDAO = new UserDAO();
        try {
            ResultSet rs = executeQuery("select * from [Recharge] re inner join [User] u on [re].UserID = [u].UserID\n"
                    + "where Method = 'Withdraw' and Status = 2 \n"
                    + "and ([u].[Username] like N'%" + searchingName + "%' \n"
                    + "or [re].[RechargeID] like N'%" + searchingName + "%' \n"
                    + "or [u].[BankName] like N'%" + searchingName + "%' \n"
                    + "or [u].[BankNumber] like N'%" + searchingName + "%')");
            while (rs.next()) {
                Payment payment = new Payment();
                payment.setUser(userDAO.getAllUserInformationByID(rs.getInt("UserID")));
                payment.setAmount(rs.getInt("Amount"));
                payment.setContent(rs.getString("Content"));
                payment.setMethod(rs.getString("Method"));
                payment.setStatus(rs.getInt("Status"));
                payment.setRechargeDate(rs.getTimestamp("RechargeDate"));
                payment.setPaymentID(rs.getInt("RechargeID"));
                paymentList.add(payment);
            }
        } catch (SQLException ex) {
            return paymentList;
        }
        return paymentList;
    }

    public ArrayList<Payment> getAllWithdraw(String searchingName) {
        ArrayList<Payment> paymentList = new ArrayList<>();
        UserDAO userDAO = new UserDAO();
        try {
            ResultSet rs = executeQuery("select * from [Recharge] re inner join [User] u on [re].UserID = [u].UserID\n"
                    + "where ([u].[Username] like N'%" + searchingName + "%' \n"
                    + "or [re].[RechargeID] like N'%" + searchingName + "%' \n"
                    + "or [u].[BankName] like N'%" + searchingName + "%' \n"
                    + "or [re].[Method] like N'%" + searchingName + "%' \n"
                    + "or [u].[BankNumber] like N'%" + searchingName + "%')");
            while (rs.next()) {
                Payment payment = new Payment();
                payment.setUser(userDAO.getAllUserInformationByID(rs.getInt("UserID")));
                payment.setAmount(rs.getInt("Amount"));
                payment.setContent(rs.getString("Content"));
                payment.setMethod(rs.getString("Method"));
                payment.setStatus(rs.getInt("Status"));
                payment.setRechargeDate(rs.getTimestamp("RechargeDate"));
                payment.setPaymentID(rs.getInt("RechargeID"));
                paymentList.add(payment);
            }
        } catch (SQLException ex) {
            return paymentList;
        }
        return paymentList;
    }

    public void userRecharge(int userid, Date date, int amount, int status, String method, String content) {
        int hehe = 0;
        hehe = executeUpdate("INSERT INTO [dbo].[Recharge]\n"
                + "           ([UserID]\n"
                + "           ,[RechargeDate]\n"
                + "           ,[Amount]\n"
                + "           ,[Status]\n"
                + "           ,[Method],[Content])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?,?)", userid, new Timestamp(date.getTime()), amount, status, method, content);
    }

    public void updatePaymentStatus(int paymentID, int status) {
        executeUpdate("UPDATE [dbo].[Recharge]\n"
                + "   SET [Status] = ?\n"
                + " WHERE RechargeID = ?", status, paymentID);
    }

}
