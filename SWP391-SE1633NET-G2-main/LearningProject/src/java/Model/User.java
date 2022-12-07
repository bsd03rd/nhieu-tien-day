/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author Hieu Shin
 */
public class User {

    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String country;
    private String city;
    private String address;
    private Date dob;
    private String postCode;
    private int balance;
    private String avatar;
    private String userName;
    private String password;
    private String role;
    private String bankNum;
    private String bankName;
    private boolean isDisable;

    public User() {
    }

    public User(String firstName, String lastName, String email, String phone, String country, String city, String address, Date dob, String postCode, int balance, String avatar, String userName, String password, String role, String bankNum, String bankName, boolean isDisable) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.country = country;
        this.city = city;
        this.address = address;
        this.dob = dob;
        this.postCode = postCode;
        this.balance = balance;
        this.avatar = avatar;
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.bankNum = bankNum;
        this.bankName = bankName;
        this.isDisable = isDisable;
    }

    public User(int userId, String firstName, String lastName, String email, String phone, String country, String city, String address, Date dob, String postCode, int balance, String avatar, String userName, String password, String role, String bankNum, String bankName, boolean isDisable) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.country = country;
        this.city = city;
        this.address = address;
        this.dob = dob;
        this.postCode = postCode;
        this.balance = balance;
        this.avatar = avatar;
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.bankNum = bankNum;
        this.bankName = bankName;
        this.isDisable = isDisable;
    }

    public User(int userId, String firstName, String lastName, String email, String phone, int balance, String avatar, String role, boolean isDisable) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.balance = balance;
        this.avatar = avatar;
        this.role = role;
        this.isDisable = isDisable;
    }
    
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankNum() {
        return bankNum;
    }

    public void setBankNum(String bankNum) {
        this.bankNum = bankNum;
    }

    public boolean getIsDisable() {
        return isDisable;
    }

    public void setIsDisable(boolean isDisable) {
        this.isDisable = isDisable;
    }
    
    
}
