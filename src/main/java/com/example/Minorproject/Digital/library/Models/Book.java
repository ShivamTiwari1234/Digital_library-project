package com.example.Minorproject.Digital.library.Models;


import com.example.Minorproject.Digital.library.Responce.BookSearchResponce;
import com.example.Minorproject.Digital.library.enums.Genre;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"author","transactionList"})
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int cost;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("book")
    private Author author;

    @ManyToOne
    @JoinColumn
    private Student student;

    @OneToMany(mappedBy = "book")
    private List<Transaction> transactionList;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;
    public BookSearchResponce toBookSearchResponce(){
        return BookSearchResponce.builder()
                .id(id).name(name).author(author).cost(cost)
                .genre(genre).student(student).transactionList(transactionList)
                .createdOn(createdOn).updatedOn(updatedOn).build();
    }
}
