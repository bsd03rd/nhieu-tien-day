/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

/**
 *
 * @author BachDuc
 */
public class RandomNumber {

    public RandomNumber() {
    }

//    public String RandNum(int Nnum) {
//        int min = 0;
//        int max = 10;
//        String num="";
//        for (int i = 0; i < Nnum; i++) {
//            num+= String.valueOf((int)(Math.random() * (max - min + 1) + min));
//        }
//        return num;
//    }
    public static String RandNum(int Nnum) {
        int min = 0;
        int max = 10;
        String num="";
        for (int i = 0; i < Nnum; i++) {
            num+= String.valueOf((int)(Math.random() * (max - min + 1) + min));
        }
        return num;
    }
}
