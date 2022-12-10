/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author BachDuc
 */
public class Acount_cloud {

    String gmail_Account;
    String type_account;
    String password_account;
    Account_info_Cloud Account_info;
    ArrayList<Account_Address_Cloud> Account_Address_list;
    ArrayList<Product_Cloud> Product_list;

    public Acount_cloud() {
        
    }

    public Acount_cloud(String gmail_Account, String type_account, String password_account, Account_info_Cloud Account_info, ArrayList<Account_Address_Cloud> Account_Address_list, ArrayList<Product_Cloud> Product_list) {
        this.gmail_Account = gmail_Account;
        this.type_account = type_account;
        this.password_account = password_account;
        this.Account_info = Account_info;
        this.Account_Address_list = Account_Address_list;
        this.Product_list = Product_list;
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

    public Account_info_Cloud getAccount_info() {
        return Account_info;
    }

    public void setAccount_info(Account_info_Cloud Account_info) {
        this.Account_info = Account_info;
    }

    public ArrayList<Account_Address_Cloud> getAccount_Address_list() {
        return Account_Address_list;
    }

    public void setAccount_Address_list(ArrayList<Account_Address_Cloud> Account_Address_list) {
        this.Account_Address_list = Account_Address_list;
    }

    public ArrayList<Product_Cloud> getProduct_list() {
        return Product_list;
    }

    public void setProduct_list(ArrayList<Product_Cloud> Product_list) {
        this.Product_list = Product_list;
    }

    @Override
    public String toString() {
        return "Acount_cloud{" + "gmail_Account=" + gmail_Account + ", type_account=" + type_account + ", password_account=" + password_account + ", Account_info=" + Account_info + ", Account_Address_list=" + Account_Address_list + ", Product_list=" + Product_list + '}';
    }

}
