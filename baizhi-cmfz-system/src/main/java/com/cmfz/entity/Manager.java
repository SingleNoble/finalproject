package com.cmfz.entity;

import java.io.Serializable;

/**
 * 表f_manager对应的实体类
 */
public class Manager implements Serializable {
    private String id;
    private String name;
    private String password;
    private String phone;
    private String salt;

    public Manager() {
    }

    public Manager(String id, String name, String password, String phone, String salt) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.salt = salt;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }
}
