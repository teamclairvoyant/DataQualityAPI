package com.cv.dataqualityapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cv.dataqualityapi.model.Rules;

@Repository
public interface RulesRepository extends RulesDao, JpaRepository<Rules, Integer>{

}