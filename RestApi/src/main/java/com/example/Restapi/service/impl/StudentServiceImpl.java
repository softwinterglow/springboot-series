


package com.example.Restapi.service.impl;

import com.example.Restapi.dto.AddStudentRequestDto;
import com.example.Restapi.dto.StudentDto;
import com.example.Restapi.entity.Student;
import com.example.Restapi.repository.StudentRepository;
import com.example.Restapi.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;





    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students
                .stream()
                .map(student -> modelMapper.map(student, StudentDto.class))
                .toList();
    }

    @Override
    public StudentDto getStudentById(Long id){
        Student student = studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("student not found with id "+id));

        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {
        Student newStudent = modelMapper.map(addStudentRequestDto, Student.class);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public void deleteStudentById(Long id){
        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("Student does not exist by id: "+id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto){
        Student student = studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("student not found with id "+id));
       modelMapper.map(addStudentRequestDto, student);
       studentRepository.save(student);
       return modelMapper.map(student, StudentDto.class);

    }

    @Override
    public StudentDto updatePartialStudent(Long id, Map<String, Object> updates) {
        Student student = studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("student not found with id "+id));
        updates.forEach((field,value)->{
            switch (field){
                case "name":student.setName((String) value);
                break;
                case "email":student.setEmail((String) value);
                break;
                default:
                    throw new IllegalArgumentException("field is not supported");
            }
        });
        Student savedStudent =studentRepository.save(student);
        return modelMapper.map(savedStudent, StudentDto.class);
    }
}
