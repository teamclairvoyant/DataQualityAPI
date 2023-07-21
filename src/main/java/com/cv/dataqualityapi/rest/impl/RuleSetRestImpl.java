package com.cv.dataqualityapi.rest.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cv.dataqualityapi.dto.CreateRuleSetDto;
import com.cv.dataqualityapi.model.Rules;
import com.cv.dataqualityapi.rest.RuleSetRest;
import com.cv.dataqualityapi.service.RuleSetService;
import com.cv.dataqualityapi.wrapper.RuleRuleSetWrapper;
import com.cv.dataqualityapi.wrapper.RuleSetRulesWrapper;
import com.cv.dataqualityapi.wrapper.RuleSetWrapper;

@RestController
public class RuleSetRestImpl implements RuleSetRest {

	@Autowired
	private RuleSetService ruleSetService;
	
	@Override
	public String createRuleSet(List<CreateRuleSetDto> createRuleSetDto) throws Exception {
		return ruleSetService.createRuleSet(createRuleSetDto);
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
	public List<RuleSetRulesWrapper> getRulesByRuleSetIds(List<Integer> rulesetId) throws Exception {
		return ruleSetService.getRulesByRuleSetIds(rulesetId);
	}

}
