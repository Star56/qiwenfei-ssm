package com.qiwenfei.note.proxy.staticproxy;

/**
 * 2018-05-21
 * sunshine
 * PM只需要专注于出差，机票的订购交给代理来办理
 */
public class PMDeployer implements Deployer {

    @Override
    public void trip() {
        System.out.println("机票到手，开始出差......");
    }

    @Override
    public void book() {
        System.out.println("文件准备好了");
    }
}
