/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package context;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 
 */
public class DBContext {

    public Connection connection;

    public DBContext() throws ClassNotFoundException {
        try {
            //Change the username password and url to connect your own database
            String username = "sa";
            String password = "123";
            String url = "jdbc:sqlserver://DESKTOP-T2PMA24:1433;databaseName=testing";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(new DBContext().connection);
        
    }
}
