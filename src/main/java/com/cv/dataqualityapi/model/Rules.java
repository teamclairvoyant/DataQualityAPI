package com.cv.dataqualityapi.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NamedQueries({
		@NamedQuery(name = "Rules.getAllRulesPks", query = "SELECT new com.cv.dataqualityapi.model.Rules(r.ruleId) from Rules r")})

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "rules")
public class Rules {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rule_id")
	private Integer ruleId;

	@OneToOne
	@JoinColumn(name = "rule_type_id", referencedColumnName = "rule_type_id")
	private RulesType rulesType;

	@Column(name = "source_name", nullable = false, length = 50)
	private String sourceName;

	@Column(name = "column_name", nullable = false, length = 50)
	private String columnName;

	@Column(name = "attributes", nullable = false, length = 50)
	private String attributes;

//	@ManyToMany(mappedBy = "rules")
//	private Set<RuleSet> ruleSet;

	@OneToOne
	@JoinColumn(name = "client_id", referencedColumnName = "client_id")
	private Clients clients;

	@JsonIgnore
	@OneToMany(mappedBy = "rules", cascade = CascadeType.ALL)
	private Set<RuleRuleSet> ruleRuleSet;

	public Rules(Integer ruleId, RulesType rulesType, String sourceName, String columnName, String attributes,
			Clients clients) {
		super();
		this.ruleId = ruleId;
		this.rulesType = rulesType;
		this.sourceName = sourceName;
		this.columnName = columnName;
		this.attributes = attributes;
		this.clients = clients;
	}

	public Rules(Integer ruleId) {
		super();
		this.ruleId = ruleId;
	}
	
	

}