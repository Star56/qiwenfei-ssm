package com.qiwenfei.note.concurrency;

/**
 * 2018/11/9
 * sunshine
 */
public class Request {
    private String name ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                '}';
    }
}
