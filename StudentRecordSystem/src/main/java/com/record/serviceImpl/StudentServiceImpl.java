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

    @Override
    public String saveStudent(Student student) {
        Student saveStudent = repository.save(student);
        return "Student added successfully";
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> studentList = repository.findAll();
        return studentList;
    }

    @Override
    public Student getStudentById(int id) {
        Student stuById = repository.findById(id).orElseThrow(()-> new NullPointerException("Student with id not found "+id));
        return stuById;
    }

    @Override
    public String deleteStudent(int id) {
        repository.deleteById(id);
        return "Student deleted";
    }

    @Override
    public Student updateStu(int id, Student newStu) {
       Student student = repository.findById(id).orElseThrow(()->new NullPointerException("Data not found"+id));

       student.setName(newStu.getName());
       student.setMarks(newStu.getMarks());

       Student updatedStu = repository.save(student);
       return  updatedStu;
    }
}
