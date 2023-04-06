package com.cv.dataqualityapi.service;

import java.util.List;

import com.cv.dataqualityapi.model.RulesType;

public interface RulesTypeService {

	public String createRule(RulesType rulesType) throws Exception;

	public List<RulesType> getRulesType();
	
	public String deleteRulesType(RulesType rulesType) throws Exception;

	String updateRulesType(RulesType rulesType) throws Exception;

}
