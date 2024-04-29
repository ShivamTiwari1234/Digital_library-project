package com.example.Minorproject.Digital.library.Models;

import com.example.Minorproject.Digital.library.enums.AccountStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(unique = true)
    private String email;

    @Column(unique = true, nullable = false)
    private String contact;


    private String address;
    @OneToOne
    @JoinColumn
    @JsonIgnoreProperties({"student","password","admin"})
    private MyUser myUser;

    @Enumerated(value = EnumType.STRING)
    private AccountStatus accountStatus;

    @OneToMany(mappedBy = "student")
    private List<Book> bookList;

    @OneToMany(mappedBy = "student")
    private List<Transaction> tranctionList;

//    @OneToMany(mappedBy = "student")
//    private List<Transaction> transactionList;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;


}
