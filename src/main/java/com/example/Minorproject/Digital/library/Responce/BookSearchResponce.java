package com.example.Minorproject.Digital.library.Responce;

import com.example.Minorproject.Digital.library.Models.Author;
import com.example.Minorproject.Digital.library.Models.Student;
import com.example.Minorproject.Digital.library.Models.Transaction;
import com.example.Minorproject.Digital.library.enums.Genre;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class BookSearchResponce {
    private int id;
    private String name;
    private int cost;
    private Genre genre;
    @JsonIgnoreProperties({"book"})
    private Author author;
    private Student student;
    private List<Transaction> transactionList;
    private Date createdOn;
    private Date updatedOn;

}
