package com.cv.dataqualityapi.service;

import java.util.List;

import com.cv.dataqualityapi.dto.CreateRuleTypeDto;
import com.cv.dataqualityapi.model.RulesType;

public interface RulesTypeService {

	public String createRulesType(List<CreateRuleTypeDto> createRuleTypeDto) throws Exception;

	public List<RulesType> getRulesType();
	
	public String deleteRulesType(RulesType rulesType) throws Exception;

	public String updateRulesType(RulesType rulesType) throws Exception;

	public List<RulesType> getAllRulesType(Integer pageNo, Integer pageSize, String sortBy);

	public List<RulesType> getRulesTypeByIds(List<Integer> ids);

	public RulesType findByTypeName(String typeName);
}
