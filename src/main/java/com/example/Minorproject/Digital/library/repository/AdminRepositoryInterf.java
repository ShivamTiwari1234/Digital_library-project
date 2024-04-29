package com.example.Minorproject.Digital.library.repository;

import com.example.Minorproject.Digital.library.Models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
@Repository
public interface AdminRepositoryInterf extends JpaRepository<Admin,Integer> {

}
