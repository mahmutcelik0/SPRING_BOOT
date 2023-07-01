package com.mahmutcelik.withClass;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {
    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private static String INSERT_QUERY =
            """
                INSERT INTO COURSE (id,aname,author)
                VALUES (?,?,?);
            """;

    private static String DELETE_QUERY =
            """
                DELETE FROM COURSE
                WHERE id = ?;
            """;

    private static String SELECT_QUERY =
            """
                SELECT * FROM COURSE
                WHERE id = ?;
            """;

    public void insert(Course course){
        springJdbcTemplate.update(INSERT_QUERY,course.getId(),course.getAname(),course.getAuthor());
    }

    public void delete(Course course){
        springJdbcTemplate.update(DELETE_QUERY,course.getId());
    }

    public Course findById(long id){
        //ResultSet -> Bean =  Row Mapper
        return springJdbcTemplate.queryForObject(SELECT_QUERY,
                new BeanPropertyRowMapper<>(Course.class),
                id);
    }



}
