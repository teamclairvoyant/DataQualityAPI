package com.cv.dataqualityapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cv.dataqualityapi.dao.EntityDetailsRepository;
import com.cv.dataqualityapi.dto.EntityDetailsDto;
import com.cv.dataqualityapi.exception.ResourceNotFoundException;
import com.cv.dataqualityapi.model.EntityDetails;
import com.cv.dataqualityapi.service.EntityDetailsService;
import com.cv.dataqualityapi.utils.DTOUtils;

@Service
public class EntityDetailsServiceImpl implements EntityDetailsService{

	@Autowired
	private EntityDetailsRepository repository;
	
	@Override
	public EntityDetails save(EntityDetailsDto dto) {
		EntityDetails entity = new EntityDetails();
		BeanUtils.copyProperties(dto, entity);
		return repository.save(entity);
	}

	@Override
	public EntityDetails findById(Integer id) {
		Optional<EntityDetails> data = repository.findById(id);
		if(data.isEmpty()) {
			throw new ResourceNotFoundException("entity details not found");
		}
		
		return data.get();
	}

	@Override
	public List<EntityDetails> findAll() {
		return repository.findAll();
	}

	@Override
	public EntityDetails update(EntityDetailsDto dto, Integer id) {
		EntityDetails entityDetails = findById(id);
		DTOUtils.copyPropertiesIgnoringNull(dto, entityDetails);
		System.out.println("the converted target object is:"+entityDetails);
		return repository.save(entityDetails);
	}

	@Override
	public void delete(Integer id) {
		   EntityDetails entityDetails =  this.findById(id);
           repository.delete(entityDetails);		
	}

	@Override
	public EntityDetails findByTableName(String tableName) {
		Optional<EntityDetails> entityDetailsOp = repository.findByTableName(tableName);
		if(entityDetailsOp.isEmpty())
			throw new ResourceNotFoundException("entity not present");
		
		return entityDetailsOp.get();
	}

}
