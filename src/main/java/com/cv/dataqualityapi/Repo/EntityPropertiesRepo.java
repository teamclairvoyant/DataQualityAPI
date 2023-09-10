package com.cv.dataqualityapi.Repo;

import com.cv.dataqualityapi.model.EntityProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityPropertiesRepo extends JpaRepository <EntityProperties, Integer> {
}
