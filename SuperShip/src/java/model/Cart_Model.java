/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author BachDuc
 */
public class Cart_Model {
    Product_Cloud pd ;
    int amoun;

    public Cart_Model() {
    }

    public Cart_Model(Product_Cloud pd, int amoun) {
        this.pd = pd;
        this.amoun = amoun;
    }

    public Product_Cloud getPd() {
        return pd;
    }

    public void setPd(Product_Cloud pd) {
        this.pd = pd;
    }

    public int getAmoun() {
        return amoun;
    }

    public void setAmoun(int amoun) {
        this.amoun = amoun;
    }

    @Override
    public String toString() {
        return "Cart{" + "pd=" + pd + ", amoun=" + amoun + '}';
    }
    
    
}
