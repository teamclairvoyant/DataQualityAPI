package com.cv.dataqualityapi.service;

import java.util.List;
import java.util.Optional;

import com.cv.dataqualityapi.dto.EntityDetailsDto;
import com.cv.dataqualityapi.model.EntityDetails;

public interface EntityDetailsService {

	EntityDetails save(EntityDetailsDto dto);

	EntityDetails findById(Integer id);

	List<EntityDetails> findAll();
	
	EntityDetails update(EntityDetailsDto dto,Integer id);
	
	void delete(Integer id);
	
	EntityDetails findByTableName(String tableName);

}
