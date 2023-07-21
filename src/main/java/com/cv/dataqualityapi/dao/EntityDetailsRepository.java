package com.cv.dataqualityapi.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cv.dataqualityapi.model.EntityDetails;

public interface EntityDetailsRepository extends JpaRepository<EntityDetails, Integer>{
	
	@Query("SELECT e from EntityDetails e where upper(e.tableName) = upper(:tableName)")
	Optional<EntityDetails> findByTableName(String tableName);
}
