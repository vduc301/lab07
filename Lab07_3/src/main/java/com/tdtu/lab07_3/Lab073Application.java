package com.tdtu.lab07_3;

import com.tdtu.lab07_3.model.Student;
import com.tdtu.lab07_3.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab073Application implements CommandLineRunner {
    @Autowired
    StudentServiceImpl studentService;

    public static void main(String[] args) {
        SpringApplication.run(Lab073Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        studentService.createStudent(new Student("A", 10, "a@gmail.com", 6.0));
        studentService.createStudent(new Student("B", 11, "b@gmail.com", 7.0));
        studentService.createStudent(new Student("C", 12, "c@gmail.com", 8.0));

        System.out.println("Student list:");
        studentService.getAllStudents().forEach(s -> System.out.println(s));

        System.out.println("Update ielts score of C from 8.0 to 9.0:");
        System.out.println(studentService.updateStudent(new Student(3, "C", 12, "c@gmail.com", 9.0)));

        System.out.println("Delete student with ID=2:");
        studentService.deleteStudentById(2);
        System.out.println("Student list after deleted:");
        studentService.getAllStudents().forEach(s -> System.out.println(s));
    }
}
