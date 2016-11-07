package com.angular.boot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.angular.boot.entity.Student;
import com.angular.boot.repository.StudentRepository;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private StudentRepository studentRep;

	@Override
	@Transactional
	public void saveStudentDetail(Student student) {
		studentRep.saveAndFlush(student);
		System.out.println("--Data Saved--");
	}

	@Override
	@Transactional(readOnly = true)
	public List<Student> fetchAll() {
		return (List<Student>) studentRep.findAll();
	}


	@Override
	@Transactional
	public void deleteStudent(Long id) {
		Student stud = studentRep.findOne(id);
		if (null != stud) {
			studentRep.delete(stud);
			System.out.println("Deleted");
		}
	}

	@Override
	@Modifying
	public void modifyStudentDetails(Student student, Long id) {
		Student stud = studentRep.findOne(id);
		if (null != stud) {
			stud.setAge(student.getAge());
			stud.setName(student.getName());
			studentRep.saveAndFlush(stud);
			System.out.println("Updated");
		}

	}
}
