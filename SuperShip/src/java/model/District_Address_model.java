/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 
 */
public class District_Address_model {

    String ID_District_Address;
    String ID_City_Address;
    String Name_District_Address;

    public District_Address_model() {
    }

    public District_Address_model(String ID_District_Address, String ID_City_Address, String Name_District_Address) {
        this.ID_District_Address = ID_District_Address;
        this.ID_City_Address = ID_City_Address;
        this.Name_District_Address = Name_District_Address;
    }

    public String getID_District_Address() {
        return ID_District_Address;
    }

    public void setID_District_Address(String ID_District_Address) {
        this.ID_District_Address = ID_District_Address;
    }

    public String getID_City_Address() {
        return ID_City_Address;
    }

    public void setID_City_Address(String ID_City_Address) {
        this.ID_City_Address = ID_City_Address;
    }

    public String getName_District_Address() {
        return Name_District_Address;
    }

    public void setName_District_Address(String Name_District_Address) {
        this.Name_District_Address = Name_District_Address;
    }

    @Override
    public String toString() {
        return "District_Address_model{" + "ID_District_Address=" + ID_District_Address + ", ID_City_Address=" + ID_City_Address + ", Name_District_Address=" + Name_District_Address + '}';
    }
    
    
}
