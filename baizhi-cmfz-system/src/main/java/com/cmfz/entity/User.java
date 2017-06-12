package com.cmfz.entity;

import java.io.Serializable;

/**
 * 表f_user对应的实体类
 */
public class User implements Serializable{
    private String id;
    private String realname;
    private String nickname;
    private String sex;
    private String description;
    private String password;
    private String salt;
    private String phone;
    private String imgpath;

    public User() {
    }

    public User(String id, String realname, String nickname, String sex, String description, String password, String salt, String phone, String imgpath) {
        this.id = id;
        this.realname = realname;
        this.nickname = nickname;
        this.sex = sex;
        this.description = description;
        this.password = password;
        this.salt = salt;
        this.phone = phone;
        this.imgpath = imgpath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", realname='" + realname + '\'' +
                ", nickname='" + nickname + '\'' +
                ", sex='" + sex + '\'' +
                ", description='" + description + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", phone='" + phone + '\'' +
                ", imgpath='" + imgpath + '\'' +
                '}';
    }
}
