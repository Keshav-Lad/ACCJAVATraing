package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repositery.EmpRepositery;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmpRepositery emprepo;

	@Override
	public List<Employee> findPaging(int pageno,int pagesize) {
		Pageable page=PageRequest.of(pageno,pagesize,Sort.by("id").descending());
		Page<Employee>ans=emprepo.findAll(page);
		return ans.toList();
	}

	@Override
	public List<Employee> findByTitle(int pageno, int pagesize,String title) {
		Pageable titlepage=PageRequest.of(pageno,pagesize,Sort.by(title).descending());
		Page<Employee>ans=emprepo.findAll(titlepage);
		return ans.toList();
	}

	@Override
	public List<Employee> findByCountry(int page, int pagesize,String title) {
		Pageable country=PageRequest.of(page, pagesize);
		Page<Employee>ans=emprepo.findByCountry(title,country);
		return ans.toList();
	}


}
