/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author l
 */
public class Hotel {

    private int hid;
    private String hname;
    private String adress;
    private String city;
    private String phone;
    private String description;
    private String imageURL;
    private String typeid;
    private ArrayList<Room> rooms;
    private ArrayList<Type> types;

    public Hotel() {
    }

    public Hotel(int hid, String hname, String adress, String city, String phone, String description, String imageURL, String typeid, ArrayList<Room> rooms, ArrayList<Type> types) {
        this.hid = hid;
        this.hname = hname;
        this.adress = adress;
        this.city = city;
        this.phone = phone;
        this.description = description;
        this.imageURL = imageURL;
        this.typeid = typeid;
        this.rooms = rooms;
        this.types = types;
    }

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public ArrayList<Type> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<Type> types) {
        this.types = types;
    }

    @Override
    public String toString() {
        return "Hotel{" + "hid=" + hid + ", hname=" + hname + ", adress=" + adress + ", city=" + city + ", phone=" + phone + ", description=" + description + ", imageURL=" + imageURL + ", typeid=" + typeid + ", rooms=" + rooms + ", types=" + types + '}';
    }
    
    

    
}
