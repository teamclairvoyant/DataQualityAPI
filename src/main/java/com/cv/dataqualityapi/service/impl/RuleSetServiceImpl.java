package com.cv.dataqualityapi.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cv.dataqualityapi.constants.DataQualityContants;
import com.cv.dataqualityapi.dao.RuleRuleSetRepository;
import com.cv.dataqualityapi.dao.RuleSetRepository;
import com.cv.dataqualityapi.dao.RulesRepository;
import com.cv.dataqualityapi.model.RuleRuleSet;
import com.cv.dataqualityapi.model.RuleRuleSetKey;
import com.cv.dataqualityapi.model.RuleSet;
import com.cv.dataqualityapi.model.Rules;
import com.cv.dataqualityapi.service.RuleSetService;
import com.cv.dataqualityapi.utils.BusinessException;
import com.cv.dataqualityapi.wrapper.RuleRuleSetWrapper;
import com.cv.dataqualityapi.wrapper.RuleSetRulesWrapper;
import com.cv.dataqualityapi.wrapper.RuleSetWrapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RuleSetServiceImpl implements RuleSetService {

	@Autowired
	private RuleSetRepository ruleSetRepository;

	@Autowired
	private RuleRuleSetRepository ruleRuleSetRepository;

	@Autowired
	private RulesRepository rulesRepository;

	@Override
	public String createRuleSet(List<RuleSetWrapper> ruleSetWrapper) throws Exception {
		List<RuleSet> mapRuleseWrapperRuleset = mapRuleseWrapperRuleset(ruleSetWrapper);
		ruleSetRepository.saveAll(mapRuleseWrapperRuleset);
		return DataQualityContants.SAVED;
	}

	private List<RuleSet> mapRuleseWrapperRuleset(List<RuleSetWrapper> ruleSetWrapperList) throws Exception {
		ArrayList<RuleSet> rulesetList = new ArrayList<>();
		for (RuleSetWrapper ruleSetWrapper : ruleSetWrapperList) {
			RuleSet ruleset = new RuleSet();
			RuleSet isRuleSetExists = ruleSetRepository.isRuleSetExists(ruleSetWrapper);
			if (isRuleSetExists != null)
				throw new BusinessException("The ruleset already exists" + isRuleSetExists);

			if (ruleSetWrapper.getRulesetId() != null)
				ruleset.setRulesetId(ruleSetWrapper.getRulesetId());
			ruleset.setRulesetName(ruleSetWrapper.getRulesetName());
			ruleset.setRulesetDesc(ruleSetWrapper.getRulesetDesc());
			rulesetList.add(ruleset);
		}
		return rulesetList;
	}

	@Override
	public String deleteRuleSet(List<Integer> ruleSetIds) {
		ruleSetRepository.deleteAllById(ruleSetIds);
		return DataQualityContants.DELETED;
	}

	@Override
	public String tagRulesToRuleSet(List<RuleRuleSetWrapper> ruleRuleSetWrapperList) {
		List<Integer> pks = getPks();
		List<RuleRuleSet> ruleRuleSetList = new ArrayList<>();
		for (RuleRuleSetWrapper ruleRuleSetWrapper : ruleRuleSetWrapperList) {
			boolean existsRulesetId = ruleSetRepository.existsById(ruleRuleSetWrapper.getRulesetId());
			if (!existsRulesetId)
				throw new BusinessException("The ruleset doesnot exist in RulesSets");

			boolean containsAll = pks.containsAll(ruleRuleSetWrapper.getRuleIds());
			if (!containsAll)
				throw new BusinessException("The rules doesnot exist in Rules table");
			RuleSet referenceById = ruleSetRepository.getReferenceById(ruleRuleSetWrapper.getRulesetId());
			for (Integer rulePk : ruleRuleSetWrapper.getRuleIds()) {
				RuleRuleSet ruleRuleSet = new RuleRuleSet();
				RuleRuleSetKey ruleRuleSetKey = new RuleRuleSetKey();
				ruleRuleSetKey.setRuleId(rulePk);
				ruleRuleSetKey.setRulesetId(ruleRuleSetWrapper.getRulesetId());
				ruleRuleSet.setId(ruleRuleSetKey);
				ruleRuleSet.setRules(rulesRepository.getReferenceById(rulePk));
				ruleRuleSet.setRuleSet(referenceById);
				ruleRuleSetList.add(ruleRuleSet);
			}
		}
		ruleRuleSetRepository.saveAll(ruleRuleSetList);
		return "Rules are tagged to Rule Set";
	}

	private List<Integer> getPks() {
		List<Rules> rules = rulesRepository.getAllRulesPks();
		ArrayList<Integer> pkList = new ArrayList<>();
		for (Rules rule : rules) {
			pkList.add(rule.getRuleId());
		}
		return pkList;
	}

	@Override
	public String untagRulesToRuleSet(List<RuleRuleSetWrapper> ruleRuleSetWrapperList) {
		List<RuleRuleSetKey> RuleRuleSetKeyList = new ArrayList<>();
		for (RuleRuleSetWrapper ruleRuleSetWrapper : ruleRuleSetWrapperList) {
			for (Integer rulePk : ruleRuleSetWrapper.getRuleIds()) {
				RuleRuleSetKey ruleRuleSetKey = new RuleRuleSetKey();
				ruleRuleSetKey.setRuleId(rulePk);
				ruleRuleSetKey.setRulesetId(ruleRuleSetWrapper.getRulesetId());
				RuleRuleSetKeyList.add(ruleRuleSetKey);
			}
		}
		ruleRuleSetRepository.deleteAllById(RuleRuleSetKeyList);
		return "Rules untagged successfully";
	}

	@Override
	public List<RuleSetRulesWrapper> getRulesByRuleSetIds(List<Integer> rulesetId) {
		log.trace("Ruleset Ids passed to getRulesByRuleSetId are : {}", rulesetId);
		Map<Integer, List<Rules>> mapRuleIdWithRules = new HashMap<>();
		List<RuleRuleSet> rulesByRuleSetId = ruleRuleSetRepository.getRulesByRuleSetId(rulesetId);
		for (RuleRuleSet rrs : rulesByRuleSetId) {
			if (mapRuleIdWithRules.containsKey(rrs.getRuleSet().getRulesetId())) {
				mapRuleIdWithRules.get(rrs.getRuleSet().getRulesetId()).add(rrs.getRules());
			} else {
				List<Rules> rule = new ArrayList<>();
				rule.add(rrs.getRules());
				mapRuleIdWithRules.put(rrs.getRuleSet().getRulesetId(), rule);
			}
		}
		List<Integer> inputRulesetIds = new ArrayList<>();
		inputRulesetIds.addAll(rulesetId);
		List<Integer> rulesetPresent = new ArrayList<>();
		rulesetPresent.addAll(mapRuleIdWithRules.keySet());
		log.info("The ruleset present in the database are : {}", rulesetPresent);
		inputRulesetIds.removeAll(rulesetPresent);
		log.info("The ruleset not present in the database are : {}", inputRulesetIds);
		if (inputRulesetIds.size() == 0)
			return maptoWrapper(mapRuleIdWithRules);
		for (Integer inputRulesetId : inputRulesetIds)
			mapRuleIdWithRules.put(inputRulesetId, Collections.emptyList());
		return maptoWrapper(mapRuleIdWithRules);
	}

	private List<RuleSetRulesWrapper> maptoWrapper(Map<Integer, List<Rules>> mapRuleIdWithRules) {
		log.debug("Mapping map to RuleSetRulesWrapper");
		List<RuleSetRulesWrapper> ruleSetRulesWrapperList = new ArrayList<>();
		for (Integer key : mapRuleIdWithRules.keySet()) {
			RuleSetRulesWrapper ruleSetRulesWrapper = new RuleSetRulesWrapper();
			ruleSetRulesWrapper.setRulesetId(key);
			ruleSetRulesWrapper.setRules(mapRuleIdWithRules.get(key));
			ruleSetRulesWrapperList.add(ruleSetRulesWrapper);
		}
		return ruleSetRulesWrapperList;
	}

}
