package com.cv.dataqualityapi.dao;

import java.util.List;

import com.cv.dataqualityapi.model.RuleRuleSet;

public interface RuleRuleSetDao {

	List<RuleRuleSet> getRulesByRuleSetId(List<Integer> rulesetId);
	
}
