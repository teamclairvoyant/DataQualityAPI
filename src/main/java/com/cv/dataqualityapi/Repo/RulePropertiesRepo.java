package com.cv.dataqualityapi.Repo;

import com.cv.dataqualityapi.model.RuleProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RulePropertiesRepo extends JpaRepository<RuleProperties,Integer> {
}
