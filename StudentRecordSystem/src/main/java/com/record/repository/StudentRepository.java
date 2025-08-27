package com.record.repository;

import com.record.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//repository interface
//In this interface we can create custom methods and call it from serviceimpl which contains jpql queries and native queries
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>
{
    //jpql query to get student with email
    @Query("SELECT s from Student s WHERE s.email = :email")
    Student findStuByEmail(@Param("email") String email);
}
