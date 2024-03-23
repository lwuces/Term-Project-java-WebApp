package com.example.demo.ui;

import org.vaadin.crudui.crud.impl.GridCrud;

import com.example.demo.backend.Students;
import com.example.demo.backend.Service.StudentsService;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import lombok.var;

@Route(value = "Manage-page", layout = MainView.class)
public class ManagePage extends VerticalLayout{

    private StudentsService service ;

    public ManagePage() {
        initcompoment();
        setDisplay();
    }

    private void initcompoment() {
        var crud = new GridCrud<>(Students.class, service);
        crud.getGrid().setColumns("studentid","firstname", "lastname", "email", "birth");
        crud.getCrudFormFactory().setVisibleProperties("studentid","firstname", "lastname", "email", "birth");
        add(
            new H1("Student<>Mangement"),
            crud
        );
    }

    private void setDisplay() {
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
    }
}
