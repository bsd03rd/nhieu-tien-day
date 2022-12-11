package core;


import java.util.Scanner;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 
 */
public class Inpputer {
    public static boolean InputRegex(String content,String regex){
            if(content.matches(regex)){
                return true ;
            }else{
                return false;
            }
    }
    public static String InputString(String mess){
        System.out.println(mess);
        Scanner sc= new Scanner(System.in);
        return sc.nextLine();
    }
    public static void main(String[] args) {
        System.out.println(new Inpputer().InputRegex("123456789", "^[0-9]{9,10}$"));
    }
}
