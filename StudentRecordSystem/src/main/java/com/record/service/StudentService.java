package com.record.service;

import com.record.entity.Student;

import java.util.List;
//service interface

public interface StudentService {

    //save method
    String  saveStudent(Student student);

    //get all student method
    List<Student> getAllStudent();

    //get by id method
    Student getStudentById(int id);

    //delete student
    String deleteStudent(int id);

    Student updateStu(int id, Student newStu);

}
