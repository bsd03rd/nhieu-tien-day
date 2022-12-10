package core;
import core.RandomString;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author BachDuc
 */
public class SHA_256 {
    public static String MySHA256(String PassWord) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] cryptPass = md.digest(PassWord.getBytes());
//        System.out.println(Arrays.toString(cryptPass));
        String SHA256 = "";
        for (int i = 0; i < cryptPass.length; i++) {
            String myhex = Integer.toHexString(cryptPass[i]);
            String crhex[] = myhex.split("");
            if (crhex.length ==1) {
                crhex[0]="0"+crhex[0];
                String formathex = crhex[0];
                SHA256 += formathex;
            } else {
                String formathex = crhex[crhex.length - 2] + crhex[crhex.length - 1];
                SHA256 += formathex;
            }
        }
//        System.out.println(SHA256);
        return SHA256;
    }
    
    public static String SAMPLEsha256ver1(final String base) {
    try{
        final MessageDigest digest = MessageDigest.getInstance("SHA-256");
        final byte[] hash = digest.digest(base.getBytes("UTF-8"));
        final StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < hash.length; i++) {
            final String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) 
              hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    } catch(Exception ex){
       throw new RuntimeException(ex);
    }
}
    public static String SAMPLEsha256ver2(final String base) throws NoSuchAlgorithmException
    {
        //https://www.geeksforgeeks.org/sha-256-hash-in-java/
        MessageDigest md = MessageDigest.getInstance("SHA-256"); 
        byte[] hash= md.digest(base.getBytes(StandardCharsets.UTF_8));
        BigInteger number = new BigInteger(1, hash); 
        StringBuilder hexString = new StringBuilder(number.toString(16)); 
        while (hexString.length() < 32) 
        { 
            hexString.insert(0, '0'); 
        } 
        return hexString.toString(); 
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 1000; i++) {
           String random = new RandomString().RandomString();
//            System.out.println(MySHA256(random));
//            System.out.println(EncryptSHA256(random));
            if (MySHA256(random).equals(SAMPLEsha256ver1(random))) {
                System.out.println("True");
                continue;
            } else {
                System.out.println("False");System.out.println(random);
                break;
            }
        }
//                
//        
//        String str = "hello";
//        MessageDigest msg = MessageDigest.getInstance("SHA-256");
//        byte[] hash = msg.digest(str.getBytes(StandardCharsets.UTF_8));
//        // convert bytes to hexadecimal
//        StringBuilder s = new StringBuilder();
//        System.out.println(Arrays.toString(hash));
//        for (byte b : hash) {
//            s.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
//            System.out.println(s);
//        }
//        System.out.println(s.toString());
//        System.out.println(EncryptSHA256("hello"));



        // ANALAIZE
//        System.out.println(Arrays.toString("dibqb".getBytes()));
//        int intenum = 98;
//        System.out.println("Correct crypt:");
//        String hex = Integer.toHexString((intenum & 0xff) + 0x100).substring(1);
//        System.out.println(hex);
//        System.out.println("Demo crypt:");
//        String hex2 = Integer.toHexString((intenum & 0xff) + 0x100);
//        System.out.println(hex2);
//        System.out.println("Demo crypt:");
//        String hex1 = Integer.toHexString((intenum));
//        System.out.println(hex1);
//         System.out.println("My crypt:");
//        String myhex = Integer.toHexString(intenum);
//        String crhex[] = myhex.split("");
//        if (crhex.length < 2) {
//            String formathex = "0" + crhex[crhex.length - 1];
//            System.out.println(formathex);
//        } else {
//            String formathex = crhex[crhex.length - 2] + crhex[crhex.length - 1];
//            System.out.println(formathex);
//        }
    }

}
