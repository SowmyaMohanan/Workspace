package com.example.dao;

import java.util.List;

import com.example.Student;

public interface StudentDao {
	
	public void saveUserDetail(Student student);
	
	public List<Student> fetchAll();
}
