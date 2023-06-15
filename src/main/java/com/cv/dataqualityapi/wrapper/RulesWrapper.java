
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

	private String rulesType;

	private String ruleDesc;

	private String ruleName;

	private String entityTable;

	private String properties;

	private String ruleSet;

}
