package com.qiwenfei.note.observer.publisher.event;

import java.lang.reflect.Method;

/**
 * 2018/7/10
 * sunshine
 */
public class Event {

    /** 事件源 **/
    private Object  source ;
    /** 事件目标**/
    private Object  target ;
    /** 回调方法**/
    private Method callback ;

    public Event(Object source, Object target) {
        this.source = source;
        this.target = target;
    }

    public Event(Object target, Method callback) {
        this.target = target;
        this.callback = callback;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Method getCallback() {
        return callback;
    }

    public void setCallback(Method callback) {
        this.callback = callback;
    }
}
