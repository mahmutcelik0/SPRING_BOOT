package com.mahmutcelik.withJPAandEntityManager;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository // IT TALKS TO THE DATABASE
@Transactional
public class JpaRepository {
    @PersistenceContext //It is more specific version of autowired that used for wire the persistance context
    private EntityManager entityManager;

    public void insert(Course course){
        entityManager.merge(course);  // we use merge
    }

    public Course findById(long id){
        return entityManager.find(Course.class,id);
    }

    public void deleteById(long id){
        Course deleteCourse = entityManager.find(Course.class,id);
        entityManager.remove(deleteCourse);
    }

}
