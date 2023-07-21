package com.cv.dataqualityapi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cv.dataqualityapi.dao.RuleSetRepository;
import com.cv.dataqualityapi.dao.RulesRepository;
import com.cv.dataqualityapi.dto.DataEntityAssociations;
import com.cv.dataqualityapi.dto.DataEntityDetails;
import com.cv.dataqualityapi.dto.JsonResponseDto;
import com.cv.dataqualityapi.dto.PropertiesDto;
import com.cv.dataqualityapi.dto.RuleDetailsDto;
import com.cv.dataqualityapi.dto.RulesJsonDto;
import com.cv.dataqualityapi.exception.ResourceNotFoundException;
import com.cv.dataqualityapi.model.EntityDetails;
import com.cv.dataqualityapi.model.RuleSet;
import com.cv.dataqualityapi.model.Rules;
import com.cv.dataqualityapi.service.GenerateRulesJsonService;

@Service
public class GenerateRulesJsonServiceImpl implements GenerateRulesJsonService {

	@Autowired
	private RuleSetRepository ruleSetRepository;

	@Autowired
	private RulesRepository ruleRepository;

	@Override
	public JsonResponseDto generateRulesJson(String ruleSetName) {
		Optional<RuleSet> ruleSetOp = ruleSetRepository.findByRulesetName(ruleSetName);
		if (ruleSetOp.isEmpty()) {
			throw new ResourceNotFoundException("rule set not found");
		}

		JsonResponseDto jsonResponse = new JsonResponseDto();
		List<RulesJsonDto> rulesJsonDtoList = new ArrayList<>();

		RuleSet ruleSet = ruleSetOp.get();
		AtomicInteger seq = new AtomicInteger(0);

		ruleSet.getRules().stream().forEach(rule -> {
			Optional<Rules> rulesOp = ruleRepository.findByRuleName(rule.getRuleName());
			EntityDetails entity = rulesOp.get().getEntityTable();

			List<DataEntityAssociations> dataEntityAssociationsList = new ArrayList<>();
			DataEntityAssociations dataEntityAssociations = new DataEntityAssociations();

			DataEntityDetails dataEntityDetails = new DataEntityDetails();
			dataEntityDetails.setId(entity.getEntityDetailsId());
			dataEntityDetails.setType(entity.getType());
			dataEntityDetails.setSubType(entity.getSubType());
			dataEntityDetails.setPhysicalName(entity.getTableName());
			dataEntityDetails.setLocation(entity.getLocation());
			dataEntityDetails.setDescription(entity.getDescription());
			dataEntityDetails.setPrimaryKey(entity.getPrimaryKey());

			dataEntityAssociations.setBehaviour(entity.getBehaviour());
			dataEntityAssociations.setDataEntityDetails(dataEntityDetails);
			dataEntityAssociationsList.add(dataEntityAssociations);

			List<PropertiesDto> propertyDtoList = new ArrayList<>();
			rule.getProperties().entrySet().stream().forEach(prop -> {
				PropertiesDto propDto = new PropertiesDto();
				propDto.setName(prop.getKey().toString());
				propDto.setValue(prop.getValue().toString());
				propDto.setType("PREDEFINED");

				propertyDtoList.add(propDto);
			});

			RuleDetailsDto ruleDetailsDto = new RuleDetailsDto();
			ruleDetailsDto.setId(rule.getRuleId());
			ruleDetailsDto.setName(rule.getRuleName());
			ruleDetailsDto.setDescription(rule.getRuleDesc());
			ruleDetailsDto.setMeasure(rule.getRulesType().getTypeName());
			ruleDetailsDto.setDataEntityAssociations(dataEntityAssociationsList);
			ruleDetailsDto.setProperties(propertyDtoList);

			RulesJsonDto rulesJsonDto = new RulesJsonDto();
			rulesJsonDto.setSequence(seq.incrementAndGet());
			rulesJsonDto.setStatus("ACTIVE");
			rulesJsonDto.setRuleDetails(ruleDetailsDto);

			rulesJsonDtoList.add(rulesJsonDto);
		});

		List<String> notificationPreferences = new ArrayList<>();
		notificationPreferences.add("EMAIL");

		jsonResponse.setId(ruleSet.getRulesetId());
		jsonResponse.setName(ruleSet.getRulesetName());
		jsonResponse.setDescription(ruleSet.getRulesetDesc());
		jsonResponse.setNotificationPreferences(notificationPreferences);
		jsonResponse.setRules(rulesJsonDtoList);

		return jsonResponse;
	}

}
