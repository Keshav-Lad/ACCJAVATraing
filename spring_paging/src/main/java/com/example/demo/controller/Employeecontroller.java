package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeServiceImpl;
    
@RestController
public class Employeecontroller {
	
	@Autowired
	private EmployeeServiceImpl empl;
	
	@GetMapping("/getall/{pageno}/{pagesize}")
	public List<Employee>getData(@PathVariable("pageno") int pageno,@PathVariable("pagesize") int pagesize){
		List<Employee>ans= empl.findPaging(pageno, pagesize);
		
		return ans;
	}
	@GetMapping("/getall/{pageno}/{pagesize}/{title}")
	public List<Employee>getDataByTitle(@PathVariable("pageno") int pageno,@PathVariable("pagesize") int pagesize,@PathVariable("title") String title){
		List<Employee>ans= empl.findByTitle(pageno, pagesize,title);
		
		return ans;
	}
	@GetMapping("/getall")
	public List<Employee>getDataByCountry(@RequestParam int pageno ,@RequestParam int pagesize ,@RequestParam String Country){
		List<Employee>ans= empl.findByCountry(pageno,pagesize,Country);
		return ans;
	}

}
