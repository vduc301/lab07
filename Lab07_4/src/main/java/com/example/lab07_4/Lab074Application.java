package com.example.lab07_4;

import com.example.lab07_4.model.Student;
import com.example.lab07_4.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab074Application implements CommandLineRunner {
	@Autowired
	StudentServiceImpl studentService;

	public static void main(String[] args) {
		SpringApplication.run(Lab074Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Test findByAgeGreaterOrEqual:");
		studentService.findByAgeGreaterThanOrEqual(11).forEach(student -> System.out.println(student));

		System.out.println("Test countIeltsScoreEqual:");
		System.out.println(studentService.countIeltsScoreEqual(6));

		System.out.println("Test findByNameContaining:");
		studentService.findByNameContaining("Van").forEach(student -> System.out.println(student));

	}
}
