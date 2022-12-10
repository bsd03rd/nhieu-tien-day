/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import java.util.Random;

/**
 *
 * @author BachDuc
 */
public class RandomString {

    public static String RandomString() {
        String randomString = "";
        Random random = new Random();
        while (randomString.length() != 5) {
            char randomizedCharacter = (char) (random.nextInt(26) + 'a');
            randomString += randomizedCharacter;
        }
        return randomString;
    }

    public static String RandomString(int num) {
        String randomString = "";
        Random random = new Random();
        while (randomString.length() != num) {
            char randomizedCharacter = (char) (random.nextInt(26) + 'a');
            randomString += randomizedCharacter;
        }
        return randomString;
    }

    public static String RandomStringS(int num) {
        String alphabet = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
        int N = alphabet.length();
        Random rd = new Random();
        int iLength = num;
        StringBuilder sb = new StringBuilder(iLength);
        for (int i = 0; i < iLength; i++) {
            sb.append(alphabet.charAt(rd.nextInt(N)));
        }
        return String.valueOf(sb);
    }
    public static String RandomStringN(int num) {
        String alphabet = "1234567890";
        int N = alphabet.length();
        Random rd = new Random();
        int iLength = num;
        StringBuilder sb = new StringBuilder(iLength);
        for (int i = 0; i < iLength; i++) {
            sb.append(alphabet.charAt(rd.nextInt(N)));
        }
        return String.valueOf(sb);
    }
    public static void main(String[] args) {
        System.out.println(new RandomString().RandomStringN(3));
    }
}
