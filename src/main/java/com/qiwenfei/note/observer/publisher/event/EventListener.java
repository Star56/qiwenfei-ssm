package com.qiwenfei.note.observer.publisher.event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 2018/7/10
 * sunshine
 */
public class EventListener {

    private Map<Enum,Event> eventMap = new HashMap<Enum,Event>();

    public void addListener(Enum anEnum, Object target, Method method){
        eventMap.put(anEnum,new Event(target,method));
    }

    protected void  trigger(Enum anEnum){
         if(!eventMap.containsKey(anEnum)){
             return ;
         }
        this.trigger(eventMap.get(anEnum));
    }
    private void trigger(Event e){
        e.setSource(this);
        try {
            e.getCallback().invoke(e.getTarget(),e);
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        } catch (InvocationTargetException e1) {
            e1.printStackTrace();
        }
    }

}
