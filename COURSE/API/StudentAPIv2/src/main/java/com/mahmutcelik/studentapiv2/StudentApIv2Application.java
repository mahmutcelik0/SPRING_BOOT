package com.mahmutcelik.studentapiv2;

import com.mahmutcelik.studentapiv2.model.Address;
import com.mahmutcelik.studentapiv2.model.Student;
import com.mahmutcelik.studentapiv2.repository.AddressRepository;
import com.mahmutcelik.studentapiv2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class StudentApIv2Application implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(StudentApIv2Application.class, args);
    }
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        Address address = new Address("54","PAMUKKALE","CUMHURIYET","DENIZLI", BigDecimal.valueOf(3));
        Student student = new Student(1L,"MAHMUT","CELIK",123L,123L,address);
        Student student2 = new Student(2L,"ELA","CELIK",123L,123L,address);

        addressRepository.save(address);
        studentRepository.save(student);
        studentRepository.save(student2);
    }
}
