package com.angular.controller;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.TransactionRequiredException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.angular.dao.StudentDao;
import com.angular.entity.Student;

@RestController
@RequestMapping(value = "/admin/*")
public class StudentController {

	@Autowired
	private StudentDao dao;	

	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public ResponseEntity<Void> addStudent(@RequestBody Student student) {	
		try{
			dao.saveStudentDetail(student);
		}catch(EntityExistsException ex){
			System.out.println("Student already exists");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/allStudent", method = RequestMethod.GET)
	public ResponseEntity<List<Student>> fetchStudents(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Start ---- Inside fetchStudents");
		
		List<Student> studs = dao.fetchAll();
		
		if(studs.isEmpty()){
			return new ResponseEntity<List<Student>>(HttpStatus.OK);
		}
		System.out.println("Start ---- End fetchStudents");

		return new ResponseEntity<List<Student>>(studs, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deleteStudent/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<List<Student>> deleteStudent(@PathVariable("id") int id) {
		System.out.println("Start ---- Inside deleteStudent" + id);
		List<Student> studs = null;
		try{
			dao.deleteStudent(id);
		
			 studs = dao.fetchAll();
		
			if(studs.isEmpty()){
				return new ResponseEntity<List<Student>>(HttpStatus.OK);
			}
		}
		catch(IllegalArgumentException e){
			
			System.out.println("Inside deleteStudent catch" + id);
			return new ResponseEntity<List<Student>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		System.out.println("End ----- Inside deleteStudent");
		
		return new ResponseEntity<List<Student>>(studs, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/modifyStudent/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> modifyStudent(@PathVariable("id") Integer id ,@RequestBody Student stud) {
		try{
			dao.modifyStudentDetails(stud, id);
		}catch(IllegalArgumentException e){
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
