package com.example.springbootrestfulapipractice.mapper;

import com.example.springbootrestfulapipractice.dto.StudentDto;
import com.example.springbootrestfulapipractice.entity.Student;

public class StudentMapper {
    public static StudentDto mapToStudentDto(Student student){
        return new StudentDto(student.getId(), student.getFirstName(), student.getLastName(), student.getEmail());
    }

    public static Student mapToStudent(StudentDto sdto){
        return new Student(sdto.getId(), sdto.getFirstName(), sdto.getLastName(), sdto.getEmail());
    }
}
