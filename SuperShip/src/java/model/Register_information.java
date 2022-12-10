/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author BachDuc
 */
public class Register_information {
        String Fname_register;
        String Lname_register;
        String Adress_register;
        String gender_register;
        String city_register;
        String district_register;
        String shopdomain_register;
        String PhoneNumber_register;
        String email_register;
        String password_register;

    public Register_information() {
    }

    public Register_information(String Fname_register, String Lname_register, String Adress_register, String gender_register, String city_register, String district_register, String shopdomain_register, String PhoneNumber_register, String email_register, String password_register) {
        this.Fname_register = Fname_register;
        this.Lname_register = Lname_register;
        this.Adress_register = Adress_register;
        this.gender_register = gender_register;
        this.city_register = city_register;
        this.district_register = district_register;
        this.shopdomain_register = shopdomain_register;
        this.PhoneNumber_register = PhoneNumber_register;
        this.email_register = email_register;
        this.password_register = password_register;
    }

    public String getFname_register() {
        return Fname_register;
    }

    public void setFname_register(String Fname_register) {
        this.Fname_register = Fname_register;
    }

    public String getLname_register() {
        return Lname_register;
    }

    public void setLname_register(String Lname_register) {
        this.Lname_register = Lname_register;
    }

    public String getAdress_register() {
        return Adress_register;
    }

    public void setAdress_register(String Adress_register) {
        this.Adress_register = Adress_register;
    }

    public String getGender_register() {
        return gender_register;
    }

    public void setGender_register(String gender_register) {
        this.gender_register = gender_register;
    }

    public String getCity_register() {
        return city_register;
    }

    public void setCity_register(String city_register) {
        this.city_register = city_register;
    }

    public String getDistrict_register() {
        return district_register;
    }

    public void setDistrict_register(String district_register) {
        this.district_register = district_register;
    }

    public String getShopdomain_register() {
        return shopdomain_register;
    }

    public void setShopdomain_register(String shopdomain_register) {
        this.shopdomain_register = shopdomain_register;
    }

    public String getPhoneNumber_register() {
        return PhoneNumber_register;
    }

    public void setPhoneNumber_register(String PhoneNumber_register) {
        this.PhoneNumber_register = PhoneNumber_register;
    }

    public String getEmail_register() {
        return email_register;
    }

    public void setEmail_register(String email_register) {
        this.email_register = email_register;
    }

    public String getPassword_register() {
        return password_register;
    }

    public void setPassword_register(String password_register) {
        this.password_register = password_register;
    }

    @Override
    public String toString() {
        return "Register_information{" + "Fname_register=" + Fname_register + ", Lname_register=" + Lname_register + ", Adress_register=" + Adress_register + ", gender_register=" + gender_register + ", city_register=" + city_register + ", district_register=" + district_register + ", shopdomain_register=" + shopdomain_register + ", PhoneNumber_register=" + PhoneNumber_register + ", email_register=" + email_register + ", password_register=" + password_register + '}';
    }
        
}
