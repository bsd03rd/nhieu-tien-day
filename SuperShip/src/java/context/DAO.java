/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package context;

import com.sun.javafx.geom.CubicApproximator;
import controller.Add_Product;
import core.CurrentDate;
import core.Generate_ID_Account;
import core.SHA_256;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Account_Address_Cloud;
import model.Account_info_Cloud;
import model.Acount_cloud;
import model.All_Address_Account;
import model.All_In4_Account_Seller;
import model.Category_product_Cloud;
import model.City_Address_model;
import model.District_Address_model;
import model.Order_Product;
import model.Product_Cloud;
import model.Product_model;
import model.Register_information;
import model.Ship_info;

/**
 *
 * @author BachDuc
 */
public class DAO {

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
            return  new CommonDAO().CommonDAO();
    }

    public Acount_cloud Login_Account_Cloud(String gmail, String pass) throws SQLException, ClassNotFoundException {
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "";
        Acount_cloud ac = new Acount_cloud();

        // dowload data account cloud
        sql = "select * from Account where gmail_Account like ? and password_account like ?";
        pr = con.prepareStatement(sql);
        pr.setString(1, gmail);
        pr.setString(2, pass);
        rs = pr.executeQuery();
        if (rs.next()) {
            ac.setGmail_Account(rs.getString(1));
            ac.setType_account(rs.getString(2));
            ac.setPassword_account(rs.getString(3));
        } else {
            return null;
        }

        //dowload data account info
        sql = "select * from Account_info where gmail_Account like ?";
        pr = con.prepareStatement(sql);
        pr.setString(1, gmail);
        rs = pr.executeQuery();
        if (rs.next()) {
            ac.setAccount_info(new Account_info_Cloud(rs.getString(1), rs.getString(2),
                    rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getBytes(7), rs.getString(8)));
        }
        //dowload data Address_Account
        sql = "select * from Address_Account where gmail_Account like ?";
        pr = con.prepareStatement(sql);
        pr.setString(1, gmail);
        rs = pr.executeQuery();
        ArrayList<Account_Address_Cloud> list_adress = new ArrayList<Account_Address_Cloud>();
        while (rs.next()) {
            list_adress.add(new Account_Address_Cloud(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
        }
        ac.setAccount_Address_list(list_adress);
        //dowload data Product
        sql = "select * from product where gmail_Account like ?";
        pr = con.prepareStatement(sql);
        pr.setString(1, gmail);
        rs = pr.executeQuery();
        ArrayList<Product_Cloud> list_product = new ArrayList<Product_Cloud>();
        while (rs.next()) {
            list_product.add(new Product_Cloud(rs.getString(1), rs.getString(2),
                    rs.getString(3), rs.getString(4), rs.getString(5),
                    rs.getString(6), rs.getString(7), rs.getString(8), rs.getBytes(9), rs.getString(10)));
        }
        ac.setProduct_list(list_product);

        return ac;
    }
    
    public Acount_cloud Get_Account_CloudNOPASS(String gmail) throws SQLException, ClassNotFoundException {
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "";
        Acount_cloud ac = new Acount_cloud();

        // dowload data account cloud
        sql = "select * from Account where gmail_Account like ?";
        pr = con.prepareStatement(sql);
        pr.setString(1, gmail);
        rs = pr.executeQuery();
        if (rs.next()) {
            ac.setGmail_Account(rs.getString(1));
            ac.setType_account(rs.getString(2));
            ac.setPassword_account(rs.getString(3));
        } else {
            return null;
        }

        //dowload data account info
        sql = "select * from Account_info where gmail_Account like ?";
        pr = con.prepareStatement(sql);
        pr.setString(1, gmail);
        rs = pr.executeQuery();
        if (rs.next()) {
            ac.setAccount_info(new Account_info_Cloud(rs.getString(1), rs.getString(2),
                    rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getBytes(7), rs.getString(8)));
        }
        //dowload data Address_Account
        sql = "select * from Address_Account where gmail_Account like ?";
        pr = con.prepareStatement(sql);
        pr.setString(1, gmail);
        rs = pr.executeQuery();
        ArrayList<Account_Address_Cloud> list_adress = new ArrayList<Account_Address_Cloud>();
        while (rs.next()) {
            list_adress.add(new Account_Address_Cloud(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
        }
        ac.setAccount_Address_list(list_adress);
        //dowload data Product
        sql = "select * from product where gmail_Account like ?";
        pr = con.prepareStatement(sql);
        pr.setString(1, gmail);
        rs = pr.executeQuery();
        ArrayList<Product_Cloud> list_product = new ArrayList<Product_Cloud>();
        while (rs.next()) {
            list_product.add(new Product_Cloud(rs.getString(1), rs.getString(2),
                    rs.getString(3), rs.getString(4), rs.getString(5),
                    rs.getString(6), rs.getString(7), rs.getString(8), rs.getBytes(9), rs.getString(10)));
        }
        ac.setProduct_list(list_product);

        return ac;
    }

    public boolean Add_Account_Cloud(String gmail, String pass) throws SQLException, ClassNotFoundException {
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "";
        try {
            sql = "exec Register_Account ?,?,'user' ";
            pr = con.prepareStatement(sql);
            pr.setString(1, gmail);
            pr.setString(2, pass);
            pr.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean Insert_Account_Cloud(Acount_cloud ac) throws SQLException, ClassNotFoundException {
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "";
        try {
            sql = "exec Add_info_Account ?,?,?,?,?,?,?,?";
            pr = con.prepareStatement(sql);
            pr.setString(1, ac.getGmail_Account());
            pr.setString(2, ac.getAccount_info().getFname());
            pr.setString(3, ac.getAccount_info().getLname());
            pr.setString(4, ac.getAccount_info().getGender());
            pr.setString(5, ac.getAccount_info().getPhoneNumber());
            pr.setString(6, ac.getAccount_info().getBalance());
            pr.setBytes(7, ac.getAccount_info().getImg());
            pr.setString(8, new CurrentDate().GetDate());
            pr.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean Update_Account_Cloud(Acount_cloud ac) throws SQLException, ClassNotFoundException {
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "";
        try {
            sql = "exec Update_info_Account ?,?,?,?,?,?";
            pr = con.prepareStatement(sql);
            pr.setString(1, ac.getGmail_Account());
            pr.setString(2, ac.getAccount_info().getFname());
            pr.setString(3, ac.getAccount_info().getLname());
            pr.setString(4, ac.getAccount_info().getGender());
            pr.setString(5, ac.getAccount_info().getPhoneNumber());
            pr.setBytes(6, ac.getAccount_info().getImg());
            pr.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean Update_Pass(String pass,String gmail) throws SQLException, ClassNotFoundException {
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "";
        try {
            sql = "update Account set password_account=? where gmail_Account like ?";
            pr = con.prepareStatement(sql);
            pr.setString(1, pass);
            pr.setString(2, gmail);
            pr.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean Update_AmountProduct(String idpd,int amount) throws SQLException, ClassNotFoundException {
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "";
        try {
            sql = "update product set amount_product=? where id_product like ?";
            pr = con.prepareStatement(sql);
            pr.setInt(1, amount);
            pr.setString(2, idpd);
            pr.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean Update_AccountIMG_Cloud(byte[] img, String gmail) throws SQLException, ClassNotFoundException {
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "";
        try {
            sql = "UPDATE Account_info SET img=? where gmail_Account like ?";
            pr = con.prepareStatement(sql);
            pr.setBytes(1, img);
            pr.setString(2, gmail);
            pr.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean Add_Product_Cloud(Product_Cloud pd) throws SQLException, ClassNotFoundException {
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "";
        try {
            sql = "exec insert_Product ?,?,?,?,?,?,?,?,?";
            pr = con.prepareStatement(sql);
            pr.setString(1, pd.getGmail_Account());
            pr.setString(2, pd.getId_categories());
            pr.setString(3, pd.getName_product());
            pr.setString(4, pd.getValue_product_unit());
            pr.setString(5, pd.getValue_product_perunit());
            pr.setString(6, pd.getAmount_product());
            pr.setString(7, new CurrentDate().GetDate());
            pr.setBytes(8, pd.getImg());
            pr.setString(9, pd.getDescription());
            pr.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean Add_Adress_Account(String gmail, String city_register, String district_register, String Adress_register) throws SQLException, ClassNotFoundException {
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "";
        try {
            sql = "exec Add_Adress_Account ?,?,?,? ";
            pr = con.prepareStatement(sql);
            pr.setString(1, gmail);
            pr.setString(2, city_register);
            pr.setString(3, district_register);
            pr.setString(4, Adress_register);
            pr.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean Delete_Adress_Account(String gmail, String city_register, String district_register, String Adress_register) throws SQLException, ClassNotFoundException {
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "";
        try {
            sql = "exec Delete_Adress_Account ?,?,?,?";
            pr = con.prepareStatement(sql);
            pr.setString(1, gmail);
            pr.setString(2, city_register);
            pr.setString(3, district_register);
            pr.setString(4, Adress_register);
            pr.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean Update_Product_Cloud(Product_Cloud pd) throws SQLException, ClassNotFoundException {
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "";
        try {
            sql = "exec update_Product ?,?,?,?,?,?,?,?,?";
            pr = con.prepareStatement(sql);
            pr.setString(1, pd.getGmail_Account());
            pr.setString(2, pd.getId_product());
            pr.setString(3, pd.getId_categories());
            pr.setString(4, pd.getName_product());
            pr.setString(5, pd.getValue_product_unit());
            pr.setString(6, pd.getValue_product_perunit());
            pr.setString(7, pd.getAmount_product());
            pr.setBytes(8, pd.getImg());
            pr.setString(9, pd.getDescription());
            pr.execute();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

    public boolean Delete_Product_Cloud(String idpd, String gmail) throws SQLException, ClassNotFoundException {
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "";
        try {
            sql = "delete  from product where id_product like ? and gmail_Account like ?";
            pr = con.prepareStatement(sql);
            pr.setString(1, idpd);
            pr.setString(2, gmail);
            pr.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

    public boolean Update_ProductIMG_Cloud(byte[] img, String gmail, String idpd) throws SQLException, ClassNotFoundException {
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "";
        try {
            sql = "update product set img ='123' where gmail_account like'admin@gmail.com' and id_product like '3'";
            pr = con.prepareStatement(sql);
            pr.setBytes(1, img);
            pr.setString(2, gmail);
            pr.setString(3, idpd);
            pr.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean Insert_History(String ac, String content) throws SQLException, ClassNotFoundException {
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "";
        try {
            sql = "insert into historysearch(gmail_Account,content,date) values(?,?,?)";
            pr = con.prepareStatement(sql);
            pr.setString(1, ac);
            pr.setString(2, content);
            pr.setString(3, new CurrentDate().GetDate());
            pr.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean Insert_Comment(String idpd,String ac, String comment,int grade) throws SQLException, ClassNotFoundException {
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "";
        try {
            sql = "insert into commentItems(id_product,gmail_Account,comment,date,grade) values(?,?,?,?,?)";
            pr = con.prepareStatement(sql);
            pr.setString(1, idpd);
            pr.setString(2, ac);
            pr.setString(3, comment);
            pr.setString(4, new CurrentDate().GetDate());
            pr.setInt(5, grade);
            pr.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }
//    public static void main(String[] args) throws SQLException, SQLException, SQLException, SQLException, SQLException {
//        try {
//            System.out.println(new DAO().Insert_Comment("324","user@gmail.com","dmm",7));
//        } catch (SQLException ex) {
//            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    public ArrayList<Product_Cloud> GetAll_Product_Cloud(String idac) throws SQLException, ClassNotFoundException {
        ArrayList<Product_Cloud> list_product = new ArrayList<>();
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "";
        try {
            sql = "select * from product ";
            pr = con.prepareStatement(sql);
//            pr.setString(1, idac);
            rs = pr.executeQuery();
            while (rs.next()) {
                list_product.add(new Product_Cloud(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getBytes(9), rs.getString(10)));
            }
            return list_product;
        } catch (Exception e) {
            return null;
        }
    }
    
    public ArrayList<Product_Cloud> GetAll_Product_CloudCONSTGMAIL(String gmail) throws SQLException, ClassNotFoundException {
        ArrayList<Product_Cloud> list_product = new ArrayList<>();
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "";
        try {
            sql = "select * from product where gmail_Account like '"+gmail+"' ";
            pr = con.prepareStatement(sql);
            rs = pr.executeQuery();
            while (rs.next()) {
                list_product.add(new Product_Cloud(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getBytes(9), rs.getString(10)));
            }
            return list_product;
        } catch (Exception e) {
            return null;
        }
    }
  
    public boolean ReChargeAccount(String gmail, int amount) throws SQLException, ClassNotFoundException {
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "";
        try {
            sql = "update Account_info set "
                    + "balance=?+(select balance from Account_info where gmail_Account like ?) "
                    + "where gmail_Account like ?";
            pr = con.prepareStatement(sql);
            pr.setInt(1, amount);
            pr.setString(2, gmail);
            pr.setString(3, gmail);
            pr.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean CreateOrder(String id, String gmail_Account_sell, String gmail_Account_buy, String orderdate) throws SQLException, ClassNotFoundException {
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        //tao ma don
        String sql = "";
        sql = "insert into Order_product"
                + "(Id_order,gmail_Account_sell,gmail_Account_buy,orderdate_order_product)\n"
                + "values(?,?,?,?)";
        pr = con.prepareStatement(sql);
        pr.setString(1, id);
        pr.setString(2, gmail_Account_sell);
        pr.setString(3, gmail_Account_buy);
        pr.setString(4, orderdate);
        pr.executeUpdate();
        return true;
    }

    public boolean AddOrderDetail(String idOD, String idpd) throws SQLException, ClassNotFoundException {
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        //tao ma don
        String sql = "";
        sql = " exec insert_Order_details ?, ?";
        pr = con.prepareStatement(sql);
        pr.setString(1, idOD);
        pr.setString(2, idpd);
        pr.execute();
        return true;
    }

    public boolean AddOrderShip(String idOD, String idadd, String fee) throws SQLException, ClassNotFoundException {
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        //tao ma don
        String sql = "";
        sql = " exec insert_Ship_info "
                + "?, "
                + "?,"
                + "?, "
                + "?,"
                + "?, "
                + "?, "
                + "?,"
                + "?,"
                + "?";
        pr = con.prepareStatement(sql);
        Order_Product od = new DAO().Get_OrderProduct(idOD);
        Account_Address_Cloud ad = new libDao().Get_AccountAddress(idadd);
        pr.setString(1, idOD);
        pr.setString(2, new CurrentDate().GetDateAfterDays(7));
        pr.setString(3, ad.getStreet_Address());
        pr.setString(4, new libDao().GetNameCity(ad.getID_City_Address()));
        pr.setString(5, new libDao().GetNameDistrict(ad.getID_City_Address(), ad.getID_District_Address()));
        pr.setString(6, fee);
        pr.setString(7, "0");
        pr.setString(8, "0");
        pr.setString(9, "0");
        pr.execute();
        return true;
    }

    public Order_Product Get_OrderProduct(String idod) throws SQLException, ClassNotFoundException {
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        //tao ma don
        String sql = "";
        sql = "select * from Order_product where Id_order like ?";
        pr = con.prepareStatement(sql);
        pr.setString(1, idod);
        rs = pr.executeQuery();
        rs.next();
        return new Order_Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
    }

    public ArrayList<Order_Product> GetALL_OrderProductTYPEBUY(String gmailbuy, String type)
            throws SQLException, ClassNotFoundException {
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        ArrayList<Order_Product> list = new ArrayList<>();
        String sql = "";
        try {
            sql = "select * from Order_product as od\n"
                    + "join Ship_info as sp on od.Id_order=sp.Id_order\n"
                    + " where gmail_Account_buy like ? and ShippedDate_Ship_info=? order by orderdate_order_product DESC";
            pr = con.prepareStatement(sql);
            pr.setString(1, gmailbuy);
            pr.setString(2, type);
            rs = pr.executeQuery();
            while (rs.next()) {
                list.add(new Order_Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            return list;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public ArrayList<Order_Product> GetALL_OrderProductTYPESELL(String gmailbuy, String type)
            throws SQLException, ClassNotFoundException {
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        ArrayList<Order_Product> list = new ArrayList<>();
        String sql = "";
        try {
            sql = "select * from Order_product as od\n"
                    + "join Ship_info as sp on od.Id_order=sp.Id_order\n"
                    + " where ShippedDate_Ship_info=? order by orderdate_order_product DESC";
//            sql = "select * from Order_product as od\n"
//                    + "join Ship_info as sp on od.Id_order=sp.Id_order\n"
//                    + " where gmail_Account_sell like ? and ShippedDate_Ship_info=? order by orderdate_order_product DESC";
            pr = con.prepareStatement(sql);
//            pr.setString(1, gmailbuy);
//            pr.setString(2, type);
pr.setString(1, type);
            rs = pr.executeQuery();
            while (rs.next()) {
                list.add(new Order_Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            return list;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public ArrayList<Order_Product> GetALL_OrderProductCONSTSELLER(String gmailsell)
            throws SQLException, ClassNotFoundException {
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        ArrayList<Order_Product> list = new ArrayList<>();
        String sql = "";
        try {
            sql = "select * from Order_product where gmail_Account_sell like ? order by orderdate_order_product DESC";
            pr = con.prepareStatement(sql);
            pr.setString(1, gmailsell);
            rs = pr.executeQuery();
            while (rs.next()) {
                list.add(new Order_Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            return list;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public Ship_info Get_Ship_info(String idod) throws SQLException, ClassNotFoundException {
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        //tao ma don
        String sql = "";
        sql = "select * from Ship_info where Id_order like ?";
        pr = con.prepareStatement(sql);
        pr.setString(1, idod);
        rs = pr.executeQuery();
        rs.next();
        return new Ship_info(
                rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6),
                rs.getString(7),
                rs.getString(8),
                rs.getString(9),
                rs.getString(10));
    }

    public String ValidAccount(String username, String password) throws SQLException, ClassNotFoundException {
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "select * from account where gmail_Account like ? and password_account like ?";
        pr = con.prepareStatement(sql);
        pr.setString(1, username);
        pr.setString(2, password);
        rs = pr.executeQuery();
        if (rs.next()) {
            return rs.getString(1);
        }
        pr.close();
        rs.close();
        con.close();
        return null;
    }

    public Account GetAccount(String username, String password) throws SQLException, ClassNotFoundException {
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String sql = "select * from account where gmail_Account like ? and password_account like ?";
            pr = con.prepareStatement(sql);
            pr.setString(1, username);
            pr.setString(2, password);
            rs = pr.executeQuery();
            if (rs.next()) {
                return new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            } else {
                System.err.println("My Notice:Else case return Null");
                return null;
            }
        } catch (Exception e) {
            System.err.println("My Notice:Catch case return Null");
            return null;
        } finally {
            pr.close();
            rs.close();
            con.close();
        }

    }

    public ArrayList<Product_model> GetN_Product_byLastest(int num) throws SQLException, ClassNotFoundException {
        ArrayList<Product_model> list = new ArrayList<>();
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String sql = "select * from product_seller \n"
                    + "order by  create_date_product\n"
                    + "OFFSET 0 ROWS\n"
                    + "FETCH NEXT ? ROWS ONLY";
            pr = con.prepareStatement(sql);
            pr.setInt(1, num);
            rs = pr.executeQuery();
            while (rs.next()) {
                list.add(new Product_model(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
            }
            return list;
        } catch (Exception e) {
            System.err.println("My Notice:List return Null");
            return null;
        } finally {
            try {
                pr.close();
                rs.close();
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public ArrayList<City_Address_model> GetAll_City_Address_byName() throws SQLException, ClassNotFoundException {
        ArrayList<City_Address_model> list = new ArrayList<>();
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String sql = "select * from City_Address order by Name_City_Address";
            pr = con.prepareStatement(sql);
            rs = pr.executeQuery();
            while (rs.next()) {
                list.add(new City_Address_model(rs.getString(1), rs.getString(2)));
            }
            return list;
        } catch (Exception e) {
            System.err.println("My Notice:List return Null");
            return null;
        } finally {
            try {
                pr.close();
                rs.close();
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public ArrayList<District_Address_model> GetAll_District_Address_byCity(String id_city) throws SQLException, ClassNotFoundException {
        ArrayList<District_Address_model> list = new ArrayList<>();
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String sql = "select * from District_Address where ID_City_Address like ?";
            pr = con.prepareStatement(sql);
            pr.setString(1, id_city);
            rs = pr.executeQuery();
            while (rs.next()) {
                list.add(new District_Address_model(rs.getString(2), rs.getString(1), rs.getString(3)));
            }
            return list;
        } catch (Exception e) {
            System.err.println("My Notice:List return Null");
            return null;
        } finally {
            try {
                pr.close();
                rs.close();
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public All_In4_Account_Seller GET_All_In4_Account_Seller(String id_account) throws SQLException, ClassNotFoundException {
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String sql = ""
                    + "select ac.id_account,ac.gmail_Account,ac.Fname,ac.Lname,ac.gender,ac.type_account,ac.password_account,ac.create_date_account,sl.id_seller,sl.ShopDomain_seller,sl.PhoneNumber_seller,sl.img_seller,adc.ID_City_Address,adc.ID_District_Address,adc.Street_Address_Seller from Account as ac\n"
                    + "join seller as sl on sl.id_account=ac.id_account\n"
                    + "join Address_Account as adc on adc.id_account=ac.id_account\n"
                    + "where ac.id_account like ?";
            pr = con.prepareStatement(sql);
            pr.setString(1, id_account);
            rs = pr.executeQuery();
            if (rs.next()) {
                return new All_In4_Account_Seller(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getBytes(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        new DAO().GetAll_Address_Account(id_account));
            } else {
                return null;
            }
        } catch (Exception e) {
            System.err.println("My Notice:List return Null");
            return null;
        } finally {
            try {
                pr.close();
                rs.close();
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public ArrayList<All_Address_Account> GetAll_Address_Account(String id_city) throws SQLException, ClassNotFoundException {
        ArrayList<All_Address_Account> list = new ArrayList<>();
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String sql = "select cd.Name_City_Address,da.Name_District_Address,aa.Street_Address_Seller,aa.id_account,aa.gmail_Account from Address_Account as aa \n"
                    + "join City_Address as cd on cd.ID_City_Address=aa.ID_City_Address\n"
                    + "join District_Address as da on da.ID_District_Address=aa.ID_District_Address\n"
                    + "where id_account like ?";
            pr = con.prepareStatement(sql);
            pr.setString(1, id_city);
            rs = pr.executeQuery();
            while (rs.next()) {
                list.add(new All_Address_Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(3)));
            }
            return list;
        } catch (Exception e) {
            System.err.println("My Notice:List return Null");
            return null;
        } finally {
            try {
                pr.close();
                rs.close();
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public City_Address_model Get_City_Address_byCity(String id_city) throws SQLException, ClassNotFoundException {
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String sql = "select * from City_Address where ID_City_Address like ?";
            pr = con.prepareStatement(sql);
            pr.setString(1, id_city);
            rs = pr.executeQuery();
            if (rs.next()) {
                return new City_Address_model(id_city, rs.getString(2));
            }
            return null;
        } catch (Exception e) {
            System.err.println("My Notice:List return Null");
            return null;
        } finally {
            try {
                pr.close();
                rs.close();
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public District_Address_model Get_District_Address_byDistrict(String id_city, String id_district) throws SQLException, ClassNotFoundException {
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String sql = "select * from District_Address where ID_City_Address like ? and ID_District_Address like ?";
            pr = con.prepareStatement(sql);
            pr.setString(1, id_city);
            pr.setString(2, id_district);
            rs = pr.executeQuery();
            if (rs.next()) {
                return new District_Address_model(id_district, id_city, rs.getString(3));
            }
            return null;
        } catch (Exception e) {
            System.err.println("My Notice:List return Null");
            return null;
        } finally {
            try {
                pr.close();
                rs.close();
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    public boolean Update_img_account(byte[] img, String id_seller) throws SQLException, ClassNotFoundException {
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String sql = "UPDATE seller\n"
                    + "SET img_seller=?\n"
                    + "WHERE id_seller like ?;";
            pr = con.prepareStatement(sql);
            pr.setBytes(1, img);
            pr.setString(2, id_seller);
            pr.executeUpdate();

            return true;
        } catch (Exception e) {
            System.err.println("My Notice:List return Null");
            return false;
        } finally {
            try {
                pr.close();
                rs.close();
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public boolean Update_Account(All_In4_Account_Seller all) throws SQLException, ClassNotFoundException {
        Connection con = Connect();
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String sql = "update Account set Fname=?,Lname=?,gender=? where id_account=?\n"
                    + "update seller set PhoneNumber_seller=?,ShopDomain_seller=? where id_account=?";
            pr = con.prepareStatement(sql);
            pr.setString(1, all.getFname());
            pr.setString(2, all.getLname());
            pr.setString(3, all.getGender());
            pr.setString(4, all.getId_account());
            pr.setString(5, all.getPhoneNumber_seller());
            pr.setString(6, all.getShopDomain_seller());
            pr.setString(7, all.getId_account());
//            pr.setString(8, all.getFname());
            pr.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("My Notice:List return Null");
            return false;
        } finally {
            try {
                pr.close();
                rs.close();
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public ArrayList<Product_Cloud> Get_Product_List_SEARCHCORE(int OFFSET, int FETCH, String col_order_type_order, String col_condition) throws SQLException, ClassNotFoundException {
        Connection connection = Connect();
        try {
            ArrayList<Product_Cloud> list = new ArrayList<>();
            PreparedStatement pr = null;
            ResultSet rs = null;
            String sql = "select * from product ";
            //DEMOOO
            if (FETCH == 0 && col_order_type_order.equals("none")) {
                if (!col_condition.equals("none")) {
                    sql += " where " + col_condition;
                }
                pr = connection.prepareStatement(sql);
            }
            if (FETCH == 0 && !col_order_type_order.equals("none")) {
                if (!col_condition.equals("none")) {
                    sql += " where " + col_condition;
                }
                sql += " order by " + col_order_type_order;
                pr = connection.prepareStatement(sql);
            }
            if (FETCH > 0 && !col_order_type_order.equals("none")) {
                if (!col_condition.equals("none")) {
                    sql += " where " + col_condition;
                }
                sql += " order by " + col_order_type_order + " OFFSET " + OFFSET + " ROWS " + "FETCH NEXT " + FETCH + " ROWS ONLY";
                System.out.println(sql);
                pr = connection.prepareStatement(sql);
            }
            rs = pr.executeQuery();
            while (rs.next()) {
                list.add(new Product_Cloud(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getBytes(9), rs.getString(10)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Product_Cloud> Get_List_Core(String selecttable, int OFFSET, int FETCH, String col_order_type_order, String col_condition) throws SQLException, ClassNotFoundException {
        Connection connection = Connect();
        try {
            ArrayList<Product_Cloud> list = new ArrayList<>();
            PreparedStatement pr = null;
            ResultSet rs = null;
            String sql = selecttable;
            //DEMOOO
            if (FETCH == 0 && col_order_type_order.equals("none")) {
                if (!col_condition.equals("none")) {
                    sql += " where " + col_condition;
                }
                pr = connection.prepareStatement(sql);
            }
            if (FETCH == 0 && !col_order_type_order.equals("none")) {
                if (!col_condition.equals("none")) {
                    sql += " where " + col_condition;
                }
                sql += " order by " + col_order_type_order;
                pr = connection.prepareStatement(sql);
            }
            if (FETCH > 0 && !col_order_type_order.equals("none")) {
                if (!col_condition.equals("none")) {
                    sql += " where " + col_condition;
                }
                sql += " order by " + col_order_type_order + " OFFSET " + OFFSET + " ROWS " + "FETCH NEXT " + FETCH + " ROWS ONLY";
                System.out.println(sql);
                pr = connection.prepareStatement(sql);
            }
            rs = pr.executeQuery();
            while (rs.next()) {
                list.add(new libDao().Get_Product(rs.getString(1), ""));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Product_Cloud> Get_List_SearchHistoryItems(String gmail, int OFFSET, int FETCH, String col_order_type_order, String col_condition) throws SQLException, ClassNotFoundException {
        Connection connection = Connect();
        try {
            ArrayList<Product_Cloud> list = new ArrayList<>();
            PreparedStatement pr = null;
            ResultSet rs = null;
            String sql = "";

            //col codition 
            sql = "select * from historysearch where gmail_Account like '" + gmail + "'\n"
                    + "order by historysearch.date DESC";
            pr = connection.prepareStatement(sql);
            rs = pr.executeQuery();
            boolean next = false;
            while (rs.next()) {
                col_condition += " (freetext(product.*,N'" + rs.getString(2) + "'))or";
                System.out.println(rs.getString(2));
//                        col_condition += " (freetext(product.*,N'" + rs.getString(2) + "')) ";

            }
//            col_condition=col_condition.trim().replace(col_condition.trim().substring(col_condition.trim().length()-1), "");
//            col_condition=col_condition.replace(col_condition.substring(col_condition.length()-1), "");
            if (!col_condition.isEmpty()) {
                col_condition = col_condition.substring(0, col_condition.length() - 2);
                sql = "select * from product";
                pr = null;
                rs = null;
                System.out.println(col_condition);
                sql = "select * from product where " + col_condition + "";
                System.out.println(sql);
                pr = connection.prepareStatement(sql);
                rs = pr.executeQuery();
                rs = pr.executeQuery();
                System.out.println(sql);
                while (rs.next()) {
                    list.add(new libDao().Get_Product(rs.getString(1), ""));
                }
                return list;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        // lenh get all 0 0 none none
////        System.out.println(new DAO().Get_Product_List_SEARCHCORE(0, 0, "none", "none"));
//        //
//        System.out.println(new DAO().Get_List_SearchHistoryItems("user@gmail.com", 0, 0, "", ""));
//    }
}
