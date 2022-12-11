/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author 
 */
public class All_In4_Account_Seller {
String id_account ;
String gmail_Account ;
String Fname ;
String Lname ;
String gender ;
String type_account ;
String password_account ;
String create_date_account ;
String id_seller ;
String ShopDomain_seller ;
String PhoneNumber_seller ;
byte[] img_seller ;
String ID_City_Address ;
String ID_District_Address  ;
String Street_Address_Seller ;
ArrayList<All_Address_Account> Address_Account;

    public All_In4_Account_Seller() {
    }

    public All_In4_Account_Seller(String id_account, String gmail_Account, String Fname, String Lname, String gender, String type_account, String password_account, String create_date_account, String id_seller, String ShopDomain_seller, String PhoneNumber_seller, byte[] img_seller, String ID_City_Address, String ID_District_Address, String Street_Address_Seller) {
        this.id_account = id_account;
        this.gmail_Account = gmail_Account;
        this.Fname = Fname;
        this.Lname = Lname;
        this.gender = gender;
        this.type_account = type_account;
        this.password_account = password_account;
        this.create_date_account = create_date_account;
        this.id_seller = id_seller;
        this.ShopDomain_seller = ShopDomain_seller;
        this.PhoneNumber_seller = PhoneNumber_seller;
        this.img_seller = img_seller;
        this.ID_City_Address = ID_City_Address;
        this.ID_District_Address = ID_District_Address;
        this.Street_Address_Seller = Street_Address_Seller;
    }

    public All_In4_Account_Seller(String id_account, String gmail_Account, String Fname, String Lname, String gender, String type_account, String password_account, String create_date_account, String id_seller, String ShopDomain_seller, String PhoneNumber_seller, byte[] img_seller, String ID_City_Address, String ID_District_Address, String Street_Address_Seller, ArrayList<All_Address_Account> Address_Account) {
        this.id_account = id_account;
        this.gmail_Account = gmail_Account;
        this.Fname = Fname;
        this.Lname = Lname;
        this.gender = gender;
        this.type_account = type_account;
        this.password_account = password_account;
        this.create_date_account = create_date_account;
        this.id_seller = id_seller;
        this.ShopDomain_seller = ShopDomain_seller;
        this.PhoneNumber_seller = PhoneNumber_seller;
        this.img_seller = img_seller;
        this.ID_City_Address = ID_City_Address;
        this.ID_District_Address = ID_District_Address;
        this.Street_Address_Seller = Street_Address_Seller;
        this.Address_Account = Address_Account;
    }
    

    public String getId_account() {
        return id_account;
    }

    public void setId_account(String id_account) {
        this.id_account = id_account;
    }

    public String getGmail_Account() {
        return gmail_Account;
    }

    public void setGmail_Account(String gmail_Account) {
        this.gmail_Account = gmail_Account;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getType_account() {
        return type_account;
    }

    public void setType_account(String type_account) {
        this.type_account = type_account;
    }

    public String getPassword_account() {
        return password_account;
    }

    public void setPassword_account(String password_account) {
        this.password_account = password_account;
    }

    public String getCreate_date_account() {
        return create_date_account;
    }

    public void setCreate_date_account(String create_date_account) {
        this.create_date_account = create_date_account;
    }

    public String getId_seller() {
        return id_seller;
    }

    public void setId_seller(String id_seller) {
        this.id_seller = id_seller;
    }

    public String getShopDomain_seller() {
        return ShopDomain_seller;
    }

    public void setShopDomain_seller(String ShopDomain_seller) {
        this.ShopDomain_seller = ShopDomain_seller;
    }

    public String getPhoneNumber_seller() {
        return PhoneNumber_seller;
    }

    public void setPhoneNumber_seller(String PhoneNumber_seller) {
        this.PhoneNumber_seller = PhoneNumber_seller;
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

    public String getStreet_Address_Seller() {
        return Street_Address_Seller;
    }

    public void setStreet_Address_Seller(String Street_Address_Seller) {
        this.Street_Address_Seller = Street_Address_Seller;
    }

    public ArrayList<All_Address_Account> getAddress_Account() {
        return Address_Account;
    }

    public void setAddress_Account(ArrayList<All_Address_Account> Address_Account) {
        this.Address_Account = Address_Account;
    }

    public byte[] getImg_seller() {
        return img_seller;
    }

    public void setImg_seller(byte[] img_seller) {
        this.img_seller = img_seller;
    }

    @Override
    public String toString() {
        return "All_In4_Account_Seller{" + "id_account=" + id_account + ", gmail_Account=" + gmail_Account + ", Fname=" + Fname + ", Lname=" + Lname + ", gender=" + gender + ", type_account=" + type_account + ", password_account=" + password_account + ", create_date_account=" + create_date_account + ", id_seller=" + id_seller + ", ShopDomain_seller=" + ShopDomain_seller + ", PhoneNumber_seller=" + PhoneNumber_seller + ", img_seller=" + img_seller + ", ID_City_Address=" + ID_City_Address + ", ID_District_Address=" + ID_District_Address + ", Street_Address_Seller=" + Street_Address_Seller + ", Address_Account=" + Address_Account + '}';
    }

    

   
    
   
    


}
