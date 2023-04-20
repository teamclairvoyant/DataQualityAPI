package com.cv.dataqualityapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NamedQueries({
	@NamedQuery(name = "RulesType.getRuleType", query = "SELECT rt from RulesType rt where upper(rt.typeName) = upper(:typeName) and upper(rt.ruleName) = upper(:ruleName)"),
	@NamedQuery(name = "RulesType.getRuleTypeByTypeName", query = "SELECT rt from RulesType rt where upper(rt.typeName) = upper(:typeName)"),
	@NamedQuery(name = "RulesType.getTypeCountByTypeName", query = "SELECT count(rt) from RulesType rt where upper(rt.typeName) = upper(:typeName)")
	})

@ApiModel
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "rules_type")
public class RulesType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Rule Type ID", example = "1", required = true) 
	@Column(name = "ruletype_id")
	private Integer ruleTypeId;

	@Column(name = "type_name", nullable = false, length = 50)
	@ApiModelProperty(notes = "Type Name", example = "Some type name", required = false) 
	private String typeName;

	@Column(name = "rule_name", nullable = false, length = 50, unique = true)
	@ApiModelProperty(notes = "Rule Name", example = "Some rule name", required = false) 
	private String ruleName;
	
	public RulesType(Integer ruleTypeId, String typeName, String ruleName) {
		super();
		this.ruleTypeId = ruleTypeId;
		this.typeName = typeName;
		this.ruleName = ruleName;
	}

}