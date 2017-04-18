package com.skeleton.webproject.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.skeleton.webproject.model.User;

@Transactional
public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByName(String name);
	public User findById(Integer id);
	public List<User> findAll();
}