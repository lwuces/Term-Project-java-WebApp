package com.example.demo.backend.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<Students> findAll(String filterText) {
        return repository.findAll()
                         .stream()
                         .filter(student -> student.getStudentid().toLowerCase().contains(filterText.toLowerCase()))
                         .collect(Collectors.toList());
    }
    
}
