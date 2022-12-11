/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import model.Register_information;

/**
 *
 * @author 
 */
public class Generate_ID_Account {
    
    
    
    public static String Generate_ID_Account(Register_information re) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] cryptPass = md.digest(re.toString().getBytes());
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
        return SHA256;
    }
}
