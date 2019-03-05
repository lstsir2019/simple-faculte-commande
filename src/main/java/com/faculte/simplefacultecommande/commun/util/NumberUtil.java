/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultecommande.commun.util;

/**
 *
 * @author mohcine
 */
public class NumberUtil {
    private static final String CHAINE_VIDE="";
    public static double toDecimal(String value){
        if (value==null ||value.isEmpty()) {
            return 0D;
        }else{
            return  Double.parseDouble(value);
        }
    }
    
    public static int toInt(String value){
        if (value==null ||value.isEmpty()) {
            return 0;
        }else{
            return  Integer.parseInt(value);
        }
    }
    public static String toString(Double value){
        if (value==null) {
            return CHAINE_VIDE;
        }else{
            return String.valueOf(value);
        }
    }
    public static String intToString(Integer value){
        if (value==null) {
            return CHAINE_VIDE;
        }else{
            return String.valueOf(value);
        }
    }
}
