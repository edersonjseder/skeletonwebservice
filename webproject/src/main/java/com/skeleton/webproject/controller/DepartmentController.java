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
import com.skeleton.webproject.model.Department;
import com.skeleton.webproject.repository.DepartmentRepository;

@RequestMapping(value = Path.urls.DEPARTMENT)
@RestController
public class DepartmentController {
	
	/**
	 * Dependency Injection of Spring Framework
	 */
	@Autowired
	private DepartmentRepository departmentRepository;
	
	/**
	 * Method returns the list of departments to the browser via JSON
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Department>> listALL() {
		
		List<Department> departments = departmentRepository.findAll();
		
		if(departments.isEmpty()){
			
			return new ResponseEntity<List<Department>>(HttpStatus.NO_CONTENT);
			
		}
		
		return new ResponseEntity<List<Department>>(departments, HttpStatus.OK);
		
	}
	
	/**
	 * Method returns the department object by its id parameter
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{departmentId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Department> getDepartmentById(@PathVariable Integer departmentId) {

		Department departments = departmentRepository.findOne(departmentId);
		
		if (departments != null) {
		
			return new ResponseEntity<Department>(departments, HttpStatus.OK);
			
		} else {
			
			throw new KeywordNotFoundException(departmentId, Messages.MESSAGE_SEARCH_FAIL);
			
		}
	}
	
	/**
	 * Method saves a department object in the database
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Department> saveDepartment(@RequestBody Department departments) {
		
		departmentRepository.save(departments);
		
		return new ResponseEntity<Department>(departments, HttpStatus.CREATED);
		
	}
	
	/**
	 * Method updates a department object in the database
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/{departmentId}", method = RequestMethod.PUT)
	public @ResponseBody ResponseEntity<Department> update(@PathVariable Integer departmentId, @RequestBody Department departments) {

		Department departmentUpdated = departmentRepository.findOne(departmentId);

		if (departmentUpdated != null) {
			
			departmentUpdated.setName(departments.getName());
			departmentUpdated.setDescription(departments.getDescription());
									
			departmentRepository.save(departmentUpdated);
			
			return new ResponseEntity<Department>(departments, HttpStatus.OK);
			
		} else {
			
			throw new KeywordNotFoundException(departmentId, Messages.MESSAGE_UPDATE_FAIL);
			
		}
	}
	
	/**
	 * Method deletes an department object in the database
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/{departmentId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable Integer departmentId) {

		Department departments = departmentRepository.findOne(departmentId);

		if (departments != null) {

			departmentRepository.delete(departments);

		} else {
			
			throw new KeywordNotFoundException(departmentId, Messages.MESSAGE_DELETE_FAIL);
			
		}
	}

}
