package com.record.controller;

import com.record.entity.Student;
import com.record.service.StudentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//controller class(api/endpints)
@RestController
@RequestMapping("/student")
public class StudentController {

    //create global object of service interface in controller we are injecting service interface in controller
    @Autowired
    private StudentService studentService;

    //api to add data into database
    @PostMapping("/addStudent")
    public ResponseEntity<String> addStudent(@RequestBody Student student){
        System.err.println(student);
        studentService.saveStudent(student);
        return new ResponseEntity<>("Student added", HttpStatus.CREATED);
    }

    //api to get all data
    @GetMapping("/getAllData")
    public ResponseEntity<List<Student>> allStudentData(){
        List<Student> studentList = studentService.getAllStudent();
        return  new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    //Get Data by id api 
    @GetMapping("/getById/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") int id){
        Student student= studentService.getStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
}
