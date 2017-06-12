package com.cmfz.entity;

import java.io.Serializable;

/**
 * 表f_chapter对应的实体类
 */
public class Chapter implements Serializable{
    private String id;
    private String oldname;
    private String newname;
    private String filepath;
    private String filesize;
    private String contenttype;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOldname() {
        return oldname;
    }

    public void setOldname(String oldname) {
        this.oldname = oldname;
    }

    public String getNewname() {
        return newname;
    }

    public void setNewname(String newname) {
        this.newname = newname;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getFilesize() {
        return filesize;
    }

    public void setFilesize(String filesize) {
        this.filesize = filesize;
    }

    public String getContenttype() {
        return contenttype;
    }

    public void setContenttype(String contenttype) {
        this.contenttype = contenttype;
    }

    public Chapter(String id, String oldname, String newname, String filepath, String filesize, String contenttype) {
        this.id = id;
        this.oldname = oldname;
        this.newname = newname;
        this.filepath = filepath;
        this.filesize = filesize;
        this.contenttype = contenttype;
    }

    public Chapter() {
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id='" + id + '\'' +
                ", oldname='" + oldname + '\'' +
                ", newname='" + newname + '\'' +
                ", filepath='" + filepath + '\'' +
                ", filesize='" + filesize + '\'' +
                ", contenttype='" + contenttype + '\'' +
                '}';
    }
}
