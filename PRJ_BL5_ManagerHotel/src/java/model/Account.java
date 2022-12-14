/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author l
 */
public class Account {

    private int aid;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String email;
    private int roleID;

    public Account() {
    }

    public Account(int aid, String username, String password, String name, String phone, String email, int roleID) {
        this.aid = aid;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.roleID = roleID;
    }

    public Account(String username, String password, int roleID) {
        this.username = username;
        this.password = password;
        this.roleID = roleID;
    }
    public Account(int aid,String username, String password, int roleID) {
        this.aid = aid;
        this.username = username;
        this.password = password;
        this.roleID = roleID;
    }


    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    @Override
    public String toString() {
        return "Account{" + "aid=" + aid + ", username=" + username + ", password=" + password + ", name=" + name + ", phone=" + phone + ", email=" + email + ", roleID=" + roleID + '}';
    }

}
