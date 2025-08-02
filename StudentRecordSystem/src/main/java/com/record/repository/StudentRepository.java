package com.record.repository;

import com.record.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//repository interface

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>
{
}
