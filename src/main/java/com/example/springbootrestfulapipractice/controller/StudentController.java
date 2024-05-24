package com.example.springbootrestfulapipractice.controller;

import com.example.springbootrestfulapipractice.dto.StudentDto;
import com.example.springbootrestfulapipractice.service.impl.StudentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentService studentService;

//    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto){
        if (studentDto.getEmail().isEmpty() || studentDto.getFirstName().isEmpty() || studentDto.getLastName().isEmpty()){
            return new ResponseEntity<>(studentDto, HttpStatus.NOT_ACCEPTABLE);
        }
        StudentDto createdStudent = studentService.createStudent(studentDto);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

//    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable long id){
        StudentDto studentDto = studentService.getStudent(id);
        return ResponseEntity.ok(studentDto);
    }

//    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        List<StudentDto> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }


//    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable("id") long id, @RequestBody StudentDto studentDto ){
        StudentDto updated = studentService.updateStudent(id, studentDto);
        return new ResponseEntity<>(updated, HttpStatus.ACCEPTED);
    }

//    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") long id){
        StudentDto studentDto = studentService.deleteStudent(id);
        String temp = "a";

        return new ResponseEntity<>("{\"message\": \"Student with id: "+id+" is deleted.\"}", HttpStatus.OK);
    }
}
