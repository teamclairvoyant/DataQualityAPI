package com.cv.dataqualityapi.Repo;

import com.cv.dataqualityapi.model.Entities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityRepo extends JpaRepository<Entities,Integer> {
}
