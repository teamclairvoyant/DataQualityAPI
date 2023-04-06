package com.cv.dataqualityapi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cv.dataqualityapi.constants.DataQualityContants;
import com.cv.dataqualityapi.dao.ClientRepository;
import com.cv.dataqualityapi.dao.RulesRepository;
import com.cv.dataqualityapi.dao.RulesTypeRepository;
import com.cv.dataqualityapi.model.Rules;
import com.cv.dataqualityapi.service.RulesService;
import com.cv.dataqualityapi.utils.BusinessException;
import com.cv.dataqualityapi.wrapper.RulesWrapper;

@Service
public class RulesServiceImpl implements RulesService {

	@Autowired
	private RulesRepository ruleRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private RulesTypeRepository rulesTypeRepository;

	@Override
	public String createRules(List<RulesWrapper> rulesWrapper) throws Exception {
		List<Rules> rule = mapRulesWrapperRule(rulesWrapper);
		ruleRepository.saveAll(rule);
		return DataQualityContants.SAVED;
	}

	private List<Rules> mapRulesWrapperRule(List<RulesWrapper> rulesWrapperList) throws Exception {
		ArrayList<Rules> rulesList = new ArrayList<>();
		for (RulesWrapper rulesWrapper : rulesWrapperList) {
			Rules rule = new Rules();
			if (rulesWrapper.getRuleId() != null) {
				rule.setRuleId(rulesWrapper.getRuleId());
			}
			boolean existsByClientName = clientRepository.existsByClientName(rulesWrapper.getClientName());
			boolean existsByTypeName = rulesTypeRepository.existsByTypeName(rulesWrapper.getTypeName());
			if (!existsByClientName & !existsByTypeName)
				throw new BusinessException("client or rule set not present");
			rule.setAttributes(rulesWrapper.getAttributes());
			rule.setClients(clientRepository.getClientByClientName(rulesWrapper.getClientName()));
			rule.setColumnName(rulesWrapper.getColumnName());
			rule.setSourceName(rulesWrapper.getSourceName());
			rule.setRulesType(rulesTypeRepository.getRuleTypeByTypeName(rulesWrapper.getTypeName()));
			rulesList.add(rule);
		}
		return rulesList;
	}

	@Override
	public List<Rules> getRules() {
		return ruleRepository.findAll();
	}

	@Override
	public String deleteRules(List<Integer> ids) throws Exception {
		ruleRepository.deleteAllById(ids);
		return DataQualityContants.DELETED;
	}

	@Override
	public String updateRules(List<RulesWrapper> rulesWrapper) throws Exception {
		List<Rules> rule = mapRulesWrapperRule(rulesWrapper);
		ruleRepository.saveAll(rule);
		return DataQualityContants.UPDATED;
	}

}
