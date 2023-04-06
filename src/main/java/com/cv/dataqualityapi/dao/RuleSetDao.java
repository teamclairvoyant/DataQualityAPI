package com.cv.dataqualityapi.dao;

import com.cv.dataqualityapi.model.RuleSet;

public interface RuleSetDao {
	
	Boolean existsByRuleSetName(String clientName);

	RuleSet getRuleSetByRuleSetName(String ruleSetName);

}
