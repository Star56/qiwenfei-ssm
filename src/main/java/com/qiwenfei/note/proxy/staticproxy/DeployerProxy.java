package com.qiwenfei.note.proxy.staticproxy;

/**
 * 2018-05-21
 * sunshine
 * 机票代理公司，获取到委托对象属性，订购机票
 * 机票订购完成后通知委托对象进行相应动作：出差
 */
public class DeployerProxy implements Deployer {

    private Deployer deployer ;

    public DeployerProxy(Deployer deployer) {
        this.deployer = deployer;
    }

    public  void orderAirTrip(){
        System.out.println("机票订购完成");
    }

    @Override
    public void book() {

    }

    @Override
    public void trip() {
        this.orderAirTrip();
        deployer.trip();
    }

    public static void main(String[] args) {

        DeployerProxy  deployerProxy = new DeployerProxy(new PMDeployer());
        deployerProxy.trip();

    }
}
