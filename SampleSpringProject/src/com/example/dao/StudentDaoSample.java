package com.example.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.Student;

@Component
public class StudentDaoSample {
  @PersistenceContext	
  private EntityManager entityManager;
  
  @Transactional
  public void saveUserDetail(Student student){
	  entityManager.persist(student);
	  System.out.println("--Data Saved--");
  }
}

