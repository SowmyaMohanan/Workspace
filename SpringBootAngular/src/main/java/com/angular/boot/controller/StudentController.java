package com.angular.boot.controller;

import java.util.List;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.angular.boot.dao.StudentDao;
import com.angular.boot.entity.Student;

@Controller
public class StudentController {

	@Autowired
	private StudentDao dao;

	@RequestMapping(value = "/student")
	public String student() {
		return "student";
	}

	@RequestMapping(value = "/allStudent", method = RequestMethod.GET)
	public ResponseEntity<List<Student>> fetchStudents() {
		System.out.println("Start ---- Inside fetchStudents");
		List<Student> studs = dao.fetchAll();

		if (studs.isEmpty()) {
			return new ResponseEntity<List<Student>>(HttpStatus.OK);
		}
		System.out.println("Start ---- End fetchStudents");

		return new ResponseEntity<List<Student>>(studs, HttpStatus.OK);
	}

	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public ResponseEntity<Void> addStudent(@RequestBody Student student) {

		dao.saveStudentDetail(student);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteStudent/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<List<Student>> deleteStudent(@PathVariable("id") Long id) {
		System.out.println("Start ---- Inside deleteStudent" + id);
		List<Student> studs = null;

		dao.deleteStudent(id);

		studs = dao.fetchAll();

		if (studs.isEmpty()) {
			return new ResponseEntity<List<Student>>(HttpStatus.OK);
		}

		System.out.println("End ----- Inside deleteStudent");

		return new ResponseEntity<List<Student>>(studs, HttpStatus.OK);
	}

	@RequestMapping(value = "/modifyStudent/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> modifyStudent(@PathVariable("id") Long id, @RequestBody Student stud) {

		dao.modifyStudentDetails(stud, id);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
