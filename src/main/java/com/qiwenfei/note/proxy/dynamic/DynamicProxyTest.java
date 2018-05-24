package com.qiwenfei.note.proxy.dynamic;

import com.qiwenfei.note.proxy.staticproxy.Deployer;
import com.qiwenfei.note.proxy.staticproxy.PMDeployer;
import sun.misc.ProxyGenerator;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * 2018-05-21
 * sunshine
 */
public class DynamicProxyTest {

    public static void main(String[] args) {

     DynamicProxy dynamicProxy = new DynamicProxy();

     Deployer deployer = (Deployer) dynamicProxy.newInstanceProxy(new PMDeployer());

        System.out.println(deployer.getClass());

        deployer.book();
        deployer.trip();

        //原理：字节码重组
        //(1)拿到被代理对象的引用，反射获取到它的所有接口
        //(2)JDK Proxy 类重新生成一个类，并实现被代理对象的所有方法；
        //(3)动态生成java文件，并按照一定的逻辑调用；
        //(4)编译java文件生成class文件
        //(5)将class文件重新加载到jvm

        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Deployer.class});
        try {
            FileOutputStream fos = new FileOutputStream("C:\\Users\\sunshine\\IdeaProjects\\qiwenfei-ssm\\src\\main\\java\\com\\qiwenfei\\note\\proxy\\dynamic\\Proxy0.class");
            fos.write(bytes);
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
