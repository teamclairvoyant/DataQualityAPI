package com.cv.dataqualityapi.service;

import java.util.List;

import com.cv.dataqualityapi.model.Rules;
import com.cv.dataqualityapi.wrapper.RuleRuleSetWrapper;
import com.cv.dataqualityapi.wrapper.RuleSetWrapper;

public interface RuleSetService {

	String createRuleSet(List<RuleSetWrapper> ruleSetWrapper) throws Exception;

	String deleteRuleSet(List<Integer> ruleSet);

	String tagRulesToRuleSet(List<RuleRuleSetWrapper> ruleRuleSetWrapper);

	String untagRulesToRuleSet(List<RuleRuleSetWrapper> ruleRuleSetWrapper);

	List<Rules> getRulesByRuleSetId(Integer rulesetId);


}
