package com.example.demo.services;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentService {
	
	public List<Student> leftJoin();
	public List<Student> rightJoin();
	public List<Student> OuterJoin();
	public List<Student> InnerJoin();
	

}
