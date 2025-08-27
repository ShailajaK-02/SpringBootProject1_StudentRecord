package com.record.serviceImpl;

import com.record.entity.Student;
import com.record.repository.StudentRepository;
import com.record.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//service implementation

@Service
public class StudentServiceImpl implements StudentService
{
    @Autowired
    private StudentRepository repository;

    //save student method implemented
    @Override
    public String saveStudent(Student student) {
        Student saveStudent = repository.save(student);
        return "Student added successfully";
    }

    //getalldata method implemented
    @Override
    public List<Student> getAllStudent() {
        List<Student> studentList = repository.findAll();
        return studentList;
    }

    //getbyid method implemented
    @Override
    public Student getStudentById(int id) {
        Student stuById = repository.findById(id).orElseThrow(()-> new NullPointerException("Student with id not found "+id));
        return stuById;
    }

    //delete method implemented
    @Override
    public String deleteStudent(int id) {
        repository.deleteById(id);
        return "Student deleted";
    }

    //update method implemented
    @Override
    public Student updateStu(int id, Student newStu) {
       Student student = repository.findById(id).orElseThrow(()->new NullPointerException("Data not found"+id));

       student.setName(newStu.getName());
       student.setMarks(newStu.getMarks());

       Student updatedStu = repository.save(student);
       return  updatedStu;
    }

    @Override
    public Student stuWithEmail(String email) {
        Student student = repository.findStuByEmail(email);
        return student;
    }
}
