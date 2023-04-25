package com.example.lab07_4.service;

import com.example.lab07_4.exception.ResourceNotFoundException;
import com.example.lab07_4.model.Student;
import com.example.lab07_4.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository repo;

    @Override
    public Student createStudent(Student student) {
        return repo.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        Optional<Student> optionalStudent = repo.findById(student.getId());
        if (optionalStudent.isPresent()) {
            Student updatedStudent = optionalStudent.get();
            updatedStudent.setName(student.getName());
            updatedStudent.setAge(student.getAge());
            updatedStudent.setEmail(student.getEmail());
            updatedStudent.setIeltsScore(student.getIeltsScore());
            return repo.save(updatedStudent);
        }
        throw new ResourceNotFoundException("Not found student with ID=" + student.getId());
    }

    @Override
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    @Override
    public Student getStudentById(long id) {
        Optional<Student> optionalStudent = repo.findById(id);
        if (optionalStudent.isPresent()) {
            return optionalStudent.get();
        }
        throw new ResourceNotFoundException("Not found student with ID=" + id);
    }

    @Override
    public void deleteStudentById(long id) {
        Optional<Student> optionalStudent = repo.findById(id);
        if (optionalStudent.isPresent()) {
            repo.delete(optionalStudent.get());
        } else {
            throw new ResourceNotFoundException("Not found student with ID=" + id);
        }
    }

    // Added functions
    public List<Student> findByAgeGreaterThanOrEqual(int x) {
        return repo.findByAgeGreaterThanOrEqual(x);
    }

    public int countIeltsScoreEqual(int x) {
        return repo.countIeltsScoreEqual(x);
    }

    public List<Student> findByNameContaining(String xxx) {
        return repo.findByNameContaining(xxx);
    }
}
