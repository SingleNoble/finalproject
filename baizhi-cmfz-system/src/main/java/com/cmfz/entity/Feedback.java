package com.cmfz.entity;

import java.io.Serializable;

/**
 * 表f_feedback对应的实体类
 */
public class Feedback implements Serializable {
    private String id;
    private String content;

    public Feedback() {
    }

    public Feedback(String id, String content) {
        this.id = id;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
