package com.javaguides.demoproject_1.controller;

import com.javaguides.demoproject_1.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/all-students")
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1,"Muhammed","Duzgun"));
        studentList.add(new Student(1,"Muhammed","Duzgun"));
        studentList.add(new Student(1,"Muhammed","Duzgun"));
        studentList.add(new Student(1,"Muhammed","Duzgun"));
        studentList.add(new Student(1,"Muhammed","Duzgun"));
        return   ResponseEntity.ok()
                .header("custom-header-name" , "custom-header-value")
                .body(studentList);
    }

    @GetMapping("/all-students/{id}")
    public ResponseEntity<Student>  getStudentById(@PathVariable("id") int studentId) {
        return new ResponseEntity<>(new Student(studentId, "isim_1", "soyisim_1") , HttpStatus.OK);
    }

    @GetMapping("/all-students/query")
    public Student getStudentByQuery(@RequestParam("id") int id) {
        return ResponseEntity.ok(new Student(id, "firstName_2", "lastname_2")).getBody();
    }

    @PostMapping("/save-student")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        return new ResponseEntity<>(student, HttpStatus.OK);
    }




}
