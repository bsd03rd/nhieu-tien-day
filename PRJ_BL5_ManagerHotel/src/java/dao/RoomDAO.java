/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Hotel;
import model.Room;
import model.Type;

/**
 *
 * @author l
 */
public class RoomDAO extends DBContext {

    public ArrayList<Room> getHotelDetails(int aid) {
        ArrayList<Room> room = new ArrayList<>();
        try {
            String sql = "SELECT \n"
                    + "hotel.hid, hotel.adress, hotel.phone, hotel.description, hotel.imageURL, \n"
                    + "room.rid, room.hotelID , hotel.name as hname, room.name as rname, room.roomtype, room.quantity, room.price, \n"
                    + "room.description as rdescription, room.status, room.imageURL as rimageURL,\n"
                    + "type.name, type.tid\n"
                    + "FROM hotel\n"
                    + "INNER JOIN room ON hotel.hid = room.hotelID\n"
                    + "INNER join type on hotel.typeid = type.tid\n"
                    + "where room.hotelid=?\n"
                    + "order by room.rid";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, aid);
           
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Room r = new Room();
                Hotel h = new Hotel();
                Type t = new Type();

                h.setHid(rs.getInt("hid"));
                h.setHname(rs.getString("name"));
                h.setAdress(rs.getString("adress"));
                h.setPhone(rs.getString("phone"));
                h.setDescription(rs.getString("description"));
                h.setImageURL(rs.getString("imageURL"));

                r.setRid(rs.getInt("rid"));
                r.setHotelid(rs.getInt("hotelID"));
                r.setRname(rs.getString("rname"));
                r.setRoomtype(rs.getString("roomtype"));
                r.setQuantity(rs.getInt("quantity"));
                r.setPrice(rs.getInt("price"));
                r.setRdescription(rs.getString("rdescription"));
                r.setStatus(rs.getBoolean("status"));
                r.setRimageURL((rs.getString("rimageURL")));
                r.setHotel(h);

                t.setTid(rs.getInt("tid"));
                t.setName(rs.getString("name"));
                r.setType(t);

                room.add(r);
            }
        } catch (SQLException ex) {
        }
        return room;
    }
    
     public Account addbooking(String rid,String acid,String from,String end,String num) {
        String sql = "insert into Booking(roomID,accountID,datefrom,dateto,numPeople,status) values(?,?,?,?,?,?);";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, rid);
            st.setString(2, acid);
            st.setString(3, from);
            st.setString(4, end);
            st.setString(5, num);
            st.setBoolean(6, true);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    

    public static void main(String[] args) {
        RoomDAO pro = new RoomDAO();
        pro.addbooking("1","1", "1-1-2002", "1-1-2002", "5");
    }

   

}
