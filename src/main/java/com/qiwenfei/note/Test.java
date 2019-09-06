package com.qiwenfei.note;

import java.util.Scanner;

/**
 * 2019/7/20
 * sunshine
 * 请一个在字符串中找出连续最长的数字串，并把这个串的长度返回；如果存在长度相同的连续数字串，返回最后一个连续数字串；
 * 示例1
 *
 * 输入
 *
 * abcd12345ed125ss123058789
 *
 * 输出
 *
 * 123058789
 *
 * 9
 */
public class Test {

    public static void main(String[] args) {
        Scanner  scanner  = new Scanner(System.in);

        while (scanner.hasNext()){
            String inputstr = scanner.next();
            //最大数字连续长度
            int maxlength = 0;
            //最大连续数字
            StringBuffer maxstr = new StringBuffer();
            //当前连续长度
            int conmaxlength = 0 ;
           //当前连续数字
            StringBuffer  conmaxstr = new StringBuffer();

            for (int i = 0; i < inputstr.length(); i++) {
                if(inputstr.charAt(i)>='0' && inputstr.charAt(i)<='9'){
                    conmaxlength ++ ;
                    conmaxstr.append(inputstr.charAt(i));

                    if(conmaxlength>=maxlength){
                        maxlength = conmaxlength ;
                        maxstr = conmaxstr ;
                    }

                }else{
                    conmaxlength = 0;
                    conmaxstr.setLength(0);
                }

            }

            System.out.println(maxstr);
            System.out.println(maxlength);

        }


    }
}
