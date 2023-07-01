package com.mahmutcelik.withSpringDataJPA;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Course {
    @Id
    private long id;
    private String aname;
    private String author;

    public Course() {
    }

    public Course(long id, String aname, String author) {
        this.id = id;
        this.aname = aname;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", aname='" + aname + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
