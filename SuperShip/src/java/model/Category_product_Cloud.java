/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 
 */
public class Category_product_Cloud {

    String id_categories;
    String CategoryName;
    String Description;

    public Category_product_Cloud(String id_categories, String CategoryName, String Description) {
        this.id_categories = id_categories;
        this.CategoryName = CategoryName;
        this.Description = Description;
    }

    public Category_product_Cloud() {
    }

    public String getId_categories() {
        return id_categories;
    }

    public void setId_categories(String id_categories) {
        this.id_categories = id_categories;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    @Override
    public String toString() {
        return "Category_product_Cloud{" + "id_categories=" + id_categories + ", CategoryName=" + CategoryName + ", Description=" + Description + '}';
    }
    
}
