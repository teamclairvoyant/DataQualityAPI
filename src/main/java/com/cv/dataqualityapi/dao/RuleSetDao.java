package com.cv.dataqualityapi.dao;

import com.cv.dataqualityapi.model.RuleSet;
import com.cv.dataqualityapi.wrapper.RuleSetWrapper;

public interface RuleSetDao {
	
	RuleSet getRuleSetByRuleSetName(String ruleSetName);

	RuleSet isRuleSetExists(RuleSetWrapper ruleSetWrapper);


}
