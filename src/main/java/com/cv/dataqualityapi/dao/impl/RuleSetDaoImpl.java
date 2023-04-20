package com.cv.dataqualityapi.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.cv.dataqualityapi.dao.RuleSetDao;
import com.cv.dataqualityapi.model.RuleSet;
import com.cv.dataqualityapi.wrapper.RuleSetWrapper;

public class RuleSetDaoImpl implements RuleSetDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public RuleSet getRuleSetByRuleSetName(String ruleSetName) {
		TypedQuery<RuleSet> createNamedQuery = entityManager.createNamedQuery("RuleSet.getRuleSetByRuleSetName",
				RuleSet.class);
		createNamedQuery.setParameter("rulesetName", ruleSetName);
		try {
			return createNamedQuery.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	@Override
	public RuleSet isRuleSetExists(RuleSetWrapper ruleSetWrapper) {
		TypedQuery<RuleSet> createNamedQuery = entityManager.createNamedQuery("RuleSet.getRuleSetCount", RuleSet.class);
		createNamedQuery.setParameter("rulesetName", ruleSetWrapper.getRulesetName());
		createNamedQuery.setParameter("rulesetDesc", ruleSetWrapper.getRulesetDesc());
		try {
			return createNamedQuery.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

}
