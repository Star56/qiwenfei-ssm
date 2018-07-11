package com.qiwenfei.note.observer.publisher;

import com.qiwenfei.note.observer.publisher.event.Event;
import com.qiwenfei.note.observer.publisher.event.EventListener;
import com.qiwenfei.note.observer.publisher.event.PubType;

/**
 * 2018/7/10
 * sunshine
 */
public class Publisher extends EventListener {

    public void login(){
        System.out.println("登录了,发送通知事件");
        this.trigger(PubType.ON_ADD);
    }
    public void loginout(){
        System.out.println("退出登录，发送通知事件");
        this.trigger(PubType.ON_DEL);
    }
}
