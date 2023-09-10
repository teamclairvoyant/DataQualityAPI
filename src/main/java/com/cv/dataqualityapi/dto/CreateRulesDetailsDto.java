package com.cv.dataqualityapi.dto;

import java.util.List;
import java.util.Properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRulesDetailsDto {

	private String rulesId;
	
	private String ruleDesc;

	private String ruleName;

	private String ruleDqMetric;

	private List<DataEntityAssociations> dataEntityAssociations;

	private List<PropertiesDto> properties;
}
