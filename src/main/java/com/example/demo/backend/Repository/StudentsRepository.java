package com.example.demo.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.backend.Students;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Long>{
    
}
