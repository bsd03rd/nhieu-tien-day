/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author l
 */
public class Room {

    private int rid;
    private int hotelid;
    private String rname;
    private String roomtype;
    private int quantity;
    private int price;
    private String rdescription;
    private boolean status;
    private String rimageURL;
    private Hotel hotel;
    private Type type;

    public Room() {
    }

    public Room(int rid, int hotelid, String rname, String roomtype, int quantity, int price, String rdescription, boolean status, String rimageURL, Hotel hotel, Type type) {
        this.rid = rid;
        this.hotelid = hotelid;
        this.rname = rname;
        this.roomtype = roomtype;
        this.quantity = quantity;
        this.price = price;
        this.rdescription = rdescription;
        this.status = status;
        this.rimageURL = rimageURL;
        this.hotel = hotel;
        this.type = type;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getHotelid() {
        return hotelid;
    }

    public void setHotelid(int hotelid) {
        this.hotelid = hotelid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getRdescription() {
        return rdescription;
    }

    public void setRdescription(String rdescription) {
        this.rdescription = rdescription;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getRimageURL() {
        return rimageURL;
    }

    public void setRimageURL(String rimageURL) {
        this.rimageURL = rimageURL;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Room{" + "rid=" + rid + ", hotelid=" + hotelid + ", rname=" + rname + ", roomtype=" + roomtype + ", quantity=" + quantity + ", price=" + price + ", rdescription=" + rdescription + ", status=" + status + ", rimageURL=" + rimageURL + ", hotel=" + hotel + ", type=" + type + '}';
    }

}
