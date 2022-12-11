/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 
 */
public class CommonDAO {
    public Connection CommonDAO() throws ClassNotFoundException {
        Connection connection;
        try {
            //Change the username password and url to connect your own database
            String username = "sa";
            String password = "123";
            String url = "jdbc:sqlserver://DESKTOP-T2PMA24:1433;databaseName=ShopeBee";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public static void main(String[] args) throws ClassNotFoundException {
        System.err.println(new CommonDAO().CommonDAO().toString());
    }
            
}
