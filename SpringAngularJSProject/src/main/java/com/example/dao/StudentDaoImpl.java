package com.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.example.Student;

@Component
public class StudentDaoImpl implements StudentDao {
	
  @PersistenceContext	
  private EntityManager entityManager;
  
  @Transactional
  public void saveStudentDetail(Student student){
	  entityManager.persist(student);
	  System.out.println("--Data Saved--");
  }
  
  @SuppressWarnings("unchecked")
public List<Student> fetchAll(){
	  //List<Student> query = (List<Student>) entityManager.createQuery("select s from student s").getResultList();
	  Query query = entityManager.createQuery("select s from Student s");
	  return (List<Student>)query.getResultList();
  }

@Override
public boolean isStudentExists(Student student) {
	Student stud = entityManager.find(Student.class,student.getId());
	if (null == stud){
		return false;
	}
	return true;
}

@Override
@Transactional
public void deleteStudent(int id) {
	Student stud = entityManager.find(Student.class,id);
	if(null != stud){
		entityManager.remove(stud);	
		System.out.println("Deleted");
	}
}

@Override
@Transactional
public void modifyStudentDetails(Student student, Integer id) {
	entityManager.merge(student);
	
}
}

