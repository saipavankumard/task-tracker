package com.example.quaterlythree.Service;

import com.example.quaterlythree.model.Student;
import com.example.quaterlythree.StudentDto.StudentDto;
import com.example.quaterlythree.StudentRepo.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<StudentDto> getAllStudents(){
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(student -> modelMapper.map(student, StudentDto.class))
                .collect(Collectors.toList());
    }

    public StudentDto addStudent(Student student){
        student = studentRepository.save(student);
        return modelMapper.map(student, StudentDto.class);
    }
}
