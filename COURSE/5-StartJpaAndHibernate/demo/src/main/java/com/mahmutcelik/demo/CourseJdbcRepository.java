package com.mahmutcelik.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// THIS IS SOMETHING THAT TALKS TO THE COURSE REPOSITORY
@Repository
public class CourseJdbcRepository {
    @Autowired // IF WE DON'T ADD THIS AUTOWIRED ANNOTATION IT WILL CAUSE A NULLPOINTEREXCEPTION
    private JdbcTemplate springJdbcTemplate;

    private static String INSERT_QUERY =
            """
            insert into course(id,aname,author) VALUES (1,'AA','BB')
            """;
    //ABOVE STRING CALLS TEXT BLOCK

    public void insert(){
        springJdbcTemplate.update(INSERT_QUERY); // We use update() method to make something like insert update delete on DBMS
    }
}
