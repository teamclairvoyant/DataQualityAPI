package com.cv.dataqualityapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "rules_type")
public class RulesType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rule_type_id")
	private Integer ruleTypeId;

	@Column(name = "type_name", nullable = false, length = 50)
	private String typeName;

	@Column(name = "rule_name", nullable = false, length = 50)
	private String ruleName;
	
	public RulesType(Integer ruleTypeId, String typeName, String ruleName) {
		super();
		this.ruleTypeId = ruleTypeId;
		this.typeName = typeName;
		this.ruleName = ruleName;
	}

}