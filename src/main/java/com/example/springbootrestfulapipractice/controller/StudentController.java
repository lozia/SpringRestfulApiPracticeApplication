package com.example.springbootrestfulapipractice.controller;

import com.example.springbootrestfulapipractice.dto.StudentDto;
import com.example.springbootrestfulapipractice.service.impl.StudentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto){
        StudentDto createdStudent = studentService.createStudent(studentDto);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable long id){
        StudentDto studentDto = studentService.getStudent(id);
        return ResponseEntity.ok(studentDto);
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        List<StudentDto> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @PutMapping("{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable("id") long id, @RequestBody StudentDto studentDto ){
        StudentDto updated = studentService.updateStudent(id, studentDto);
        return new ResponseEntity<>(updated, HttpStatus.ACCEPTED);
    }


    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") long id){
        StudentDto studentDto = studentService.deleteStudent(id);
        return new ResponseEntity<>("Student with id: "+id+" is deleted.", HttpStatus.OK);
    }
}
