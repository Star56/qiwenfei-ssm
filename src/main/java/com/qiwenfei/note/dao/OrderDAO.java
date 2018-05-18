package com.qiwenfei.note.dao;

import com.qiwenfei.note.entity.OrderInfo;

/**
 * 2018-05-14
 * sunshine
 */
public class OrderDAO {

    public static void main(String[] args) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setId(1L);
        orderInfo.setName("笔记本");

        System.out.println(orderInfo.getName());

    }
}
