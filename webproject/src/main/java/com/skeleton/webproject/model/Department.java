package com.skeleton.webproject.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="department")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Department implements Serializable {

	private static final long serialVersionUID = 7623308794702861701L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="department_id")
	private Integer id;
	
	private String name;
	private String description;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy = "department")
	private List<User> users;

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

	// It's the back part of reference – it will be omitted from serialization, avoiding infinite recursion
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
