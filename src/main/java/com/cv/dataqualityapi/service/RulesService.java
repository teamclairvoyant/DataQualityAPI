package com.cv.dataqualityapi.service;

import java.util.List;
import java.util.Optional;

import com.cv.dataqualityapi.dto.CreateRulesDto;
import com.cv.dataqualityapi.dto.JsonResponseDto;
import com.cv.dataqualityapi.dto.UpdateRulesDto;
import com.cv.dataqualityapi.model.Rules;

public interface RulesService {

	String createRules(List<CreateRulesDto> ruleWrapper) throws Exception;

	List<Rules> getRules();

	String deleteRules(List<Integer> ids) throws Exception;

	String updateRules(List<UpdateRulesDto> updateRulesDto) throws Exception;

	List<Rules> getRulesByIds(List<Integer> ids);

	List<Rules> getAllRules(Integer pageNo, Integer pageSize, String sortBy);

	Boolean isRuleExists(CreateRulesDto ruleDto);
	
	Rules findById(Integer id);
}
