package com.example.Minorproject.Digital.library.repository;


import com.example.Minorproject.Digital.library.Models.Book;
import com.example.Minorproject.Digital.library.Models.Student;
import com.example.Minorproject.Digital.library.Models.Transaction;
import com.example.Minorproject.Digital.library.enums.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Minorproject.Digital.library.Models.Transaction;

@Repository
public interface TransactionRepositoryInterf extends JpaRepository<Transaction, Integer> {

    Transaction findTopByBookAndStudentAndTransactionTypeOrderByIdDesc(Book book, Student student, TransactionType transactionType);

}