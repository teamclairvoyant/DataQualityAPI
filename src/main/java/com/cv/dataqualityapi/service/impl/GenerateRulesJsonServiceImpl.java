package com.cv.dataqualityapi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import com.cv.dataqualityapi.Repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cv.dataqualityapi.dto.DataEntityAssociations;
import com.cv.dataqualityapi.dto.DataEntityDetails;
import com.cv.dataqualityapi.dto.JsonResponseDto;
import com.cv.dataqualityapi.dto.PropertiesDto;
import com.cv.dataqualityapi.dto.RuleDetailsDto;
import com.cv.dataqualityapi.dto.RulesJsonDto;
import com.cv.dataqualityapi.exception.ResourceNotFoundException;
import com.cv.dataqualityapi.model.RuleSet;
import com.cv.dataqualityapi.model.Rules;
import com.cv.dataqualityapi.service.GenerateRulesJsonService;

@Service
public class GenerateRulesJsonServiceImpl implements GenerateRulesJsonService {

	@Autowired
	private RuleSetRepo ruleSetRepository;

	@Autowired
	private RulesRepo ruleRepository;

	@Autowired
	private EntityPropertiesRepo entityPropertiesRepository;

	@Autowired
	private EntityRepo entityRepository;

	@Autowired
	private EntityTemplatePropertiesRepo entityTemplatePropertiesRepository;

	@Autowired
	private EntityTemplateRepo entityTemplateRepository;

	@Autowired
	private RuleEntityMapRepo ruleEntityMapRepository;

	@Autowired
	private RulePropertiesRepo rulePropertiesRepository;

	@Autowired
	private RuleTemplatePropertiesRepo ruleTemplatePropertiesRepository;

	@Autowired
	private RuleTemplateRepo ruleTemplateRepository;

	@Override
	public JsonResponseDto generateRulesJson(String rulesetName) {

		Optional<RuleSet> ruleSetOp = ruleSetRepository.findByRulesetName(rulesetName);
		if (ruleSetOp.isEmpty()) {
			throw new ResourceNotFoundException("rule set not found");
		}

		JsonResponseDto jsonResponse = new JsonResponseDto();
		List<RulesJsonDto> ruleJsonList = new ArrayList<>();

		RuleSet ruleset = ruleSetOp.get();
		AtomicInteger seq = new AtomicInteger();

		ruleset.getRules().stream().forEach(rules -> {
			Optional<Rules> rulesOp = ruleRepository.findByRuleName(rules.getRuleName());

			List<DataEntityAssociations> dataEntityAssociationsList = new ArrayList<>();
			DataEntityAssociations dataEntityAssociations = new DataEntityAssociations();

		//	dataEntityAssociations.setEntity_id(entity.getEntity_id());

		});
		return jsonResponse;
	}

}