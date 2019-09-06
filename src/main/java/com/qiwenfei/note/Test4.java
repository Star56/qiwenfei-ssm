package com.qiwenfei.note;

import java.util.Scanner;

/**
 * 2019/7/21
 * sunshine
 */
public class Test4 {

    public static void main(String[] args) {
        Scanner  scanner  = new Scanner(System.in);
        while(scanner.hasNext()){
            String  str = scanner.next();
            int maxlength = 0;
            String maxstr = "";
            int conmaxlength = 0 ;
            StringBuffer conmaxstr = new StringBuffer();
            conmaxstr.append(str.charAt(0));

            for (int i = 1; i < str.length(); i++) {
                conmaxstr.append(str.charAt(i));//后面的与前面比较，先加入再比较
                if(str.charAt(i)==str.charAt(i-1)){
                    conmaxlength++ ;
                    if(conmaxlength>maxlength){
                        maxlength = conmaxlength ;
                        maxstr  = conmaxstr.toString() ;
                    }else if(conmaxlength==maxlength){
                        maxlength = conmaxlength ;
                        if(conmaxstr.charAt(0)<maxstr.charAt(0)){
                            maxstr = conmaxstr.toString() ;
                        }
                    }
                }else{
                    conmaxlength = 0;
                    conmaxstr.setLength(0);
                }
            }
            System.out.println(maxstr.toString());
        }
    }
}
