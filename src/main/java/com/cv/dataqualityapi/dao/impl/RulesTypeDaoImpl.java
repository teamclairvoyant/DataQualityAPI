package com.cv.dataqualityapi.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.cv.dataqualityapi.dao.RulesTypeDao;
import com.cv.dataqualityapi.model.RulesType;

public class RulesTypeDaoImpl implements RulesTypeDao {

	@PersistenceContext
	private EntityManager entityManager;

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
		return createNamedQuery.getSingleResult().intValue() > 0 ? true : false;
	}

}
