package com.cv.dataqualityapi.service;

import java.util.List;

import com.cv.dataqualityapi.model.Rules;
import com.cv.dataqualityapi.wrapper.RulesWrapper;

public interface RulesService {

	String createRules(List<RulesWrapper> ruleWrapper) throws Exception;
	
	List<Rules> getRules();

	String deleteRules(List<Integer> ids) throws Exception;

	String updateRules(List<RulesWrapper> rulesWrapper) throws Exception;

}
