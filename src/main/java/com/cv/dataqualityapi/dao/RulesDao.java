package com.cv.dataqualityapi.dao;

import java.util.List;

import com.cv.dataqualityapi.dto.CreateRulesDto;
import com.cv.dataqualityapi.model.Rules;
import com.cv.dataqualityapi.wrapper.RulesWrapper;

public interface RulesDao{
	
	List<Rules> getAllRulesPks();
	
	Boolean isRulePresent(RulesWrapper rulesWrapper);

	Rules getRules(CreateRulesDto rulesDto);

}
