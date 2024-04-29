package com.example.Minorproject.Digital.library.repository;

import com.example.Minorproject.Digital.library.Models.Student;
import com.example.Minorproject.Digital.library.enums.AccountStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepositoryInterf extends JpaRepository<Student,Integer> {
    Student findByIdAndAccountStatus(int studentId, AccountStatus accountStatus);
}
