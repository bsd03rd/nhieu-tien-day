/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 
 */
public class Account {
String  id_account ;
String gmail_Account ;
String type_account ;
String password_account ;
String create_date_account ;

    public Account() {
    }

    public Account(String id_account, String gmail_Account, String type_account, String password_account, String create_date_account) {
        this.id_account = id_account;
        this.gmail_Account = gmail_Account;
        this.type_account = type_account;
        this.password_account = password_account;
        this.create_date_account = create_date_account;
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

    @Override
    public String toString() {
        return "Account{" + "id_account=" + id_account + ", gmail_Account=" + gmail_Account + ", type_account=" + type_account + ", password_account=" + password_account + ", create_date_account=" + create_date_account + '}';
    }
    
    
}
