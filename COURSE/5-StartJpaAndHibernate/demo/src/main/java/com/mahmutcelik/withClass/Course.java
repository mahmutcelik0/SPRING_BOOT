package com.mahmutcelik.withClass;

public class Course {
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

    public void setId(long id) {
        this.id = id;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public String getAname() {
        return aname;
    }

    public String getAuthor() {
        return author;
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
