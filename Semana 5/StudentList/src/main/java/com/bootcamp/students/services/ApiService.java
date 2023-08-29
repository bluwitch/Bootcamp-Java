package com.bootcamp.students.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bootcamp.students.models.Info;
import com.bootcamp.students.models.Student;
import com.bootcamp.students.repositories.InfoRepository;
import com.bootcamp.students.repositories.StudentRepository;

@Service
public class ApiService {
	private final StudentRepository studentRepository;
	private final InfoRepository infoRepository;

	public ApiService(StudentRepository studentRepository, InfoRepository infoRepository) {
		this.studentRepository = studentRepository;
		this.infoRepository = infoRepository;
	}

	public List<Student> allStudents() {
		return studentRepository.findAll();
	}

	public Student createStudent(Student s) {
		return studentRepository.save(s);
	}

	public Student findStudent(Long id) {
		Optional<Student> optionalStudent = studentRepository.findById(id);
		if (optionalStudent.isPresent()) {
			return optionalStudent.get();
		} else {
			return null;
		}
	}

	public List<Info> allInfos() {
		return infoRepository.findAll();
	}

	public Info createInfo(Info i) {
		return infoRepository.save(i);
	}
}