package com.example.Minorproject.Digital.library.repository;

import com.example.Minorproject.Digital.library.Models.Book;
import com.example.Minorproject.Digital.library.enums.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepositoryInterf extends JpaRepository<Book, Integer> {

    List<Book> findByName(String name);
    List<Book> findByAuthor_name(String name);
    List<Book> findByGenre(Genre genre);
    List<Book> findByCost(int value);
}
