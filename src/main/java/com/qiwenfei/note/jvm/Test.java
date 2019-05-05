package com.qiwenfei.note.jvm;

/**
 * 2019/3/6
 * sunshine
 */
public class Test {

    static abstract class Human {
    }
    // 继承自抽象类Human
    static class Man extends Human {
    }
    static class Woman extends Human {
    }
    // 可供重载的方法
    public void sayHello(Human guy) {
        System.out.println("hello,guy!");
    }
    public void sayHello(Man guy) {
        System.out.println("hello gentleman!");
    }
    public void sayHello(Woman guy) {
        System.out.println("hello lady!");
    }
    // 测试代码
    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        Test test = new Test();
        test.sayHello(man);
        test.sayHello(woman);
    }
}
