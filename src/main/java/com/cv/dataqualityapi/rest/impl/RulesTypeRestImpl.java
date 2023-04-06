package com.cv.dataqualityapi.rest.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cv.dataqualityapi.model.RulesType;
import com.cv.dataqualityapi.rest.RulesTypeRest;
import com.cv.dataqualityapi.service.RulesTypeService;

@RestController
public class RulesTypeRestImpl implements RulesTypeRest {
	
	@Autowired
	private RulesTypeService rulesTypeService;

	@Override
	public String createRulesType(RulesType rulesType) throws Exception {
		return rulesTypeService.createRule(rulesType);
	}

	@Override
	public List<RulesType> getRulesType() {
		return rulesTypeService.getRulesType();
	}

	@Override
	public String deleteRulesType(RulesType rulesType) throws Exception {
		return rulesTypeService.deleteRulesType(rulesType);
	}

	@Override
	public String updateRulesType(RulesType rulesType) throws Exception {
		return rulesTypeService.updateRulesType(rulesType);
	}



}