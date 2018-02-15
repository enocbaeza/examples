package com.futbolacademy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estado")
public class Status {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idestado", nullable=false)
	private Integer id;
	
	@Column(name="descestado", nullable=true)
	private String statusDescription;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}
}
