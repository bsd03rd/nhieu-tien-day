/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 
 */
public class All_Address_Account {

    String Name_City_Address;
    String Name_District_Address;
    String Street_Address_Seller;
    String gmail_Account;

    public All_Address_Account() {
    }

    public All_Address_Account(String Name_City_Address, String Name_District_Address, String Street_Address_Seller, String gmail_Account) {
        this.Name_City_Address = Name_City_Address;
        this.Name_District_Address = Name_District_Address;
        this.Street_Address_Seller = Street_Address_Seller;
        this.gmail_Account = gmail_Account;
    }

    public String getName_City_Address() {
        return Name_City_Address;
    }

    public void setName_City_Address(String ID_City_Address) {
        this.Name_City_Address = ID_City_Address;
    }

    public String getName_District_Address() {
        return Name_District_Address;
    }

    public void setName_District_Address(String ID_District_Address) {
        this.Name_District_Address = ID_District_Address;
    }

    public String getStreet_Address_Seller() {
        return Street_Address_Seller;
    }

    public void setStreet_Address_Seller(String Street_Address_Seller) {
        this.Street_Address_Seller = Street_Address_Seller;
    }

    public String getGmail_Account() {
        return gmail_Account;
    }

    public void setGmail_Account(String gmail_Account) {
        this.gmail_Account = gmail_Account;
    }

    @Override
    public String toString() {
        return "All_Address_Account{" + "ID_City_Address=" + Name_District_Address + ", ID_District_Address=" + Street_Address_Seller + ", Street_Address_Seller=" + Street_Address_Seller + ", gmail_Account=" + gmail_Account + '}';
    }
    
    
}
