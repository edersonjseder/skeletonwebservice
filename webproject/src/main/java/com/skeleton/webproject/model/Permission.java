package com.skeleton.webproject.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="permission")
public class Permission implements Serializable {

	private static final long serialVersionUID = 7623381284702861701L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="permission_id")
	private Integer id;
	
	private String name;
	private String description;
	
	@ManyToMany(mappedBy = "permissions")
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
