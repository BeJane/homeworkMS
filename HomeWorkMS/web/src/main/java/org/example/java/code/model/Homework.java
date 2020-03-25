package org.example.java.code.model;

import java.util.Date;

/**
 * homework
 * @author:Jingqi Wu
 * @date: 2020/3/9
 */
public class Homework {
    private long id;
    private  String title;
    private String content;
    private Date createTime;
    private Date updateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return (Date)createTime.clone();
    }

    public void setCreateTime(Date createTime) {
        this.createTime = (Date)createTime.clone();
    }

    public Date getUpdateTime() {
        return (Date)updateTime.clone();
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = (Date)updateTime.clone();
    }
}
