package com.mahmutcelik.demo.todo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;


//FIRSTLY WE WILL MAKE IT IN STATIC LIST AFTER THAT IN H2 DB and FINALLY IN REAL DATABASE LIKE MYSQL

@Entity
public class Todo {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name")
    private String username;

    @Size(min = 10, message = "Enter at least 10 character")
    private String description;
    private LocalDate targetDate; //LocalDate kullanılaması önerilir (Date yerine)
    private Boolean done;

    public Todo() {
    }

    public Todo(int id, String username, String description, LocalDate targetDate, Boolean done) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.done = done;
    }
    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", targetDate=" + targetDate +
                ", done=" + done +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
