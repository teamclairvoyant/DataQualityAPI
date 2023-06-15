package com.cv.dataqualityapi.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cv.dataqualityapi.model.RuleSet;

@Repository
public interface RuleSetRepository extends JpaRepository<RuleSet, Integer>, RuleSetDao {

	@Query("SELECT rs from RuleSet rs where upper(rs.rulesetName) = upper(:rulesetName)")
	Optional<RuleSet> findByRulesetName(String rulesetName);
	
	boolean existsByRulesetName(String rulesetName);
}
