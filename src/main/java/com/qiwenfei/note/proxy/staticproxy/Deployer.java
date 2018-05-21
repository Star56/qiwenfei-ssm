package com.qiwenfei.note.proxy.staticproxy;

/**
 * 2018-05-21
 * sunshine
 */
public interface Deployer {

    /**
     * 准备出差文件
     */
    public void  book();

    /**
     * 出差之前我需要订票，订票我希望有代理公司去做
     */
    public void  trip();
}
