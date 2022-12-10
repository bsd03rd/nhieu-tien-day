/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author BachDuc
 */
public class Account_info_Cloud {

    String gmail_Account;
    String Fname;
    String Lname;
    String gender;
    String balance;
    String PhoneNumber;
    byte[] img;
    String create_date_account;

    public Account_info_Cloud(String gmail_Account, String Fname, String Lname, String gender, String balance, String PhoneNumber, byte[] img, String create_date_account) {
        this.gmail_Account = gmail_Account;
        this.Fname = Fname;
        this.Lname = Lname;
        this.gender = gender;
        this.balance = balance;
        this.PhoneNumber = PhoneNumber;
        this.img = img;
        this.create_date_account = create_date_account;
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

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public String getCreate_date_account() {
        return create_date_account;
    }

    public void setCreate_date_account(String create_date_account) {
        this.create_date_account = create_date_account;
    }

    @Override
    public String toString() {
        return "Account_info_Cloud{" + "gmail_Account=" + gmail_Account + ", Fname=" + Fname + ", Lname=" + Lname + ", gender=" + gender + ", balance=" + balance + ", PhoneNumber=" + PhoneNumber + ", img=" + img + ", create_date_account=" + create_date_account + '}';
    }
    
    
    
    
}
