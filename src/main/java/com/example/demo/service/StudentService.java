package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Student saveStudent(Student student) {

		Student savedStudent = studentRepository.save(student);
		return savedStudent;
	}

	public Student findbyId(String id) {
		Student student = studentRepository.findById(id).get();
		return student;
	}
	
	public Student findByNameAndEmail(String name,String email) {
		Student findByNameAndEmail = studentRepository.findByNameAndEmail(name, email);
		return findByNameAndEmail;
	}
	
	public List<Student> getStudentsPagination(int pagenumber,int pagesize) {
		Pageable pageable = PageRequest.of(pagenumber-1, pagesize);
		return studentRepository.findAll(pageable).getContent();
	}
	
	public List<Student> sortByParam(String param) {
		Sort sort= Sort.by(Sort.Direction.ASC, param);
		
		return studentRepository.findAll(sort);
	}
	
	public List<Student> getStudentsByDepartmentName(String departmentName){
		return studentRepository.findByDepartmentDepartmentName(departmentName);
	}
	
	public List<Student> getStudentsBySubjectName(String subjectName){
		return studentRepository.findAllBySubjectsSubjectName(subjectName);
	}
	
	public List<Student> getStudentsMatchingEmailLike(String email){
		return studentRepository.findAllByEmailIsLike(email);
	}
	
	
	public List<Student> getAllStudentswithNameStartsWith(String name){
		return studentRepository.findAllByNameStartsWith(name);
	}
	
	
	
	public void deleteById(String id) {
		studentRepository.deleteById(id);
	}
}
