package com.example.Minorproject.Digital.library.service;

import com.example.Minorproject.Digital.library.Models.Book;
import com.example.Minorproject.Digital.library.enums.BookFilterType;
import com.example.Minorproject.Digital.library.requests.BookCreateRequest;

import java.util.List;
import java.util.Optional;

public interface BookServiceInterf {

    Book saveBook(BookCreateRequest bookCreateRequest);

     List<Book> findBooks(BookFilterType bookFilterType, String value);

     public Optional<Book> findBYId(Integer id);

     Book save(Book book);
}
