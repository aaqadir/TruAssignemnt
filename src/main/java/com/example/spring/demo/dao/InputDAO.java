package com.example.spring.demo.dao;

import com.example.spring.demo.model.Input;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InputDAO extends JpaRepository<Input, Integer>{

}
