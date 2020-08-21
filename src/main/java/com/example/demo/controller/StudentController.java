package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Department;
import com.example.demo.model.Student;
import com.example.demo.model.Subject;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/createStudent")
	public Student createStudent(@RequestBody Student student) {

		Student saveStudent = studentService.saveStudent(student);
		return saveStudent;

	}

	@GetMapping("/sampleStudent")
	public Student createSampleStudent() {

		Student student = new Student();
		student.setName("Sri");
		student.setEmail("test@gmail.com");
		Department dep = new Department();
		dep.setDepartmentName("Math");
		dep.setLocation("New York");
		student.setDepartment(dep);

		Subject sub = new Subject();
		sub.setSubjectName("Trigno");
		sub.setMarksObtained(97d);

		Subject sub2 = new Subject();
		sub2.setSubjectName("calculus");
		sub2.setMarksObtained(67d);

		student.setSubjects(Arrays.asList(sub, sub2));

		Student saveStudent = studentService.saveStudent(student);
		return saveStudent;
	}

	@GetMapping("/Student/{id}")
	public Student findStudentbyId(@PathVariable("id") String id) {
		return studentService.findbyId(id);
	}
	
	@GetMapping("/Student/name/{name}/email/{email}")
	public Student findByNameAndEmail(@PathVariable("name") String name, @PathVariable("email") String email) {
		
		return studentService.findByNameAndEmail(name, email);
	}
	
	//pagination
	
	@GetMapping("/Students/pagination/{pagenumber}/{pagesize}")
	public List<Student> getAllwithPagination(@PathVariable("pagenumber") int pagenumber,@PathVariable("pagesize") int pagesize) {
		return studentService.getStudentsPagination(pagenumber, pagesize);
	}
	
	//sorting
	
	@GetMapping("/Student/sortby/{param}")
	public List<Student> SortByName(@PathVariable("param") String param) {
			return studentService.sortByParam(param);
	}
	
	//sub documents
	@GetMapping("/Student/department/{departmentname}")
	public List<Student> getStudentByDepartmentName(@PathVariable("departmentname") String departmentName) {
		return studentService.getStudentsByDepartmentName(departmentName);
	}
	
	@GetMapping("/Student/subject/{subjectname}")
	public List<Student> getStudentBySubjectName(@PathVariable("subjectname") String subjectName) {
		return studentService.getStudentsBySubjectName(subjectName);
	}
	
	//like operator
	
	@GetMapping("/Students/like/{like}")
	public List<Student> getStudentByMathingLikeOperators(@PathVariable("like") String like) {
		return studentService.getStudentsMatchingEmailLike(like);
	}
	
	//startswith
	
	@GetMapping("/Students/startsWith/{name}")
	public List<Student> getAllStudentsNameStartsWith(@PathVariable("name") String name) {
		return studentService.getAllStudentswithNameStartsWith(name);
	}
	
	
	@DeleteMapping("/Student/delete/{id}")
	public void deleteById(@PathVariable("id") String id) {
		studentService.deleteById(id);
	}
}
