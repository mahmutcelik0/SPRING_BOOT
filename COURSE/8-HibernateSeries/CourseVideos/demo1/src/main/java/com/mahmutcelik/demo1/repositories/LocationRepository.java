package com.mahmutcelik.demo1.repositories;

import com.mahmutcelik.demo1.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface LocationRepository extends JpaRepository<Location,Long> {
}
