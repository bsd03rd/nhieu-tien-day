/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author BachDuc
 */
public class City_Address_model {
    String ID_City_Address;
    String Name_City_Address;

    public City_Address_model() {
    }

    public City_Address_model(String ID_City_Address, String Name_City_Address) {
        this.ID_City_Address = ID_City_Address;
        this.Name_City_Address = Name_City_Address;
    }

    public String getID_City_Address() {
        return ID_City_Address;
    }

    public void setID_City_Address(String ID_City_Address) {
        this.ID_City_Address = ID_City_Address;
    }

    public String getName_City_Address() {
        return Name_City_Address;
    }

    public void setName_City_Address(String Name_City_Address) {
        this.Name_City_Address = Name_City_Address;
    }

    @Override
    public String toString() {
        return "City_Address_model{" + "ID_City_Address=" + ID_City_Address + ", Name_City_Address=" + Name_City_Address + '}';
    }
    
}
