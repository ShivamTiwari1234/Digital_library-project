package com.example.Minorproject.Digital.library.service;

import com.example.Minorproject.Digital.library.Models.Student;
import com.example.Minorproject.Digital.library.enums.AccountStatus;
import com.example.Minorproject.Digital.library.requests.StudentCreateRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentServiceInterf {
    Student save(StudentCreateRequest studentCreateRequest);
    Student saveFromStudent(Student student);
    Student findById(int studentId);
    List<Student> findAllById(List<Integer> studentId);

    Student findByIdAndAccountStatus(int studentId, AccountStatus accountStatus);
}
