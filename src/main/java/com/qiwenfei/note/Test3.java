package com.qiwenfei.note;

import java.util.*;

/**
 * 2019/7/21
 * sunshine
 * 题目描述：找出输入字符串中的重复字符，再根据ASCII码把重复的字符从小到大排序。
 *
 * 例如：输入ABCABCdd，输出ABCd。
 */
public class Test3 {

    public static void main(String[] args) {
        Scanner  scanner = new Scanner(System.in);
        while(scanner.hasNext()){
             char[] chs = scanner.next().toCharArray();
            Set set = new HashSet();
            List  list = new ArrayList();
            for (char ch:chs
                 ) {
                if(!set.add(ch)){
                    list.add(ch);
                }
            }
            Collections.sort(list);
            for (int i=0;i<list.size();i++){
                System.out.print(list.get(i));
            }
        }

    }
}
