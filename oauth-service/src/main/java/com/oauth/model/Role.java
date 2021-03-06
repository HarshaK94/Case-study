package com.oauth.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name="role_id")
	private Integer roleId;
	
	@Column(name="name")
	private String name;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="permission_role" ,joinColumns = {
			@JoinColumn(name="role_id",referencedColumnName = "role_id")},inverseJoinColumns = {
			@JoinColumn(name="permission_id",referencedColumnName = "permission_id")})
	private List<Permission> permissions;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	
	

}
