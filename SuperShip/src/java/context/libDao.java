/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package context;

import core.CurrentDate;
import core.RandomNumber;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Account_Address_Cloud;
import model.Category_product_Cloud;
import model.Product_Cloud;

/**
 *
 * @author BachDuc
 */
public class libDao {

    public Connection Connect() throws ClassNotFoundException {
//        Connection connection;
//        try {
//            //Change the username password and url to connect your own database
//            String username = "sa";
//            String password = "123";
//            String url = "jdbc:sqlserver://DESKTOP-T2PMA24:1433;databaseName=ShopeBee";
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            connection = DriverManager.getConnection(url, username, password);
//            return connection;
//        } catch (SQLException ex) {
//            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
//            return null;
//        }
        return new CommonDAO().CommonDAO();
    }

    public String GetNameCity(String idcity) throws SQLException, ClassNotFoundException {
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String sql = "select * from City_Address where ID_City_Address like ? ";
            pr = con.prepareStatement(sql);
            pr.setString(1, idcity);
            rs = pr.executeQuery();
            if (rs.next()) {
                return rs.getString(2);
            } else {
                System.err.println("My Notice:Else case return Null");
                return null;
            }
        } catch (Exception e) {
            System.err.println("My Notice:Catch case return Null");
            return null;
        }
    }

    public String GetNameDistrict(String idcity, String iddistrict) throws SQLException, ClassNotFoundException {
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String sql = "select * from District_Address where ID_City_Address like ? and ID_District_Address like ? ";
            pr = con.prepareStatement(sql);
            pr.setString(1, idcity);
            pr.setString(2, iddistrict);
            rs = pr.executeQuery();
            if (rs.next()) {
                return rs.getString(3);
            } else {
                System.err.println("My Notice:Else case return Null");
                return null;
            }
        } catch (Exception e) {
            System.err.println("My Notice:Catch case return Null");
            return null;
        }
    }

    public byte[] GetIMGDProduct(String id) throws SQLException, ClassNotFoundException {
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String sql = "select * from product where id_product like ?";
            pr = con.prepareStatement(sql);
            pr.setString(1, id);
            rs = pr.executeQuery();
            if (rs.next()) {
                return rs.getBytes(9);
            } else {
                System.err.println("My Notice:Else case return Null");
                return null;
            }
        } catch (Exception e) {
            System.err.println("My Notice:Catch case return Null");
            return null;
        }
    }

    public ArrayList<Category_product_Cloud> GetListCategory() throws SQLException, ClassNotFoundException {
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        ArrayList<Category_product_Cloud> list = new ArrayList<Category_product_Cloud>();
        try {
            String sql = "select * from categories_product";
            pr = con.prepareStatement(sql);
            rs = pr.executeQuery();
            while (rs.next()) {
                list.add(new Category_product_Cloud(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
            return list;
        } catch (Exception e) {
            System.err.println("My Notice:Catch case return Null");
            return null;
        }
    }

    public Product_Cloud Get_Product(String idpd, String gmail) throws SQLException, ClassNotFoundException {
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String sql = "select * from product where id_product like ?";
            pr = con.prepareStatement(sql);
            pr.setString(1, idpd);
//            pr.setString(2, gmail);
            rs = pr.executeQuery();
            if (rs.next()) {
                return new Product_Cloud(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getBytes(9), rs.getString(10));
            } else {
                System.err.println("My Notice:Else case return Null");
                return null;
            }
        } catch (Exception e) {
            System.err.println("My Notice:Catch case return Null");
            return null;
        }
    }

    public Product_Cloud Get_ProductCONSTGMAIL(String idpd, String gmail) throws SQLException, ClassNotFoundException {
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String sql = "select * from product where id_product like ? and gmail_Account like ?";
            pr = con.prepareStatement(sql);
            pr.setString(1, idpd);
            pr.setString(2, gmail);
            rs = pr.executeQuery();
            if (rs.next()) {
                return new Product_Cloud(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getBytes(9), rs.getString(10));
            } else {
                System.err.println("My Notice:Else case return Null");
                return null;
            }
        } catch (Exception e) {
            System.err.println("My Notice:Catch case return Null");
            return null;
        }
    }

    public Account_Address_Cloud Get_AccountAddress(String idadd) throws SQLException, ClassNotFoundException {
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "select  * from Address_Account where id_Address_Account like ?";
        pr = con.prepareStatement(sql);
        pr.setString(1, idadd);
        rs = pr.executeQuery();
        rs.next();
        return new Account_Address_Cloud(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
    }

    public boolean Add_RANDOMProduct_Cloud(String gmail, String idcate) throws SQLException, ClassNotFoundException {
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "";
        try {
            int cate = 1;
            for (int i = 0; i < 100; i++) {
                if (i > 30) {
                    cate = 2;
                }
                if (i > 60) {
                    cate = 3;
                }
                sql = "exec insert_Product ?,?,?,?,?,?,?,?,?";
                pr = con.prepareStatement(sql);
                pr.setString(1, gmail);
                pr.setString(2, String.valueOf(cate));
                pr.setString(3, "Itemcategorynumber" + i);
                pr.setString(4, "Don vi item:" + i);
                pr.setFloat(5, i * 10000);
                pr.setString(6, String.valueOf(i));
                pr.setString(7, new CurrentDate().GetDateAfterDays(-i));
                pr.setBytes(8, "".getBytes());
                pr.setString(9, "day la description cua mon do :" + i);
                pr.execute();
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new libDao().Add_RANDOMProduct_Cloud("admin@gmail.com", "3");
    }

}
