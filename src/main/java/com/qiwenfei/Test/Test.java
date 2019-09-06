package com.qiwenfei.Test;

/**
 * 2019/7/23
 * sunshine
 */
public class Test {

    public int binarySearch(int []arry,int num){
        int low = 0 ;
        int upper = arry.length-1 ;

        while (low<=upper){
            int mid = (low+upper)/2 ;

            if(arry[mid]<num){
                low = mid +1 ;
            }else if(arry[mid]>num){
                upper = mid -1;
            }else{
                return mid ;
            }

        }
       return -1 ;
    }

}
