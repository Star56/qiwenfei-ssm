package com.qiwenfei.note;

import java.util.Scanner;

/**
 * 2019/7/20
 * sunshine
 *  * 集五福作为近年来大家喜闻乐见迎新春活动，集合爱国福、富强福、和谐福、友善福、敬业福即可分享超大红包 *
 *  题目：以0和1组成的长度为5的字符串代表每个人所得到的福卡，每一位代表一种福卡，1表示已经获得该福卡
 *  * 单类型福卡不超过1张，随机抽取一个小于10人团队，求该团队最多可以集齐多少套五福
 *  * * 例如：输入11001 输出0

 */
public class Main2 {
    public static void main(final String[] args) {
        final Scanner sc = new Scanner(System.in);
        int sum = 0;
        while (sc.hasNext()) {
            final String line = sc.nextLine();
            sum += Integer.valueOf(line);

        int min = 10;
        while (sum > 0) {
            final int tmp = sum % 10;
            min = tmp < min ? tmp : min;
            sum /= 10;
        }
        System.out.println(min);
    }
    }
}
