package com.cv.dataqualityapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRuleSetDto {

	private String rulesetName;

	private String rulesetDesc;
}
