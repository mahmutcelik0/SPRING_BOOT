package com.mahmutcelik.demo1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime postDate;
    private String details;

    private Long userid;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userid",updatable = false,insertable = false)
    @JsonIgnore
    private User user;
}
