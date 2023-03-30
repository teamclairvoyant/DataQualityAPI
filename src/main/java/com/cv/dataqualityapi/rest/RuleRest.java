package com.cv.dataqualityapi.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cv.dataqualityapi.model.Rules;

@RequestMapping("/Rule")
public interface RuleRest {

	@GetMapping(value = "createRule")
	public String createRule(@RequestBody Rules rule);

	@GetMapping(value = "getRules")
	public String getRules();
	
}
