package com.cv.dataqualityapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cv.dataqualityapi.model.RulesType;

@Repository
public interface RulesTypeRepository extends RulesTypeDao, JpaRepository<RulesType, Integer>{

}
