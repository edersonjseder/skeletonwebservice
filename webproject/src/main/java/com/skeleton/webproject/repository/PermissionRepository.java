package com.skeleton.webproject.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.skeleton.webproject.model.Permission;

@Transactional
public interface PermissionRepository extends CrudRepository<Permission, Integer> {

	public Permission findByName(String name);
	public Permission findById(Integer id);
	public List<Permission> findAll();
}