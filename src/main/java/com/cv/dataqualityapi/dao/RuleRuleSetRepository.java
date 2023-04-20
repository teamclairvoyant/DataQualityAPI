package com.cv.dataqualityapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cv.dataqualityapi.model.RuleRuleSet;
import com.cv.dataqualityapi.model.RuleRuleSetKey;

public interface RuleRuleSetRepository extends JpaRepository<RuleRuleSet, RuleRuleSetKey>, RuleRuleSetDao {

}
