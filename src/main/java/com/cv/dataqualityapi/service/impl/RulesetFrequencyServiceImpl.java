package com.cv.dataqualityapi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cv.dataqualityapi.constants.DataQualityContants;
import com.cv.dataqualityapi.dao.RuleSetRepository;
import com.cv.dataqualityapi.dao.RulesetFrequencyRepository;
import com.cv.dataqualityapi.model.RulesetFrequency;
import com.cv.dataqualityapi.service.RulesetFrequencyService;
import com.cv.dataqualityapi.utils.BusinessException;
import com.cv.dataqualityapi.wrapper.RulesetFrequencyWrapper;

@Service
public class RulesetFrequencyServiceImpl implements RulesetFrequencyService {

	@Autowired
	private RulesetFrequencyRepository rulesetFrequencyRepository;

	@Autowired
	private RuleSetRepository ruleSetRepository;

	@Override
	public List<RulesetFrequency> getRulesetFrequency() {
		return rulesetFrequencyRepository.findAll();
	}

	@Override
	public String createRulesetFrequency(List<RulesetFrequencyWrapper> rulesetFrequency) throws Exception {
		List<RulesetFrequency> mapRulesetFreqWrapperRulesetFreq = mapRulesetFreqWrapperRulesetFreq(rulesetFrequency);
		rulesetFrequencyRepository.saveAll(mapRulesetFreqWrapperRulesetFreq);
		return DataQualityContants.SAVED;
	}

	private List<RulesetFrequency> mapRulesetFreqWrapperRulesetFreq(
			List<RulesetFrequencyWrapper> rulesetFrequencyWrapperList) throws Exception {
		ArrayList<RulesetFrequency> rulesetFrequencyList = new ArrayList<>();
		for (RulesetFrequencyWrapper rulesetFrequencyWrapper : rulesetFrequencyWrapperList) {
			RulesetFrequency rulesetFrequency = new RulesetFrequency();
			if (rulesetFrequencyWrapper.getFreqId() != null)
				rulesetFrequency.setFreqId(rulesetFrequencyWrapper.getFreqId());

			Boolean existsByRuleSetName = ruleSetRepository
					.existsByRuleSetName(rulesetFrequencyWrapper.getRuleSetName());
			if (!existsByRuleSetName)
				throw new BusinessException("Rule set not present");

			rulesetFrequency.setFrequency(rulesetFrequencyWrapper.getFrequency());

			rulesetFrequency
					.setRuleSet(ruleSetRepository.getRuleSetByRuleSetName(rulesetFrequencyWrapper.getRuleSetName()));

			rulesetFrequencyList.add(rulesetFrequency);
		}
		return rulesetFrequencyList;
	}

	@Override
	public String deleteRulesetFrequency(List<Integer> freqIds) {
		rulesetFrequencyRepository.deleteAllById(freqIds);
		return DataQualityContants.DELETED;
	}
	
	@Override
	public String updateRulesetFrequency(List<RulesetFrequencyWrapper> rulesetFrequency) throws Exception {
		List<RulesetFrequency> mapRulesetFreqWrapperRulesetFreq = mapRulesetFreqWrapperRulesetFreq(rulesetFrequency);
		rulesetFrequencyRepository.saveAll(mapRulesetFreqWrapperRulesetFreq);
		return DataQualityContants.UPDATED;
	}
}
