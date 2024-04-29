package com.example.Minorproject.Digital.library.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Admin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(unique = true)
    private String email;
    private int age;

    @OneToOne
    @JoinColumn
    @JsonIgnoreProperties({"student","password","admin"})
    private MyUser myUser;


    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;


}
