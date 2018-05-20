package com.qiwenfei.note.prototype;

import java.io.Serializable;

/**
 * 2018-05-20
 * sunshine
 */
public class Sex implements Serializable {
    private  String sex  ;
    public Sex(String sex) {
        this.sex =sex;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
