/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 
 */
public class Ship_info {
String id_Ship_info ;
String Id_order ;
String RequiredDate_Ship_info ;
String ShippedDate_Ship_info ;
String Shipfee_Ship_info;
String ShipAddress_Ship_info;
String ShipCity_Ship_info;
String ShipRegion_Ship_info;
String ShipPostalCode_Ship_info;
String Shipped_Ship_info;

    public Ship_info() {
    }

    public Ship_info(String id_Ship_info, String Id_order, String RequiredDate_Ship_info, String ShippedDate_Ship_info, String Shipfee_Ship_info, String ShipAddress_Ship_info, String ShipCity_Ship_info, String ShipRegion_Ship_info, String ShipPostalCode_Ship_info, String Shipped_Ship_info) {
        this.id_Ship_info = id_Ship_info;
        this.Id_order = Id_order;
        this.RequiredDate_Ship_info = RequiredDate_Ship_info;
        this.ShippedDate_Ship_info = ShippedDate_Ship_info;
        this.Shipfee_Ship_info = Shipfee_Ship_info;
        this.ShipAddress_Ship_info = ShipAddress_Ship_info;
        this.ShipCity_Ship_info = ShipCity_Ship_info;
        this.ShipRegion_Ship_info = ShipRegion_Ship_info;
        this.ShipPostalCode_Ship_info = ShipPostalCode_Ship_info;
        this.Shipped_Ship_info = Shipped_Ship_info;
    }

   
    public String getId_order() {
        return Id_order;
    }

    public void setId_order(String Id_order) {
        this.Id_order = Id_order;
    }

    public String getRequiredDate_Ship_info() {
        return RequiredDate_Ship_info;
    }

    public void setRequiredDate_Ship_info(String RequiredDate_Ship_info) {
        this.RequiredDate_Ship_info = RequiredDate_Ship_info;
    }

    public String getShipAddress_Ship_info() {
        return ShipAddress_Ship_info;
    }

    public void setShipAddress_Ship_info(String ShipAddress_Ship_info) {
        this.ShipAddress_Ship_info = ShipAddress_Ship_info;
    }

    public String getShipCity_Ship_info() {
        return ShipCity_Ship_info;
    }

    public void setShipCity_Ship_info(String ShipCity_Ship_info) {
        this.ShipCity_Ship_info = ShipCity_Ship_info;
    }

    public String getShipRegion_Ship_info() {
        return ShipRegion_Ship_info;
    }

    public void setShipRegion_Ship_info(String ShipRegion_Ship_info) {
        this.ShipRegion_Ship_info = ShipRegion_Ship_info;
    }

    public String getShipfee_Ship_info() {
        return Shipfee_Ship_info;
    }

    public void setShipfee_Ship_info(String Shipfee_Ship_info) {
        this.Shipfee_Ship_info = Shipfee_Ship_info;
    }

    public String getShipped_Ship_info() {
        return Shipped_Ship_info;
    }

    public void setShipped_Ship_info(String Shipped_Ship_info) {
        this.Shipped_Ship_info = Shipped_Ship_info;
    }

    public String getShippedDate_Ship_info() {
        return ShippedDate_Ship_info;
    }

    public void setShippedDate_Ship_info(String ShippedDate_Ship_info) {
        this.ShippedDate_Ship_info = ShippedDate_Ship_info;
    }

    public String getShipPostalCode_Ship_info() {
        return ShipPostalCode_Ship_info;
    }

    public void setShipPostalCode_Ship_info(String ShipPostalCode_Ship_info) {
        this.ShipPostalCode_Ship_info = ShipPostalCode_Ship_info;
    }

    @Override
    public String toString() {
        return "Ship_info{" + "Id_order=" + Id_order + ", RequiredDate_Ship_info=" + RequiredDate_Ship_info + ", ShipAddress_Ship_info=" + ShipAddress_Ship_info + ", ShipCity_Ship_info=" + ShipCity_Ship_info + ", ShipRegion_Ship_info=" + ShipRegion_Ship_info + ", Shipfee_Ship_info=" + Shipfee_Ship_info + ", Shipped_Ship_info=" + Shipped_Ship_info + ", ShippedDate_Ship_info=" + ShippedDate_Ship_info + ", ShipPostalCode_Ship_info=" + ShipPostalCode_Ship_info + '}';
    }


}
