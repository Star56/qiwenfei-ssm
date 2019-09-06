package com.qiwenfei.note;

import java.util.Scanner;

/**
 * 2019/7/20
 * sunshine
 * 写出一个程序，输入一个字符串，然后输出大写转换为小写之后的字符串。不在字母范围内的字符，需丢弃
 *例如：  输入Abc  输出abc
 */
public class Main {
    public static void main(String[] args) {
        Scanner  scanner  = new Scanner(System.in);
        while(scanner.hasNext()){
            String line = scanner.next();
            StringBuffer  sb = new StringBuffer();
            for(int i = 0 ;i<line.length();i++){
                if(line.charAt(i)>='A' && line.charAt(i)<='Z'){
                    sb.append((char)(line.charAt(i)+32));
                }
                if(line.charAt(i)>='a' && line.charAt(i)<='z'){
                    sb.append(line.charAt(i));
                }
            }
            System.out.println(sb.toString());
        }
    }
}
