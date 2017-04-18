package com.skeleton.webproject.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.skeleton.webproject.model.Department;

@Transactional
public interface DepartmentRepository extends CrudRepository<Department, Integer> {

	public Department findByName(String name);
	public Department findById(Integer id);
	public List<Department> findAll();
}