package com.qiwenfei.note;

import java.util.*;

/**
 * 2019/7/19
 * sunshine
 */
public class Less {

    //测试数据有多组

        public static void main(String[] args){
            int N=0;
            Set<Integer> set=new TreeSet<Integer>();
            //set没有排序的方法，
            //可以Set set = new TreeSet()
            //TreeSet存储的时候已经是排好序的
            Scanner scanner=new Scanner(System.in);
            while(scanner.hasNext()){
                N=scanner.nextInt();
                set.clear();
                for(int i=0;i<N;i++){
                    set.add(scanner.nextInt());
                }
                Iterator<Integer> it=set.iterator();
                while(it.hasNext()){
                    System.out.println(it.next());
                }
            }
        }

}
