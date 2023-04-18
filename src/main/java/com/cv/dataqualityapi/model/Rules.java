package com.cv.dataqualityapi.model;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NamedQueries({
		@NamedQuery(name = "Rules.getAllRulesPks", query = "SELECT new com.cv.dataqualityapi.model.Rules(r.ruleId) from Rules r"),
		@NamedQuery(name = "Rules.getRuleCount", query = "SELECT count(r) from Rules r JOIN r.clients c JOIN r.rulesType rt where UPPER(rt.typeName) = UPPER(:typeName) and UPPER(r.ruleDesc) = UPPER(:ruleDesc) and UPPER(r.tableName) = UPPER(:tableName) and UPPER(r.columnName) = UPPER(columnName) and UPPER(r.columnValue) = UPPER(:columnValue) and UPPER(r.sourceName) = UPPER(sourceName) and UPPER(c.clientName) = UPPER(:clientName)"),
		@NamedQuery(name = "Rules.getRules", query = "SELECT r from Rules r JOIN r.clients c JOIN r.rulesType rt where UPPER(rt.typeName) = UPPER(:typeName) and UPPER(r.ruleDesc) = UPPER(:ruleDesc) and UPPER(r.tableName) = UPPER(:tableName) and UPPER(r.columnName) = UPPER(:columnName) and UPPER(r.columnValue) = UPPER(:columnValue) and UPPER(r.sourceName) = UPPER(:sourceName) and UPPER(c.clientName) = UPPER(:clientName)") })

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
	@JoinColumn(name = "ruletype_id", referencedColumnName = "ruletype_id")
	private RulesType rulesType;

	// newly added
	@Column(name = "rule_desc", nullable = false, length = 100)
	private String ruleDesc;

	// newly added
	@Column(name = "table_name", nullable = false, length = 50)
	private String tableName;

	@Column(name = "column_name", nullable = false, length = 50)
	private String columnName;

	// newly added
	@Column(name = "column_value", nullable = false, length = 50)
	private String columnValue;

	@Column(name = "source_name", nullable = false, length = 50)
	private String sourceName;

//	@Column(name = "attributes", nullable = false, length = 50)
//	private String attributes;

//	@ManyToMany(mappedBy = "rules")
//	private Set<RuleSet> ruleSet;

	@OneToOne
	@JoinColumn(name = "client_id", referencedColumnName = "client_id")
	private Clients clients;

	@JsonIgnore
	@OneToMany(mappedBy = "rules", cascade = CascadeType.ALL)
	private Set<RuleRuleSet> ruleRuleSet;

	@Column(name = "created_ts")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTs;

	@Column(name = "updated_ts")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedTs;

	@Column(name = "created_by", length = 100)
	private String createdBy;

	@Column(name = "updated_by", length = 100)
	private String updatedBy;

	public Rules(Integer ruleId) {
		super();
		this.ruleId = ruleId;
	}

	public Rules(Integer ruleId, RulesType rulesType, String ruleDesc, String tableName, String columnName,
			String columnValue, String sourceName, Clients clients, Set<RuleRuleSet> ruleRuleSet, Date createdTs,
			Date updatedTs, String createdBy, String updatedBy) {
		super();
		this.ruleId = ruleId;
		this.rulesType = rulesType;
		this.ruleDesc = ruleDesc;
		this.tableName = tableName;
		this.columnName = columnName;
		this.columnValue = columnValue;
		this.sourceName = sourceName;
		this.clients = clients;
		this.ruleRuleSet = ruleRuleSet;
		this.createdTs = createdTs;
		this.updatedTs = updatedTs;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

}