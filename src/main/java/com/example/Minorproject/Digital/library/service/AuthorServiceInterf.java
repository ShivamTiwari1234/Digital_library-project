package com.example.Minorproject.Digital.library.service;

import com.example.Minorproject.Digital.library.Models.Author;

public interface AuthorServiceInterf {
    public Author saveAuthor(Author author);
    public Author findByEmail(String email);
}
