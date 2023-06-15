package com.cv.dataqualityapi.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cv.dataqualityapi.model.RulesType;

@Repository
public interface RulesTypeRepository extends RulesTypeDao, JpaRepository<RulesType, Integer>{

	@Query("SELECT rt from RulesType rt where upper(rt.typeName) = upper(:typeName)")
	Optional<RulesType> findByTypeName(String typeName);
}
