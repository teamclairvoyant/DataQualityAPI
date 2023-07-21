package com.cv.dataqualityapi.rest.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cv.dataqualityapi.dto.CreateRulesDto;
import com.cv.dataqualityapi.dto.JsonResponseDto;
import com.cv.dataqualityapi.dto.UpdateRulesDto;
import com.cv.dataqualityapi.model.Rules;
import com.cv.dataqualityapi.rest.RulesRest;
import com.cv.dataqualityapi.service.RulesService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RulesRestImpl implements RulesRest {

	@Autowired
	private RulesService ruleService;

	@Override
	public String createRule(CreateRulesDto ruleDto) throws Exception {
		log.debug("The input parameter for creating the Rule is : {}", ruleDto);
		ArrayList<CreateRulesDto> ruleWrapperList = new ArrayList<>();
		ruleWrapperList.add(ruleDto);
		return ruleService.createRules(ruleWrapperList);
	}

	@Override
	public String createRules(List<CreateRulesDto> ruleWrapper) throws Exception {
		log.debug("The input parameter for creating the Rules are : {}", ruleWrapper);
		return ruleService.createRules(ruleWrapper);
	}

	@Override
	public List<Rules> getRules() {
		log.debug("Going to get all the rules");
		return ruleService.getRules();
	}

	@Override
	public String deleteRules(List<Integer> ids) throws Exception {
		log.debug("The input parameter for deleting the Rules are : {}", ids);
		return ruleService.deleteRules(ids);
	}

	@Override
	public String updateRules(List<UpdateRulesDto> rulesDto) throws Exception {
		log.debug("The input parameter for updating the Rules are : {}", rulesDto);
		return ruleService.updateRules(rulesDto);
	}

	@Override
	public List<Rules> getRulesByIds(List<Integer> ids) {
		log.debug("Going to get all the rules of ids : {}", ids);
		return ruleService.getRulesByIds(ids);
	}

	@Override
	public List<Rules> getAllRules(Integer pageNo, Integer pageSize, String sortBy) {
		List<Rules> ruleList  = ruleService.getAllRules(pageNo, pageSize, sortBy);
	    return ruleList;
	}

	@Override
	public Boolean isRuleExists(CreateRulesDto ruleDto) {
		return ruleService.isRuleExists(ruleDto);
	}
}
