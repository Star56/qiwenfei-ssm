package com.qiwenfei.note;

/**
 * 2019/7/20
 * sunshine
 */
public class Main3 {

    public static void main(String[] args) {
        Main3 test =new Main3();
        System.out.println(test.Continumax("abcd12345ss54321", null));
    }

    //设计思路：用一个字符变量表示最大的连续数字字符串
    // 在用另一个表示当前连续数字字符，
    // 当前连续数字字符的长度大于最大的连续数字字符串时就将其赋个最大的连续数字字符串
    public int Continumax(String intputStr,  StringBuffer outputStr){
        int maxlength=0; //统计最大连续数字字符川长度
        StringBuffer maxNumberStr = null;//统计最大连续数字字符串

        int nowlength=0;//当前连续数字字符串长度
        StringBuffer nowNumberStr = new StringBuffer();//当前连续数字字符串长度


        for(int i=0;i<intputStr.length();i++){
            if((intputStr.charAt(i))>=48 && (intputStr.charAt(i))<=57){//判断字符是否是数字
                nowNumberStr.append(intputStr.charAt(i));
                nowlength++;

                if(nowlength>=maxlength){
                    maxNumberStr = nowNumberStr;
                    maxlength = nowlength;
                }
            }else{        //当出现非数字字符的时候吧nowlength、nowNumberStr清空
                nowlength=0;
                nowNumberStr.setLength(0);
            }

        }

        System.out.println(maxNumberStr);
        return maxlength;
    }

}
