package com.cv.dataqualityapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cv.dataqualityapi.model.RulesetFrequency;

@Repository
public interface RulesetFrequencyRepository extends RulesetFrequencyDao, JpaRepository<RulesetFrequency, Integer>{

}
