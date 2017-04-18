package com.skeleton.webproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.skeleton.webproject.endpoint.Path;
import com.skeleton.webproject.exceptions.KeywordNotFoundException;
import com.skeleton.webproject.messages.Messages;
import com.skeleton.webproject.model.User;
import com.skeleton.webproject.repository.UserRepository;

@RequestMapping(value = Path.urls.USER)
@RestController
public class UserController {
	
	/**
	 * Dependency Injection of Spring Framework
	 */
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * Method returns the list of users to the browser via JSON
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> listALL() {
		
		List<User> users = userRepository.findAll();
		
		if(users.isEmpty()){
			
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
			
		}
		
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		
	}
	
	/**
	 * Method returns the user object by its id parameter
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUserById(@PathVariable Integer userId) {

		User users = userRepository.findOne(userId);
		
		if (users != null) {
		
			return new ResponseEntity<User>(users, HttpStatus.OK);
			
		} else {
			
			throw new KeywordNotFoundException(userId, Messages.MESSAGE_SEARCH_FAIL);
			
		}
	}
	
	/**
	 * Method saves an user object in the database
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<User> saveUser(@RequestBody User users) {
		
		userRepository.save(users);
		
		return new ResponseEntity<User>(users, HttpStatus.CREATED);
		
	}
	
	/**
	 * Method updates an user object in the database
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
	public @ResponseBody ResponseEntity<User> updateUserInfo(@PathVariable Integer userId, @RequestBody User users) {

		User userUpdated = userRepository.findOne(userId);

		if (userUpdated != null) {
			
			userUpdated.setName(users.getName());
			userUpdated.setDescription(users.getDescription());
									
			userRepository.save(userUpdated);
			
			return new ResponseEntity<User>(users, HttpStatus.OK);
			
		} else {
			
			throw new KeywordNotFoundException(userId, Messages.MESSAGE_UPDATE_FAIL);
			
		}
	}
	
	/**
	 * Method deletes an user object in the database
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable Integer userId) {

		User users = userRepository.findOne(userId);

		if (users != null) {

			userRepository.delete(users);

		} else {
			
			throw new KeywordNotFoundException(userId, Messages.MESSAGE_DELETE_FAIL);
			
		}
	}

}
