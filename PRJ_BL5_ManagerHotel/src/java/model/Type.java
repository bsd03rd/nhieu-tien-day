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
public class Type {

    private int tid;
    private String name;
    private Hotel hotel;
    private ArrayList<Room> rooms;

    public Type() {
    }

    public Type(int tid, String name, Hotel hotel, ArrayList<Room> rooms) {
        this.tid = tid;
        this.name = name;
        this.hotel = hotel;
        this.rooms = rooms;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Type{" + "tid=" + tid + ", name=" + name + ", hotel=" + hotel + ", rooms=" + rooms + '}';
    }

}
