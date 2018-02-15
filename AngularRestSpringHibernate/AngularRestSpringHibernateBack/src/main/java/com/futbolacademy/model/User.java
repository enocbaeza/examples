package com.futbolacademy.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idusuarios", nullable=false)
	private Integer id;
	
	@Column(name="nombre", nullable=true)
	private String name;
	
	@Column(name="rut", nullable=true)
	private String rut;
	
	@Column(name="fechanacimiento", nullable=true)
	private Date birthDate;
	
	@Column(name="direccion", nullable=true)
	private String address;
	
	@Column(name="examenaprobado", nullable=true)
	private Boolean isExamApproved;
	
	@ManyToOne
    @JoinColumn(name = "roles_idroles")
    private Role rol;
	
	@ManyToOne
    @JoinColumn(name = "estado_idestado")
    private Status status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getIsExamApproved() {
		return isExamApproved;
	}

	public void setIsExamApproved(Boolean isExamApproved) {
		this.isExamApproved = isExamApproved;
	}

	public Role getRol() {
		return rol;
	}

	public void setRol(Role rol) {
		this.rol = rol;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
