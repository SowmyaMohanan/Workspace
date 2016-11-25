package com.spring.boot.mongo.entity;

import org.springframework.data.annotation.Id;


public class Student{
	@Id
	private Long id;

	private Integer age;

	private String name;
		
	public Student() {	
	}
		
	public Student(Long id, Integer age, String name) {
		this.id = id;
		this.age = age;
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + " + age=" + age +"]";
    }
		
}
