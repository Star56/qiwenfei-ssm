package com.qiwenfei.note;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * 2019/7/19
 * sunshine
 */
public class Less3 {

        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            while (sc.hasNext()){
                char[] chs =  sc.next().toCharArray();
                StringBuffer sb = new StringBuffer(256);
                Set set = new HashSet();
                for (char ch:chs
                        ) {
                    if(set.add(ch)){
                        sb.append(ch);
                    }

                }
                System.out.println(sb.toString());
            }
        }
    }

