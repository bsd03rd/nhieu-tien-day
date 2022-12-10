/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author BachDuc
 */
public class Product_Cloud {

    String id_product;
    String id_categories;
    String gmail_Account;
    String name_product;
    String value_product_unit;
    String value_product_perunit;
    String amount_product;
    String create_date_product;
    byte[] img;
    String description;

    public Product_Cloud() {
    }

    public Product_Cloud(String id_product, String id_categories, String gmail_Account, String name_product, String value_product_unit, String value_product_perunit, String amount_product, String create_date_product) {
        this.id_product = id_product;
        this.id_categories = id_categories;
        this.gmail_Account = gmail_Account;
        this.name_product = name_product;
        this.value_product_unit = value_product_unit;
        this.value_product_perunit = value_product_perunit;
        this.amount_product = amount_product;
        this.create_date_product = create_date_product;
    }

    public Product_Cloud(String id_product, String id_categories, String gmail_Account, String name_product, String value_product_unit, String value_product_perunit, String amount_product, String create_date_product, byte[] img) {
        this.id_product = id_product;
        this.id_categories = id_categories;
        this.gmail_Account = gmail_Account;
        this.name_product = name_product;
        this.value_product_unit = value_product_unit;
        this.value_product_perunit = value_product_perunit;
        this.amount_product = amount_product;
        this.create_date_product = create_date_product;
        this.img = img;
    }

    public Product_Cloud(String id_product, String id_categories, String gmail_Account, String name_product, String value_product_unit, String value_product_perunit, String amount_product, String create_date_product, byte[] img, String description) {
        this.id_product = id_product;
        this.id_categories = id_categories;
        this.gmail_Account = gmail_Account;
        this.name_product = name_product;
        this.value_product_unit = value_product_unit;
        this.value_product_perunit = value_product_perunit;
        this.amount_product = amount_product;
        this.create_date_product = create_date_product;
        this.img = img;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }
    

    public String getId_product() {
        return id_product;
    }

    public void setId_product(String id_product) {
        this.id_product = id_product;
    }

    public String getId_categories() {
        return id_categories;
    }

    public void setId_categories(String id_categories) {
        this.id_categories = id_categories;
    }

    public String getGmail_Account() {
        return gmail_Account;
    }

    public void setGmail_Account(String gmail_Account) {
        this.gmail_Account = gmail_Account;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public String getValue_product_unit() {
        return value_product_unit;
    }

    public void setValue_product_unit(String value_product_unit) {
        this.value_product_unit = value_product_unit;
    }

    public String getValue_product_perunit() {
        return value_product_perunit;
    }

    public void setValue_product_perunit(String value_product_perunit) {
        this.value_product_perunit = value_product_perunit;
    }

    public String getAmount_product() {
        return amount_product;
    }

    public void setAmount_product(String amount_product) {
        this.amount_product = amount_product;
    }

    public String getCreate_date_product() {
        return create_date_product;
    }

    public void setCreate_date_product(String create_date_product) {
        this.create_date_product = create_date_product;
    }

    @Override
    public String toString() {
        return "Product_Cloud{" + "id_product=" + id_product + ", id_categories=" + id_categories + ", gmail_Account=" + gmail_Account + ", name_product=" + name_product + ", value_product_unit=" + value_product_unit + ", value_product_perunit=" + value_product_perunit + ", amount_product=" + amount_product + ", create_date_product=" + create_date_product + '}';
    }
    
}
