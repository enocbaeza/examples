package com.futbolacademy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idroles", nullable=false)
	private Integer id;
	
	@Column(name="rol", nullable=true)
	private String role;
	
	@Column(name="descrol", nullable=true)
	private String roleDescription;
	
	@ManyToOne
    @JoinColumn(name = "permiso_idpermiso")
    private Permission permission;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String rol) {
		this.role = rol;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String rolDescription) {
		this.roleDescription = rolDescription;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}
}
