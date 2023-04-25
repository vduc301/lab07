package com.tdtu.lab07_2.repository;

import com.tdtu.lab07_2.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
