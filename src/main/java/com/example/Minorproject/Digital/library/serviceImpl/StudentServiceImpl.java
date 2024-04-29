package com.example.Minorproject.Digital.library.serviceImpl;

import com.example.Minorproject.Digital.library.Models.MyUser;
import com.example.Minorproject.Digital.library.Models.Student;
import com.example.Minorproject.Digital.library.enums.AccountStatus;
import com.example.Minorproject.Digital.library.repository.StudentRepositoryInterf;
import com.example.Minorproject.Digital.library.requests.StudentCreateRequest;
import com.example.Minorproject.Digital.library.requests.UserCreateRequest;
import com.example.Minorproject.Digital.library.service.StudentServiceInterf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentServiceInterf {
    @Autowired
    StudentRepositoryInterf studentRepositoryInterf;
    @Autowired
    MyUserDetailsService myUserDetailsService;
    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public Student save(StudentCreateRequest studentCreateRequest) {
       // studentCreateRequest.setPassword(passwordEncoder.encode(studentCreateRequest.getPassword()));
        return saveFromStudent(studentCreateRequest.toStudent());
    }

    @Override
    public Student saveFromStudent(Student student) {
        return studentRepositoryInterf.save(student);
    }

    @Override
    public Student findById(int studentId) {
        return studentRepositoryInterf.findById(studentId).get();
    }

    @Override
    public List<Student> findAllById(List<Integer> studentIds) {
        return studentRepositoryInterf.findAllById(studentIds);
    }

    @Override
    public Student findByIdAndAccountStatus(int studentId, AccountStatus accountStatus) {
        return studentRepositoryInterf.findByIdAndAccountStatus(studentId, accountStatus);

    }
    public void create(StudentCreateRequest studentCreateRequest){
        UserCreateRequest userCreateRequest = studentCreateRequest.toUser();
        MyUser myUser = myUserDetailsService.createUser(userCreateRequest);

        Student student = studentCreateRequest.toStudent();
        student.setMyUser(myUser);
        studentRepositoryInterf.save(student);

    }
}
