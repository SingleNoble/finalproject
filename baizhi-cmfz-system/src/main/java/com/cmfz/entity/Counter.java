package com.cmfz.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 表f_counter对应的实体类
 */
public class Counter implements Serializable {
    private String id;
    private String name;
    private Integer num;
    private Date createdate;

    public Counter() {
    }

    public Counter(String id, String name, Integer num, Date createdate) {
        this.id = id;
        this.name = name;
        this.num = num;
        this.createdate = createdate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", num=" + num +
                ", createdate=" + createdate +
                '}';
    }
}
