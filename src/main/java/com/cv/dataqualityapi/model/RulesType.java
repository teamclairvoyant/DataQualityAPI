package com.cv.dataqualityapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NamedQueries({
	@NamedQuery(name = "RulesType.getRuleType", query = "SELECT rt from RulesType rt where upper(rt.typeName) = upper(:typeName) and upper(rt.ruleName) = upper(:ruleName)"),
	@NamedQuery(name = "RulesType.getRuleTypeByTypeName", query = "SELECT rt from RulesType rt where upper(rt.typeName) = upper(:typeName)"),
	@NamedQuery(name = "RulesType.getTypeCountByTypeName", query = "SELECT count(rt) from RulesType rt where upper(rt.typeName) = upper(:typeName)")
	})

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "rules_type")
public class RulesType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ruletype_id")
	private Integer ruleTypeId;

	@Column(name = "type_name", nullable = false, length = 50)
	private String typeName;

	@Column(name = "rule_name", nullable = false, length = 50, unique = true)
	private String ruleName;
	
	public RulesType(Integer ruleTypeId, String typeName, String ruleName) {
		super();
		this.ruleTypeId = ruleTypeId;
		this.typeName = typeName;
		this.ruleName = ruleName;
	}

}