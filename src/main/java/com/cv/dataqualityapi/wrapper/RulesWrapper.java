package com.cv.dataqualityapi.wrapper;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class RulesWrapper {

	private Integer ruleId;

	private String attributes;

	private String columnName;

	private String sourceName;

//	private Integer clientId;
	
	private String clientName;

//	private Integer rulesTypeId;
	
	private String typeName;

}
