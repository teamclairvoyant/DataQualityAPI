package com.cv.dataqualityapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cv.dataqualityapi.model.RuleSet;

@Repository
public interface RuleSetRepository extends JpaRepository<RuleSet, Integer>, RuleSetDao {

}