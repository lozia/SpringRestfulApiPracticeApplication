package com.example.springbootrestfulapipractice.service;

import com.example.springbootrestfulapipractice.dto.StudentDto;

import java.util.List;

public interface StudentServiceInterface {
    StudentDto createStudent(StudentDto studentDto);
    StudentDto getStudent(long id);
    List<StudentDto> getAllStudents();
    StudentDto updateStudent(long id, StudentDto studentDto);
    StudentDto deleteStudent(long id);
}
