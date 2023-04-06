package com.cv.dataqualityapi.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.cv.dataqualityapi.dao.RuleSetDao;
import com.cv.dataqualityapi.model.RuleSet;

public class RuleSetDaoImpl implements RuleSetDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public RuleSet getRuleSetByRuleSetName(String ruleSetName) {
		TypedQuery<RuleSet> createNamedQuery = entityManager.createNamedQuery("RuleSet.getRuleSetByRuleSetName",
				RuleSet.class);
		createNamedQuery.setParameter("rulesetName", ruleSetName);
		return createNamedQuery.getSingleResult();
	}

	@Override
	public Boolean existsByRuleSetName(String ruleSetName) {
		TypedQuery<Long> createNamedQuery = entityManager.createNamedQuery("RuleSet.getRuleSetCountByRuleSetName", Long.class);
		createNamedQuery.setParameter("rulesetName", ruleSetName);
		return createNamedQuery.getSingleResult().intValue() > 0 ? true : false;
	}

}
