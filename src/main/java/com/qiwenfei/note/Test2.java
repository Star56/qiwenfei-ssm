package com.qiwenfei.note;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 2019/7/20
 * sunshine
 * 100个人围成一圈，每个人有一个编码，编号从1开始到100。他们从1开始依次报数，报到为M的人自动退出圈圈，
 * 然后下一个人接着从1开始报数，直到剩余的人数小于M。请问最后剩余的人在原先的编号为多少？
 * 例如输入M=3时，输出为： “58,91” ，
 * 输入M=4时，输出为： “34,45,97”。

 */
public class Test2 {

    public static void main(String[] args) {

        Scanner  scanner  = new Scanner(System.in);
        while(scanner.hasNext()){
            int M = scanner.nextInt();
            List  list = new ArrayList(100);
            for (int i = 1; i < 101; i++) {
                list.add(i);
            }
            int i = 0;
            while(list.size()>=M){
                i = (i+M-1)%list.size();
                list.remove(i);
            }

            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < list.size();j++) {
                sb.append(list.get(j)).append(",");
            }
            System.out.println(sb.toString().substring(0,sb.length()-1));
        }



    }
}
