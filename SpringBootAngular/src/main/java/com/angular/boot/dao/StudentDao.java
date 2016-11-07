package com.angular.boot.dao;

import java.util.List;

import com.angular.boot.entity.Student;

public interface StudentDao {

	public List<Student> fetchAll();

	void deleteStudent(Long id);

	void saveStudentDetail(Student student);

	void modifyStudentDetails(Student student, Long id);

}
