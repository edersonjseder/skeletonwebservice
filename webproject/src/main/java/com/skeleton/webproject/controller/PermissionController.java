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
import com.skeleton.webproject.model.Permission;
import com.skeleton.webproject.repository.PermissionRepository;

@RequestMapping(value = Path.urls.PERMISSION)
@RestController
public class PermissionController {
	
	/**
	 * Dependency Injection of Spring Framework
	 */
	@Autowired
	private PermissionRepository permissionRepository;
	
	/**
	 * Method returns the list of permissions to the browser via JSON
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Permission>> listALL() {
		
		List<Permission> permissions = permissionRepository.findAll();
		
		if(permissions.isEmpty()){
			
			return new ResponseEntity<List<Permission>>(HttpStatus.NO_CONTENT);
			
		}
		
		return new ResponseEntity<List<Permission>>(permissions, HttpStatus.OK);
		
	}
	
	/**
	 * Method returns the permission object by its id parameter
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{permissionId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Permission> getPermissionById(@PathVariable Integer permissionId) {

		Permission permissions = permissionRepository.findOne(permissionId);
		
		if (permissions != null) {
		
			return new ResponseEntity<Permission>(permissions, HttpStatus.OK);
			
		} else {
			
			throw new KeywordNotFoundException(permissionId, Messages.MESSAGE_SEARCH_FAIL);
			
		}
	}
	
	/**
	 * Method saves a permission object in the database
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Permission> createPermission(@RequestBody Permission permissions) {
		
		permissionRepository.save(permissions);
		
		return new ResponseEntity<Permission>(permissions, HttpStatus.CREATED);
		
	}
	
	/**
	 * Method updates a permission object in the database
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/{permissionId}", method = RequestMethod.PUT)
	public @ResponseBody ResponseEntity<Permission> updatePermission(@PathVariable Integer permissionId, @RequestBody Permission permissions) {

		Permission permissionUpdated = permissionRepository.findOne(permissionId);

		if (permissionUpdated != null) {
			
			permissionUpdated.setName(permissions.getName());
			permissionUpdated.setDescription(permissions.getDescription());
									
			permissionRepository.save(permissionUpdated);
			
			return new ResponseEntity<Permission>(permissions, HttpStatus.OK);
			
		} else {
			
			throw new KeywordNotFoundException(permissionId, Messages.MESSAGE_UPDATE_FAIL);
			
		}
	}
	
	/**
	 * Method deletes an permission object in the database
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/{permissionId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable Integer permissionId) {

		Permission permissions = permissionRepository.findOne(permissionId);

		if (permissions != null) {

			permissionRepository.delete(permissions);

		} else {
			
			throw new KeywordNotFoundException(permissionId, Messages.MESSAGE_DELETE_FAIL);
			
		}
	}

}
