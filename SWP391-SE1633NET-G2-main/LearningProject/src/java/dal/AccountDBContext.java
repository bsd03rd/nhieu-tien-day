/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import dal.DBContext;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NamDepTraiVL
 */
public class AccountDBContext extends DBContext {
       
    public String findAccWithUsername(String username) {
        try {
            ResultSet rs = executeQuery("SELECT * FROM [User] where Username = ?", username);
            if (rs.next()) {
                return rs.getString("Username");
            }
//            String sql = "select * from Account";                                    
//            ResultSet rs = executeQuery(sql);
//            String user = rs.getString(1);
//            return user;
        } catch (Exception ex) {
            return ex.getMessage().toString();
        }
        return null;
    }

    public String findOldPassWithUsername(String username) {
        try {
            ResultSet rs = executeQuery("SELECT * FROM [User] where Username = ?", username);
            if (rs.next()) {
                return rs.getString("Password");
            }
//            String sql = "select * from Account";                                    
//            ResultSet rs = executeQuery(sql);
//            String user = rs.getString(1);
//            return user;
        } catch (Exception ex) {
            return ex.getMessage().toString();
        }
        return "Not found";
    }

    public void update(String username, String password) {
        executeUpdate("update [User] \n"
                + "set Password = ?\n"
                + "where Username = ? ", password, username);
    }
    public void updateBalance(int money, String idaccount) {
        executeUpdate("update [User] set balance += ? where UserID = ? ", money, idaccount);
    }
    
}
