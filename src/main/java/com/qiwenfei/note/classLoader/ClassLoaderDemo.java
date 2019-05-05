package com.qiwenfei.note.classLoader;

/**
 * 2019/2/24
 * sunshine
 *
 * 类加载，代码执行顺序如下
 */
public class ClassLoaderDemo {

/*    (1)准备阶段：
              loaderDemo=null; 1
              count1=0 ; 2
              count2=0; 3
    (2)初始化阶段：静态变量赋值
            new ClassLoaderDemo()调用构造器
         public ClassLoaderDemo() {
           count1++ ;// 4->count1 =1
           count2++ ;//5->count2 =1
         }
       count1 没有赋值;
       count2=0;6->    count2 =0*/
    private static ClassLoaderDemo  loaderDemo = new ClassLoaderDemo();//
    private static int count1;
    private static int count2 =0 ;

    public ClassLoaderDemo() {
        count1++ ;
        count2++ ;
    }

    public static ClassLoaderDemo getInstance(){
        return loaderDemo ;
    }

    public static void main(String[] args) {
        ClassLoaderDemo.getInstance();
        System.out.println("count1: "+count1);
        System.out.println("count2: "+count2);
    }

}
