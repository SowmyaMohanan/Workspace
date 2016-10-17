package com.example.controller;

import java.util.List;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.Student;
import com.example.dao.StudentDao;
import com.google.gson.Gson;

@RestController
@RequestMapping(value = "/admin/*")
public class StudentController {

	@Autowired
	private StudentDao dao;

	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public ModelAndView student() {
		return new ModelAndView("student", "command", new Student());
	}

	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public ResponseEntity<Void> addStudent(@RequestBody Student student) {		
		if(!dao.isStudentExists(student)){
			dao.saveStudentDetail(student);
		}else{
			System.out.println("Student already exists");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/addStudent", method = RequestMethod.GET)
	public ResponseEntity<List<Student>> fetchStudents(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Start ---- Inside fetchStudents");
		List<Student> studs = dao.fetchAll();
		
		if(studs.isEmpty()){
			return new ResponseEntity<List<Student>>(HttpStatus.OK);
		}
		System.out.println("Start ---- End fetchStudents");

		return new ResponseEntity<List<Student>>(studs, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addStudent/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteStudent(@PathVariable("id") int id) {
		System.out.println("Start ---- Inside deleteStudent" + id);
		try{
		dao.deleteStudent(id);
		}
		catch(Exception e){
			
			e.printStackTrace();
		}
		System.out.println("End ----- Inside deleteStudent");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addStudent/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> modifyStudent(@PathVariable("id") Integer id ,@RequestBody Student stud) {
		
		dao.modifyStudentDetails(stud, id);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
