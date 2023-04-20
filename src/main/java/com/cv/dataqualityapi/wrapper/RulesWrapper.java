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

//	private String attributes;

	// present in the rule_type table
	private String typeName;

	// newly added
	private String ruleDesc;

	// newly added
	private String tableName;

	private String columnName;

	// newly added
	private String columnValue;

	private String sourceName;

//	private Integer clientId;

	private String clientName;

//	private Integer rulesTypeId;

}
