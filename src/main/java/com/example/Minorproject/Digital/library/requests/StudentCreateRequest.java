package com.example.Minorproject.Digital.library.requests;

import com.example.Minorproject.Digital.library.Models.Student;
import com.example.Minorproject.Digital.library.enums.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreateRequest {
    @NotBlank
    private String name;
    private String email;

    @NotBlank
    private String contact;
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String authority;

    private String address;

    public Student toStudent() {
        return Student.builder()
                .address(address)
                .contact(contact)
                .email(email)
                .name(name)
                .accountStatus(AccountStatus.ACTIVE)
                .build();
    }
    public UserCreateRequest toUser(){
        return UserCreateRequest.builder()
                .student(toStudent())
                .username(username).password(password)
                .build();
    }

}
