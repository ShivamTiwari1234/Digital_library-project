package com.example.Minorproject.Digital.library.repository;

import com.example.Minorproject.Digital.library.Models.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepositoryInterf extends JpaRepository<MyUser,Integer> {
    MyUser findByUserName(String username);

}
