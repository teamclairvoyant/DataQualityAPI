package com.cv.dataqualityapi.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cv.dataqualityapi.model.Rules;

@Repository
public interface RulesRepository extends RulesDao, JpaRepository<Rules, Integer>{

	Optional<Rules> findByRuleName(String ruleName);
    
    void deleteAllByIdInBatch(Iterable<Integer> ids);
}
