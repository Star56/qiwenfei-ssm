package com.qiwenfei.note.proxy.dynamic;

import com.qiwenfei.note.proxy.staticproxy.Deployer;
import com.qiwenfei.note.proxy.staticproxy.PMDeployer;

/**
 * 2018-05-21
 * sunshine
 */
public class DynamicProxyTest {

    public static void main(String[] args) {

     DynamicProxy dynamicProxy = new DynamicProxy();

     Deployer deployer = (Deployer) dynamicProxy.newInstanceProxy(new PMDeployer());
     deployer.book();
     deployer.trip();
    }
}
