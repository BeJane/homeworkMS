package org.example.model;

import java.util.Date;

/**
 * Student
 * @author:Jingqi Wu
 * @date: 2020/3/9
 */
public class Student {
    private long id;
    private String name;

    private Date createTime;
    private Date updateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return (Date) createTime.clone();
    }

    public void setCreateTime(Date create_time) {

        this.createTime = (Date)create_time.clone();
    }

    public Date getUpdateTime() {
        return (Date)updateTime.clone();
    }

    public void setUpdateTime(Date update_time) {

        this.updateTime = (Date) update_time.clone();
    }

/*
    public void printThrowException(){
        System.out.println("Exception raised");
        throw new IllegalArgumentException();
    }

 */
}
