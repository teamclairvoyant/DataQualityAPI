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
@Table(name = "clients")
public class Clients {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "client_id")
	private Integer clientId;

	@Column(name = "client_name", nullable = false, length = 100)
	private String clientName;

	public Clients(Integer clientId, String clientName) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
	}

}