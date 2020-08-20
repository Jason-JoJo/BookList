package com.jason.demo.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Component  //組成;最普通的組件，可以被注入到spring容器進行管理
//@ConfigurationProperties(prefix = "book")   //可以從.jml,.property裡注入屬性 前綴book的

@Entity
public class Book {
    @Id //主鍵
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String author;
    private int status;
    private String description;

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
//        switch (status){
//            case 0:
//                return "未讀";
//            case 1:
//                return "已讀";
//            case 2:
//                return "喜歡";
//            default:
//                return ""+status;
//        }
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public Book(){

    }
}
