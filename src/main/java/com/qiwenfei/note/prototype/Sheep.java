package com.qiwenfei.note.prototype;


import java.io.Serializable;

/**
 * 2018-05-20
 * sunshine
 */
public class Sheep implements Serializable {

    private  Double height ;

    private Double weight ;

    private Sex  sex ;

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}
