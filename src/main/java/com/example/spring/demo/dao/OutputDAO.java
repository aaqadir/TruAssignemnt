package com.example.spring.demo.dao;

import com.example.spring.demo.model.Output;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutputDAO extends JpaRepository<Output, Integer>{
	
	
}
