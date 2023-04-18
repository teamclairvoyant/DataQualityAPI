package com.cv.dataqualityapi.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cv.dataqualityapi.constants.DataQualityContants;
import com.cv.dataqualityapi.dao.ClientRepository;
import com.cv.dataqualityapi.dao.RulesRepository;
import com.cv.dataqualityapi.dao.RulesTypeRepository;
import com.cv.dataqualityapi.model.Rules;
import com.cv.dataqualityapi.service.RulesService;
import com.cv.dataqualityapi.utils.BusinessException;
import com.cv.dataqualityapi.wrapper.RulesWrapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RulesServiceImpl implements RulesService {

	@Autowired
	private RulesRepository ruleRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private RulesTypeRepository rulesTypeRepository;

	@Override
	public String createRules(List<RulesWrapper> rulesWrapper) throws Exception {
		Date createdTs = new Date();
		List<Rules> rule = mapRulesWrapperRule(rulesWrapper, createdTs, createdTs);
		ruleRepository.saveAll(rule);
		return DataQualityContants.SAVED;
	}

	private List<Rules> mapRulesWrapperRule(List<RulesWrapper> rulesWrapperList, Date createdTs, Date updatedTs)
			throws Exception {
		ArrayList<Rules> rulesList = new ArrayList<>();
		for (RulesWrapper rulesWrapper : rulesWrapperList) {
//			Boolean rulePresent = ruleRepository.isRulePresent(rulesWrapper);
//			log.info("The rule status is : {}", rulePresent);
			log.info("Here");
			Rules getRules = ruleRepository.getRules(rulesWrapper);
			log.info("The rule already present is : {}", getRules);
			if (getRules != null && rulesWrapper.getRuleId() == null) {
				throw new BusinessException("The rule is already present : " + rulesWrapper);
			}
			Rules rule = new Rules();
			if (rulesWrapper.getRuleId() != null) {
				rule.setRuleId(rulesWrapper.getRuleId());
				Rules ruleById = ruleRepository.getReferenceById(rulesWrapper.getRuleId());
				rule.setCreatedTs(ruleById.getCreatedTs());
				rule.setUpdatedTs(updatedTs);
				rule.setCreatedBy(ruleById.getCreatedBy());
				rule.setUpdatedBy(rulesWrapper.getClientName());
			} else {
				rule.setCreatedTs(createdTs);
				rule.setCreatedBy(rulesWrapper.getClientName());
			}
			boolean existsByClientName = clientRepository.existsByClientName(rulesWrapper.getClientName());
			boolean existsByTypeName = rulesTypeRepository.existsByTypeName(rulesWrapper.getTypeName());
			if (!existsByClientName || !existsByTypeName)
				throw new BusinessException("client or rule type not present");
//			rule.setAttributes(rulesWrapper.getAttributes());
			rule.setRuleDesc(rulesWrapper.getRuleDesc());
			rule.setTableName(rulesWrapper.getTableName());
			rule.setColumnValue(rulesWrapper.getColumnValue());
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
		Date updatedTs = new Date();
		List<Rules> rule = mapRulesWrapperRule(rulesWrapper, null, updatedTs);
		ruleRepository.saveAll(rule);
		return DataQualityContants.UPDATED;
	}

	@Override
	public List<Rules> getRulesByIds(List<Integer> ids) {
		List<Rules> findAllById = ruleRepository.findAllById(ids);
		return findAllById;
	}

	@Override
	public List<Rules> getAllRules(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

		Page<Rules> pagedResult = ruleRepository.findAll(paging);

		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Rules>();
		}
	}

	@Override
	public Boolean isRuleExists(RulesWrapper ruleWrapper) {
		Rules rules = ruleRepository.getRules(ruleWrapper);
		if(rules != null)
			return Boolean.TRUE;
		return Boolean.FALSE;
	}

}
