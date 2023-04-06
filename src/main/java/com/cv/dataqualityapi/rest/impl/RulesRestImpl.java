package com.cv.dataqualityapi.rest.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cv.dataqualityapi.model.Rules;
import com.cv.dataqualityapi.rest.RulesRest;
import com.cv.dataqualityapi.service.RulesService;
import com.cv.dataqualityapi.wrapper.RulesWrapper;

@RestController
public class RulesRestImpl implements RulesRest {

	@Autowired
	private RulesService ruleService;

	@Override
	public String createRule(RulesWrapper ruleWrapper) throws Exception {
		ArrayList<RulesWrapper> ruleWrapperList = new ArrayList<>();
		return ruleService.createRules(ruleWrapperList);
	}
	
	@Override
	public String createRules(List<RulesWrapper> ruleWrapper) throws Exception {
		return ruleService.createRules(ruleWrapper);
	}

	@Override
	public List<Rules> getRules() {
		return ruleService.getRules();
	}

	@Override
	public String deleteRules(List<Integer> ids) throws Exception {
		return ruleService.deleteRules(ids);
	}

	@Override
	public String updateRules(List<RulesWrapper> ruleWrapper) throws Exception {
		return ruleService.updateRules(ruleWrapper);
	}


}
