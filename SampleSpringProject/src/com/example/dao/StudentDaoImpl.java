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
  public void saveUserDetail(Student student){
	  entityManager.persist(student);
	  System.out.println("--Data Saved--");
  }
  
  @SuppressWarnings("unchecked")
public List<Student> fetchAll(){
	  //List<Student> query = (List<Student>) entityManager.createQuery("select s from student s").getResultList();
	  Query query = entityManager.createQuery("select s from Student s");
	  return (List<Student>)query.getResultList();
  }
}

