package com.cv.dataqualityapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cv.dataqualityapi.dao.RuleRepository;
import com.cv.dataqualityapi.model.Rules;
import com.cv.dataqualityapi.service.RuleService;

@Service
public class RuleServiceImpl implements RuleService {
	
	@Autowired
	private RuleRepository ruleRepository;

	@Override
	public String createRule(Rules rule) {
		ruleRepository.save(rule);
		return "Saved Successfully";
	}
	
	@Override
	public String getRules() {
		return "Hello Siddharth from service";
	}

}
