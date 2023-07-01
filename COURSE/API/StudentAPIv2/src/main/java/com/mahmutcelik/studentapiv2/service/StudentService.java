package com.mahmutcelik.studentapiv2.service;

import com.mahmutcelik.studentapiv2.dto.StudentDto;
import com.mahmutcelik.studentapiv2.model.Student;
import com.mahmutcelik.studentapiv2.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<StudentDto> getAllStudentsDto() {
        return studentRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();
    }

    public StudentDto convertToDto(Student student){
        return new StudentDto(student.getFirstName()
                ,student.getSchoolNumber()
                ,student.getPhoneNumber()
                ,student.getAddress().getCityName()
                ,student.getAddress().getTownName());
    }
}
