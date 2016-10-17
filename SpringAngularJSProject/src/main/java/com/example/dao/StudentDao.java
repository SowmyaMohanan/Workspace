package com.example.dao;

import java.util.List;

import com.example.Student;

public interface StudentDao {
	
	public void saveStudentDetail(Student student);
	
	public List<Student> fetchAll();
	
	public boolean isStudentExists(Student student);
	
	public void deleteStudent(int id);
	
	public void modifyStudentDetails(Student student, Integer id);
}
