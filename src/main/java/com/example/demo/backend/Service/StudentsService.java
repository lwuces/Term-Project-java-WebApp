package com.example.demo.backend.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;

import com.example.demo.backend.Students;
import com.example.demo.backend.Repository.StudentsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentsService implements CrudListener<Students>{

    private final StudentsRepository repository ;
    
    @Override
    public List<Students> findAll() {
        return repository.findAll();
    }

    @Override
    public Students add(Students students) {
       return repository.save(students);
    }

    @Override
    public Students update(Students students) {
        return repository.save(students);
    }

    @Override
    public void delete(Students students) {
        repository.delete(students);
    }
    
}
