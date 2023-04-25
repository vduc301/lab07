package com.example.lab07_4.service;

import com.example.lab07_4.model.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);
    Student updateStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(long id);
    void deleteStudentById(long id);

}
