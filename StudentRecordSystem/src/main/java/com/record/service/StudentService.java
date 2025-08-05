package com.record.service;

import com.record.entity.Student;

import java.util.List;
//service interface

public interface StudentService {

    //save method
    String  saveStudent(Student student);

    List<Student> getAllStudent();

    Student getStudentById(int id);

    String deleteStudent(int id);

    Student updateStu(int id, Student newStu);

}
