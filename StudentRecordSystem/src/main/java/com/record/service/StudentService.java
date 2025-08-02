package com.record.service;

import com.record.entity.Student;

import java.util.List;

public interface StudentService {

    String  saveStudent(Student student);

    List<Student> getAllStudent();

    Student getStudentById(int id);

}
