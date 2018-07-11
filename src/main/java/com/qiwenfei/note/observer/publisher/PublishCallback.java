package com.qiwenfei.note.observer.publisher;

import com.qiwenfei.note.observer.publisher.event.Event;

/**
 * 2018/7/10
 * sunshine
 */
public class PublishCallback {

    public void add(Event e){
        System.out.println("计数器加1 "+e);
    }
    public  void del(Event e){
        System.out.println("计数器减1 "+e);
    }
}
