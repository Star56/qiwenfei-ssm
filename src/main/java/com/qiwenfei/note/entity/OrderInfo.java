package com.qiwenfei.note.entity;

/**
 * 2018-05-14
 * sunshine
 */
public class OrderInfo  {

    private Long id ;

    private String name ;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
