package com.qiwenfei.note;

import java.util.Scanner;

/**
 * 2019/7/21
 * sunshine
 */
public class Test6 {

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
         String str1 =  scanner.next();
         String str2 =  scanner.next();

        System.out.println(getResult(str1));
        System.out.println(getResult(str2));
    }

    public static String getResult(String str){

        StringBuffer strbuff = new StringBuffer(str);
        StringBuffer sb = new StringBuffer();
        if(str.length()>7){//大于8
            while(strbuff.length()>7){
                sb.append(strbuff.substring(0,8));
                strbuff = new StringBuffer(strbuff.substring(8));
            }
        }else{
            sb = new StringBuffer(str);
            while(sb.length()<8){
                sb = sb.append("0");
            }
        }

        return sb.toString() ;

    }
}
