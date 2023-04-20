package com.cv.dataqualityapi.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.cv.dataqualityapi.dao.RulesTypeDao;
import com.cv.dataqualityapi.model.RulesType;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RulesTypeDaoImpl implements RulesTypeDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public RulesType getRuleType(RulesType rulesType) {
		TypedQuery<RulesType> createNamedQuery = entityManager.createNamedQuery("RulesType.getRuleType",
				RulesType.class);
		createNamedQuery.setParameter("typeName", rulesType.getTypeName());
		createNamedQuery.setParameter("ruleName", rulesType.getRuleName());
		try {
			return createNamedQuery.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	@Override
	public RulesType getRuleTypeByTypeName(String typeName) {
		TypedQuery<RulesType> createNamedQuery = entityManager.createNamedQuery("RulesType.getRuleTypeByTypeName",
				RulesType.class);
		createNamedQuery.setParameter("typeName", typeName);
		return createNamedQuery.getSingleResult();
	}

	@Override
	public Boolean existsByTypeName(String typeName) {
		TypedQuery<Long> createNamedQuery = entityManager.createNamedQuery("RulesType.getTypeCountByTypeName",
				Long.class);
		createNamedQuery.setParameter("typeName", typeName);
		Long singleResult = createNamedQuery.getSingleResult();
		log.info("Number of records are : {}", singleResult);
		return singleResult.intValue() > 0 ? true : false;
	}

}
