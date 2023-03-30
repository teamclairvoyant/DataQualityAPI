package com.cv.dataqualityapi.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cv.dataqualityapi.model.Rules;
import com.cv.dataqualityapi.rest.RuleRest;
import com.cv.dataqualityapi.service.RuleService;

@RestController()
public class RuleRestImpl implements RuleRest {

	@Autowired
	private RuleService ruleService;

	@Override
	public String createRule(Rules rule) {
		return ruleService.createRule(rule);
	}

	@Override
	public String getRules() {
		return ruleService.getRules();
	}

}
