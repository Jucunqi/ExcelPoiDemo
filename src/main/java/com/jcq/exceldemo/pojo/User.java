package com.jcq.exceldemo.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class User {
    @Excel(name = "编号",width = 20,orderNum = "0")
    private Integer id;
    @Excel(name = "姓名" ,width = 20,orderNum = "1")
    private String name;
    @Excel(name = "性别",width = 20,orderNum = "2")
    private String sex;
    @Excel(name = "地址",width = 20,orderNum = "3")
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
