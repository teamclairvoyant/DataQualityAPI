package com.cv.dataqualityapi.rest.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cv.dataqualityapi.model.Rules;
import com.cv.dataqualityapi.rest.RuleSetRest;
import com.cv.dataqualityapi.service.RuleSetService;
import com.cv.dataqualityapi.wrapper.RuleRuleSetWrapper;
import com.cv.dataqualityapi.wrapper.RuleSetWrapper;

@RestController
public class RuleSetRestImpl implements RuleSetRest {

	@Autowired
	private RuleSetService ruleSetService;
	
	@Override
	public String createRuleSet(List<RuleSetWrapper> ruleSetWrapper) throws Exception {
		return ruleSetService.createRuleSet(ruleSetWrapper);
	}
	
	
	@Override
	public String deleteRuleSet(List<Integer> ruleSetId) throws Exception {
		return ruleSetService.deleteRuleSet(ruleSetId);
	}


	@Override
	public String tagRulesToRuleSet(List<RuleRuleSetWrapper> ruleRuleSetWrapper) throws Exception {
		return ruleSetService.tagRulesToRuleSet(ruleRuleSetWrapper);
	}


	@Override
	public String untagRulesToRuleSet(List<RuleRuleSetWrapper> ruleRuleSetWrapper) throws Exception {
		return ruleSetService.untagRulesToRuleSet(ruleRuleSetWrapper);
	}


	@Override
	public List<Rules> getRulesByRuleSetId(Integer rulesetId) throws Exception {
		return ruleSetService.getRulesByRuleSetId(rulesetId);
	}

}
