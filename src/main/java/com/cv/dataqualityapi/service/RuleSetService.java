package com.cv.dataqualityapi.service;

import java.util.List;

import com.cv.dataqualityapi.dto.CreateRuleSetDto;
import com.cv.dataqualityapi.model.RuleSet;
import com.cv.dataqualityapi.wrapper.RuleRuleSetWrapper;
import com.cv.dataqualityapi.wrapper.RuleSetRulesWrapper;

public interface RuleSetService {

	String createRuleSet(List<CreateRuleSetDto> ruleSetDto) throws Exception;

	String deleteRuleSet(List<Integer> ruleSet);

	String tagRulesToRuleSet(List<RuleRuleSetWrapper> ruleRuleSetWrapper);

	String untagRulesToRuleSet(List<RuleRuleSetWrapper> ruleRuleSetWrapper);

	List<RuleSetRulesWrapper> getRulesByRuleSetIds(List<Integer> rulesetId);

	RuleSet findByRulesetName(String rulesetName);

}
