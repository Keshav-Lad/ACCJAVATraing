package com.example.demo.repositery;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.model.*;

@Repository
public interface StudentRepositery extends JpaRepository<Student,Integer> {
	
	@Query(value="select s ,d from Student s left join Laptop d on s.laptop=d.laptop_id")
	// select s from Student
	public List<Student> LeftJoin();
	
	@Query(value="select s,d from Student s right join Laptop d on s.laptop=d.laptop_id")
	// select s from Student
	public List<Student> RightJoin();
	
	@Query(value="select s,d from Student s Outer join Laptop d on s.laptop=d.laptop_id")
	public List<Student>OuterJoin();
	
	@Query(value="select s,d from Student s INNER join Laptop d on s.laptop=d.laptop_id")
	public List<Student>InnerJoin();
	

}
