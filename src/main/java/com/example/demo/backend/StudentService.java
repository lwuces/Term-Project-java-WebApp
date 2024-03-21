package com.example.demo.backend;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;

@Service
public class StudentService implements CrudListener<Student>{

    private final StudentRepository studentRepository;
    
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Collection<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student add(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student update(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void delete(Student student) {
        studentRepository.delete(student);
    }
    
}
