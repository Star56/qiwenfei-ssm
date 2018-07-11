package com.qiwenfei.note.observer.publisher;

import com.qiwenfei.note.observer.publisher.event.Event;
import com.qiwenfei.note.observer.publisher.event.PubType;

import java.lang.reflect.Method;

/**
 * 2018/7/10
 * sunshine
 *
 * 观察者模式：
 *  定义对象见一对一的依赖关系；一种对象被更新时，依赖于他的对象被通知到，并自动更新；
 * 将回调方法与执行方法建立对应关系，并解耦：
 * zookeeper的watcher,Listener;MQ的消息生产与消费模式
 */
public class PublisherTest {

    public static void main(String[] args) {

        Publisher publisher = new Publisher();
        PublishCallback publishCallback = new PublishCallback();

        try {
            Method  method = PublishCallback.class.getMethod("add",Event.class);
            Method  method2 = PublishCallback.class.getMethod("del",Event.class);

            publisher.addListener(PubType.ON_ADD,publishCallback,method);
            publisher.addListener(PubType.ON_DEL,publishCallback,method2);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        publisher.login();
        publisher.loginout();


    }
}
