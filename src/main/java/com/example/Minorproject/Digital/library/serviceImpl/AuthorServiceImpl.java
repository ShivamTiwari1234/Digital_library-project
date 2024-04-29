package com.example.Minorproject.Digital.library.serviceImpl;

import com.example.Minorproject.Digital.library.Models.Author;
import com.example.Minorproject.Digital.library.repository.AuthorRepositoryInterf;
import com.example.Minorproject.Digital.library.service.AuthorServiceInterf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorServiceInterf {

    @Autowired
    AuthorRepositoryInterf authorRepositoryInterf;
    @Override
    public Author saveAuthor(Author author) {
        return authorRepositoryInterf.save(author);
    }

    @Override
    public Author findByEmail(String email) {
        return authorRepositoryInterf.findByEmail(email);
    }
}
