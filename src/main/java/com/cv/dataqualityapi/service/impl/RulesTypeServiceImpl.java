package com.cv.dataqualityapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cv.dataqualityapi.constants.DataQualityContants;
import com.cv.dataqualityapi.dao.RulesTypeRepository;
import com.cv.dataqualityapi.model.RulesType;
import com.cv.dataqualityapi.service.RulesTypeService;
import com.cv.dataqualityapi.utils.BusinessException;

@Service
public class RulesTypeServiceImpl implements RulesTypeService {
	
	@Autowired
	private RulesTypeRepository rulesTypeRepository;

	@Override
	public String createRule(RulesType rulesType) throws Exception {
		rulesTypeRepository.save(rulesType);
		return "Rule Type Created";
	}

	@Override
	public List<RulesType> getRulesType() {
		return rulesTypeRepository.findAll();
	}

	@Override
	public String deleteRulesType(RulesType rulesType) throws Exception {
		if (rulesTypeRepository.existsByTypeName(rulesType.getTypeName())) {
			rulesTypeRepository.delete(rulesType);
			return DataQualityContants.DELETED;
		}
		throw new BusinessException("Cannot delete RulesType because it does not exists");
	}

	@Override
	public String updateRulesType(RulesType rulesType) throws Exception {
		Boolean existsById = rulesTypeRepository.existsById(rulesType.getRuleTypeId());
		if (existsById) {
			rulesTypeRepository.save(rulesType);
			return DataQualityContants.UPDATED;
		}
		throw new BusinessException("Rules Type Ref doesnot Exists");
	}
}
