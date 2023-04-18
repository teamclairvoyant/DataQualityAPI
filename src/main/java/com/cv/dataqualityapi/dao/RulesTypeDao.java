package com.cv.dataqualityapi.dao;

import com.cv.dataqualityapi.model.RulesType;

public interface RulesTypeDao {

	RulesType getRuleTypeByTypeName(String typeName);

	Boolean existsByTypeName(String typeName);

	RulesType getRuleType(RulesType rulesType);


}
