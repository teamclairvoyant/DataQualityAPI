package com.cv.dataqualityapi.rest.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cv.dataqualityapi.constants.DataQualityContants;
import com.cv.dataqualityapi.dto.EntityDetailsDto;
import com.cv.dataqualityapi.model.EntityDetails;
import com.cv.dataqualityapi.rest.EntityDetailsRest;
import com.cv.dataqualityapi.service.EntityDetailsService;

@RestController
public class EntityDetailsRestImpl implements EntityDetailsRest{

	@Autowired
	private EntityDetailsService service;
	
	@Override
	public String save(EntityDetailsDto dto) {
		service.save(dto);
		return DataQualityContants.SAVED;
	}

	@Override
	public EntityDetails findById(Integer id) {
		return service.findById(id);
	}

	@Override
	public List<EntityDetails> findAll() {
		return service.findAll();
	}

	@Override
	public EntityDetails update(EntityDetailsDto dto, Integer id) {
		return service.update(dto, id);
	}

	@Override
	public String delete(Integer id) {
        service.delete(id);
        return DataQualityContants.DELETED;
	}

}
