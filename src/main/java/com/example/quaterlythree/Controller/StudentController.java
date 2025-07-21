package com.example.quaterlythree.Controller;

import com.example.quaterlythree.StudentRepo.StudentRepository;
import com.example.quaterlythree.model.Student;
import com.example.quaterlythree.Service.StudentService;
import com.example.quaterlythree.StudentDto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/getall")
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/putone")
    public StudentDto addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }
}
