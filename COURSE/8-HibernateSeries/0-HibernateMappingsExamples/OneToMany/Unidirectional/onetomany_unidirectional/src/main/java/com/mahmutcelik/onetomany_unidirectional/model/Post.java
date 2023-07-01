package com.mahmutcelik.onetomany_unidirectional.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "POSTS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;
    @Column(name = "DESCRIPTION")
    private String description;


    //BELOW ANNOTATION MEAN ONE POST MANY COMMENTS
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pc_fid",referencedColumnName = "id")
    //ABOVE ANNOTATION CREATES A FIELD IN COMMENT TABLE AND THAT FIELD PROVIDES RIC TO POST TABLE'S ID
    // PC_FID -> POST.ID   === ONE TO MANY RELATIONSHIP ; ONE - POST , MANY - COMMENT (UNDIRECTIONAL)
    List<Comment> commentList = new ArrayList<>();

}
