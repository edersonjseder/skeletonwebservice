package com.skeleton.webproject.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="user")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class User implements Serializable{

	private static final long serialVersionUID = 614272395617021758L;
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private Integer id;
	
	private String name;
	private String description;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "department_id")
	private Department department;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "user_permissions", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"), inverseJoinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "permission_id"))
	private List<Permission> permissions;
	

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// It's the forward part of reference – the one that gets serialized normally
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	

}
