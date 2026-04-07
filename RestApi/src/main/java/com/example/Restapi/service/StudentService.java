package com.example.Restapi.service;

import com.example.Restapi.dto.AddStudentRequestDto;
import com.example.Restapi.dto.StudentDto;

import java.util.List;
import java.util.Map;

public interface StudentService {

    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long id);

    StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto);

    void deleteStudentById(Long id);

    StudentDto updateStudent(Long id, AddStudentRequestDto AddstudentrequestDto);

    StudentDto updatePartialStudent(Long id, Map<String, Object> updates);
}
