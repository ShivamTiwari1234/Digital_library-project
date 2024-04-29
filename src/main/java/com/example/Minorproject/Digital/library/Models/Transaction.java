package com.example.Minorproject.Digital.library.Models;

import com.example.Minorproject.Digital.library.enums.TransactionType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String externalId;

    @Enumerated
    private TransactionType transactionType;

    private double payment;

    @ManyToOne
    private Book book;

    @ManyToOne
    private Student student;

    @CreationTimestamp
    private Date createdOn;

}
