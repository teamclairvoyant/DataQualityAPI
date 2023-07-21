package com.cv.dataqualityapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRuleTypeDto {
	private String typeName;
	private String ruleName;
}
