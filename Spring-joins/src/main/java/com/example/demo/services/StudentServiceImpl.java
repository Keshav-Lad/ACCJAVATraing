package com.example.demo.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repositery.StudentRepositery;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepositery srepo;
	
	@Override
	public List<Student>leftJoin() {
		return srepo.LeftJoin();
	}
	
	@Override
	public List<Student> rightJoin() {
		return srepo.RightJoin();
	}
	
	@Override
	public List<Student> OuterJoin() {
		// TODO Auto-generated method stub
		return srepo.OuterJoin();
	}

	@Override
	public List<Student> InnerJoin() {
		// TODO Auto-generated method stub
		return srepo.InnerJoin();
	}

}
