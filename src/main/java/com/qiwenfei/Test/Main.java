package com.qiwenfei.Test;

import java.util.*;

/**
 * 2019/7/21
 * sunshine
 */
public class Main {
    public static void main(String[] args) {
        Scanner  scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();

        int m = Integer.parseInt(s1.split(" ")[0]);
        int n =  Integer.parseInt(s1.split(" ")[1]);

        List<Integer> list = new ArrayList<>();
        for (String str:s2.split(" ")
             ) {
            list.add(Integer.parseInt(str));
        }

        Collections.sort(list);

        List<Integer> sum = new ArrayList<>();
        int num = n/m ;

        int min = n>m?m:n ;

        for (int i = 0; i < min; i++) {
            int t = list.get(i) ;
            for (int j = 1; j <= num && (i+j*m<list.size()); j++) {
                t+= list.get(i+j*m);
            }
            sum.add(t);
        }
        Collections.sort(sum);

        System.out.println(sum.get(sum.size()-1));



    }
}
