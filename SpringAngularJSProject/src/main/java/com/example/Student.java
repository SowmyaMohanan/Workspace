package com.example;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student{
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "age")
	private Integer age;
	
	@Column(name = "name")
	private String name;
		
	public Student() {	
	}
		
	public Student(Integer id, Integer age, String name) {
		this.id = id;
		this.age = age;
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
