package com.qiwenfei.note.concurrency;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 2018/11/12
 * sunshine
 *
 * 通过责任链模式实现的异步处理器
 * 通过阻塞队列LinkedBlockingQueue将请求按照队列处理
 * 先运行了打印处理线程、保存处理线程、两个子线程，扫描LinkedBlockingQueue
 * print线程执行时才会将请求放到阻塞队列中，save线程才会扫描到请求，保证了打印与保存的执行顺序
 */
public class ProcessorTest {

    PrintProcessor  printProcessor ;

    public ProcessorTest(){
          SaveProcessor  saveProcessor = new SaveProcessor();
          saveProcessor.start();
          printProcessor = new PrintProcessor(saveProcessor);
          printProcessor.start();

    }

    public void doProcess(Request request){
         printProcessor.processRequest(request);
    }

    public static void main(String[] args) throws Exception{

        ProcessorTest  processorTest = new ProcessorTest();
        //将对象放在循环外面，阻塞队列中放置的实际上是对象的引用
        //可能在最后的赋值request.set("9")时，子程序才获得CPU片；才扫描到阻塞队列的值，
        //此时，阻塞队列中所有的request都指向9
        //如果需要按顺序输出：则可以将对象的生成放在循环中，每次产生的对象都是不一样的，
        //每个对象的修改互不影响

        for (int i = 0; i < 100; i++) {
            Request  request = new Request() ;
            request.setName(i+"");
            processorTest.doProcess(request);
        }
    }
}
