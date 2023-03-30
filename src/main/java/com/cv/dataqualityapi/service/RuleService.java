package com.cv.dataqualityapi.service;

import com.cv.dataqualityapi.model.Rules;

public interface RuleService {

	public String createRule(Rules rule);

	public String getRules();

}
