package com.qiwenfei.note;

import java.util.Scanner;

/**
 * 2019/7/21
 * sunshine
 */
public class Test5 {

    public static void main(String[] args) {
        Scanner  scanner  = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.next();
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

            System.out.println(sb.toString());

        }

    }
}
