/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author BachDuc
 */
public class Order_Product {
    
String Id_order;
String gmail_Account_sell;
String gmail_Account_buy ;
String orderdate_order_produc;

    public Order_Product(String Id_order, String gmail_Account_sell, String gmail_Account_buy, String orderdate_order_produc) {
        this.Id_order = Id_order;
        this.gmail_Account_sell = gmail_Account_sell;
        this.gmail_Account_buy = gmail_Account_buy;
        this.orderdate_order_produc = orderdate_order_produc;
    }

    public Order_Product() {
    }

    public String getId_order() {
        return Id_order;
    }

    public void setId_order(String Id_order) {
        this.Id_order = Id_order;
    }

    public String getGmail_Account_sell() {
        return gmail_Account_sell;
    }

    public void setGmail_Account_sell(String gmail_Account_sell) {
        this.gmail_Account_sell = gmail_Account_sell;
    }

    public String getGmail_Account_buy() {
        return gmail_Account_buy;
    }

    public void setGmail_Account_buy(String gmail_Account_buy) {
        this.gmail_Account_buy = gmail_Account_buy;
    }

    public String getOrderdate_order_produc() {
        return orderdate_order_produc;
    }

    public void setOrderdate_order_produc(String orderdate_order_produc) {
        this.orderdate_order_produc = orderdate_order_produc;
    }

    @Override
    public String toString() {
        return "Order_Product{" + "Id_order=" + Id_order + ", gmail_Account_sell=" + gmail_Account_sell + ", gmail_Account_buy=" + gmail_Account_buy + '}';
    }

}
