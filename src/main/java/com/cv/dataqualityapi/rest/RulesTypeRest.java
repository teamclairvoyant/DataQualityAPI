package com.cv.dataqualityapi.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cv.dataqualityapi.model.RulesType;

@RequestMapping("/RulesType")
public interface RulesTypeRest {

	@PostMapping(value = "createRulesType")
	public String createRulesType(@RequestBody RulesType rulesType) throws Exception;

	@GetMapping(value = "getRulesType")
	public List<RulesType> getRulesType();
	
	@PostMapping(value = "deleteRulesType")
	public String deleteRulesType(@RequestBody RulesType rulesType) throws Exception;

	@PostMapping(value = "updateRulesType")
	String updateRulesType(@RequestBody RulesType rulesType) throws Exception;
	
	
}
