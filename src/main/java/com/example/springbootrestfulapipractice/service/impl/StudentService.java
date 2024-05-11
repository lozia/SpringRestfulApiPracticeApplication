package com.example.springbootrestfulapipractice.service.impl;

import com.example.springbootrestfulapipractice.dto.StudentDto;
import com.example.springbootrestfulapipractice.entity.Student;
import com.example.springbootrestfulapipractice.exception.CannotFindElement;
import com.example.springbootrestfulapipractice.mapper.StudentMapper;
import com.example.springbootrestfulapipractice.repository.StudentRepository;
import com.example.springbootrestfulapipractice.service.StudentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class StudentService implements StudentServiceInterface {
    @Autowired
    StudentRepository repo;

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = StudentMapper.mapToStudent(studentDto);
        Student savedStudent = repo.save(student);
        return StudentMapper.mapToStudentDto(savedStudent);
    }

    @Override
    public StudentDto getStudent(long id) {
        Student student = repo.findById(id).orElseThrow(
                () -> new CannotFindElement("Cannot find element by id: " + Long.toString(id))
        );
        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = repo.findAll();
        return students.stream().map(StudentMapper::mapToStudentDto).collect(Collectors.toList());
    }

    @Override
    public StudentDto updateStudent(long id, StudentDto studentDto) {
        Student student = repo.findById(id).orElseThrow(
                ()-> new CannotFindElement("Cannot find element by id: " + Long.toString(id))
        );
        student.setEmail(studentDto.getEmail());
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(student.getLastName());
        Student updatedStudent = repo.save(student);

        return StudentMapper.mapToStudentDto(updatedStudent);
    }

    @Override
    public StudentDto deleteStudent(long id) {
        Student student = repo.findById(id).orElseThrow(
                ()-> new CannotFindElement("Cannot find element by id: " + Long.toString(id))
        );
        repo.deleteById(id);
        return StudentMapper.mapToStudentDto(student);
    }
}
