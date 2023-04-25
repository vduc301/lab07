package com.example.lab07_4.repository;

import com.example.lab07_4.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "SELECT * FROM student WHERE age >= :x", nativeQuery = true)
    public List<Student> findByAgeGreaterThanOrEqual(int x);

    @Query(value = "SELECT COUNT(*) FROM student WHERE ielts_score = :x", nativeQuery = true)
    public int countIeltsScoreEqual(int x);

    @Query(value = "SELECT * FROM student WHERE LOWER(name) LIKE LOWER(concat('%', :xxx, '%'))", nativeQuery = true)
    public List<Student> findByNameContaining(String xxx);
}
