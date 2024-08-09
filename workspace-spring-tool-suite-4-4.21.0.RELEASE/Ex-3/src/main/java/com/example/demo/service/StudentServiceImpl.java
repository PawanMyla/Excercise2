package com.example.demo.service;
import com.example.demo.Student;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

	@Override
	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<>();
		students.add(new Student("John Doe" , "Robert Doe","2001-01-01","Male"));
		students.add(new Student("Jane Doe" , "Robert Doe","2001-01-01","female"));
		return students;
		
	}

}
