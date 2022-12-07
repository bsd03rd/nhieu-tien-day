package dal;


import java.sql.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vuman
 */
public class Validation {
    public boolean checkBirthDay(Date date1){
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        if(((date.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24 * 365)) >= 16){
            return true;
        }       
        return false;
    }
    
    public boolean checkPasswordFormat(String password){
        if(password.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[^\\w\\s]).{8,25}$")){
            return true;
        }
        return false;
    }
}
