package com.cv.dataqualityapi.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.cv.dataqualityapi.constants.DataQualityContants;
import com.cv.dataqualityapi.dao.EntityDetailsRepository;
import com.cv.dataqualityapi.dao.RuleSetRepository;
import com.cv.dataqualityapi.dao.RulesRepository;
import com.cv.dataqualityapi.dao.RulesTypeRepository;
import com.cv.dataqualityapi.dto.CreateRulesDto;
import com.cv.dataqualityapi.dto.UpdateRulesDto;
import com.cv.dataqualityapi.exception.BusinessException;
import com.cv.dataqualityapi.exception.ResourceNotFoundException;
import com.cv.dataqualityapi.model.EntityDetails;
import com.cv.dataqualityapi.model.RuleSet;
import com.cv.dataqualityapi.model.Rules;
import com.cv.dataqualityapi.model.RulesType;
import com.cv.dataqualityapi.service.EntityDetailsService;
import com.cv.dataqualityapi.service.RuleSetService;
import com.cv.dataqualityapi.service.RulesService;
import com.cv.dataqualityapi.service.RulesTypeService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RulesServiceImpl implements RulesService {

	@Autowired
	private RulesRepository ruleRepository;

	@Autowired
	private RuleSetService ruleSetService;

	@Autowired
	private EntityDetailsService entityDetailsService;

	@Autowired
	private RulesTypeService rulesTypeService;

	@Override
	public String createRules(List<CreateRulesDto> rulesDto) throws Exception {
		Date createdTs = new Date();

		List<Rules> ruleList = new ArrayList<>();

		rulesDto.stream().forEach(dto -> {
			Optional<Rules> getRules = ruleRepository.findByRuleName(dto.getRuleName());
			log.info("The rule already present is : {}", getRules);
			if (getRules.isPresent()) {
				throw new BusinessException("The rule is already present : " + dto.getRuleName());
			}

			RulesType ruleType = rulesTypeService.findByTypeName(dto.getRulesType());

			RuleSet ruleSet = ruleSetService.findByRulesetName(dto.getRuleSet());

			EntityDetails entityDetails = entityDetailsService.findByTableName(dto.getEntityTable());

			Rules rules = new Rules();
			rules.setRuleName(dto.getRuleName());
			rules.setRulesType(ruleType);
			rules.getRuleSet().add(ruleSet);
			rules.setEntityTable(entityDetails);
			rules.setRuleDesc(dto.getRuleDesc());
			rules.setProperties(dto.getProperties());
			rules.setCreatedBy("API");
			rules.setUpdatedBy("API");
			rules.setCreatedTs(createdTs);
			rules.setUpdatedTs(createdTs);

			ruleList.add(rules);
		});

		ruleRepository.saveAll(ruleList);
		return DataQualityContants.SAVED;
	}

	@Override
	public List<Rules> getRules() {
		return ruleRepository.findAll();
	}

	@Override
	public String deleteRules(List<Integer> ids) throws Exception {
		ruleRepository.deleteAllByIdInBatch(ids);
		return DataQualityContants.DELETED;
	}

	@Override
	public String updateRules(List<UpdateRulesDto> rulesDto) throws Exception {
		Date updatedTs = new Date();
		List<Rules> rulesList = new ArrayList<>();
		
		rulesDto.stream().forEach(dto -> {
			RulesType ruleType = null;
			Rules rules = findById(dto.getRuleId());

			Rules rule = rules;
			if (StringUtils.hasText(dto.getRulesType())) {
				ruleType = rulesTypeService.findByTypeName(dto.getRulesType());
				rule.setRulesType(ruleType);
			}

			RuleSet ruleSet = null;
			if (StringUtils.hasText(dto.getRuleSet())) {
				ruleSet = ruleSetService.findByRulesetName(dto.getRuleSet());
				rule.getRuleSet().add(ruleSet);
			}

			EntityDetails entityDetails = null;
			if (StringUtils.hasText(dto.getEntityTable())) {
				entityDetails = entityDetailsService.findByTableName(dto.getEntityTable());
				rule.setEntityTable(entityDetails);
			}

			if (!ObjectUtils.isEmpty(dto.getProperties())) {
				dto.getProperties().entrySet().stream().forEach(entry -> {
					rule.getProperties().put(entry.getKey(), entry.getValue());
				});
			}

			if (StringUtils.hasText(dto.getRuleName()))
				rule.setRuleName(dto.getRuleName());

			if (StringUtils.hasText(dto.getRuleDesc()))
				rule.setRuleDesc(dto.getRuleDesc());

			rule.setUpdatedTs(updatedTs);
			rulesList.add(rule);
		});

		ruleRepository.saveAll(rulesList);
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
	public Boolean isRuleExists(CreateRulesDto ruleDto) {
		Rules rules = ruleRepository.getRules(ruleDto);
		if (rules != null)
			return Boolean.TRUE;
		return Boolean.FALSE;
	}

	@Override
	public Rules findById(Integer id) {
		Optional<Rules> rulesOp = ruleRepository.findById(id);
		if (rulesOp.isEmpty())
			throw new ResourceNotFoundException("rule not found for id " + id);

		return rulesOp.get();
	}

}
