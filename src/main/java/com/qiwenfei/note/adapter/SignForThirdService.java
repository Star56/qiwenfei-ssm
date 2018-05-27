package com.qiwenfei.note.adapter;

/**
 * 2018-05-27
 * sunshine
 *
 * 适配器模式就是转换器
 * 作用是使之前的方法向下兼容
 *
 */
public class SignForThirdService extends SiginService{

  public  void   LoginForQQ(){
      //(1)qqnum是唯一的的，可以当做一个用户名
      //(2)密码默认
      //(3)调用系统之前的注册方法，生成注册用户信息
      //(4)调用之前的登录方法，登录
     String qqnum  = LoginByQQAdapter.getNum();

     super.sign(qqnum,"123");
     super.login(qqnum,"123");


  }
  public  void LoginForWechart(){

  }

}
