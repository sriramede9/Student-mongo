package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

	Student findByNameAndEmail(String name,String email);
	
	List<Student> findByDepartmentDepartmentName(String departmentName);
	
	List<Student> findAllBySubjectsSubjectName(String subjectName);
	
	List<Student> findAllByEmailIsLike(String email);
	
	List<Student> findAllByNameStartsWith(String name);
	
}
