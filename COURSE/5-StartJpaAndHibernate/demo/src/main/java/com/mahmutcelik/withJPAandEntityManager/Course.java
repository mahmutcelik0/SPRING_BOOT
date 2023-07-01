package com.mahmutcelik.withJPAandEntityManager;



//WE MUST MAP BEAN TO TABLE IN JPA and ENTITYMANAGER

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity //Map table name
public class Course {
    @Id
    private long id;
    @Column(name = "NAME") // if there is matching part -> not necessary
    private String name;

    @Column(name = "AUTHOR")
    private String author;

    public Course() {
    }

    public Course(long id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

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
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
