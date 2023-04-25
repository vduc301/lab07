package com.tdtu.lab07_2.service;

import com.tdtu.lab07_2.model.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);
    Student updateStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(long id);
    void deleteStudentById(long id);
}
