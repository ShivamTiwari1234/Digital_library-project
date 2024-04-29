package com.example.Minorproject.Digital.library.repository;

import com.example.Minorproject.Digital.library.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepositoryInterf extends JpaRepository<Author,Integer> {
    public Author findByEmail(String email);
    //jpql:using jpl query language
    @Query("select a from Author a where a.email=?1")
    public Author getauthorByEmailId(String email);

    //Native queries: specific to database
    @Query(value = "select a from Author a where a.email=?1",nativeQuery = true)
    public Author getAuthorByEmailUsingNative(String email);

    //find the authors above the age of 30, living on India and name starting with p
    List<Author> findByAgeGreaterThanEqualAndCountryAndNameStartingWith(int age,
                                                                        String country, String prefix);

}
