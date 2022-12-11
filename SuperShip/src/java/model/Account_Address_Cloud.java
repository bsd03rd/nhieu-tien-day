/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 
 */
public class Account_Address_Cloud {
   
    String gmail_Account;
    String ID_City_Address;
    String ID_District_Address;
    String Street_Address;
    String idadd;
    public Account_Address_Cloud() {
    }

    public Account_Address_Cloud(String gmail_Account, String ID_City_Address, String ID_District_Address, String Street_Address) {
        this.gmail_Account = gmail_Account;
        this.ID_City_Address = ID_City_Address;
        this.ID_District_Address = ID_District_Address;
        this.Street_Address = Street_Address;
    }

    public Account_Address_Cloud(String gmail_Account, String ID_City_Address, String ID_District_Address, String Street_Address, String idadd) {
        this.gmail_Account = gmail_Account;
        this.ID_City_Address = ID_City_Address;
        this.ID_District_Address = ID_District_Address;
        this.Street_Address = Street_Address;
        this.idadd = idadd;
    }

    
 
    public String getIdadd() {
        return idadd;
    }

    public void setIdadd(String idadd) {
        this.idadd = idadd;
    }

    public String getGmail_Account() {
        return gmail_Account;
    }

    public void setGmail_Account(String gmail_Account) {
        this.gmail_Account = gmail_Account;
    }

    public String getID_City_Address() {
        return ID_City_Address;
    }

    public void setID_City_Address(String ID_City_Address) {
        this.ID_City_Address = ID_City_Address;
    }

    public String getID_District_Address() {
        return ID_District_Address;
    }

    public void setID_District_Address(String ID_District_Address) {
        this.ID_District_Address = ID_District_Address;
    }

    public String getStreet_Address() {
        return Street_Address;
    }

    public void setStreet_Address(String Street_Address) {
        this.Street_Address = Street_Address;
    }

    @Override
    public String toString() {
        return "Account_Address_Cloud{" + "gmail_Account=" + gmail_Account + ", ID_City_Address=" + ID_City_Address + ", ID_District_Address=" + ID_District_Address + ", Street_Address=" + Street_Address + '}';
    }
    
    
}
