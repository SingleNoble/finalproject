package com.cmfz.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 表f_article对应的实体类
 */
public class Article implements Serializable{
    private String id;
    private String title;
    private Date createdate;
    private String type;
    private String href;

    public Article() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Article(String id, String title, Date createdate, String type, String href) {
        this.id = id;
        this.title = title;
        this.createdate = createdate;
        this.type = type;
        this.href = href;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", createdate=" + createdate +
                ", type='" + type + '\'' +
                ", href='" + href + '\'' +
                '}';
    }
}
