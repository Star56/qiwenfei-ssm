package com.qiwenfei.note.sort;

/**
 * 2019/5/23
 * sunshine
 */
public class QuickSort {

    public static int getMiddle(int []array,int start,int end){
        int flag = array[start];
        while (start<end){
            while(start<end&&array[end]>=flag){
                 end -- ;
            }
            array[start] = array[end];
            while (start<end&&array[start]<=flag){
                start++ ;
            }
            array[end] = array[start];

        }
        array[start] =flag ;
        return start ;
    }

    public static void sort(int[]array,int start,int end ){
        if(start<end){
            int middle = getMiddle(array,start,end);

            sort(array,start,middle-1);
            sort(array,middle+1,end);
        }
    }

    public static void main(String[] args) {
         int []array ={5,2,3,6,7,83,12,3,5,65};
          sort(array,0,array.length-1);
        for (int i = 0; i <array.length ; i++) {
            System.out.println(array[i]);
        }

    }

}
