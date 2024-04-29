package com.example.Minorproject.Digital.library.requests;

import com.example.Minorproject.Digital.library.Models.Admin;
import com.example.Minorproject.Digital.library.Models.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UserCreateRequest {
    private String username;
    private String password;
    private String authority;
    private Student student;
    private Admin admin;



}
