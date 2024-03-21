package com.example.demo.ui;

import org.vaadin.crudui.crud.impl.GridCrud;

import com.example.demo.backend.Student;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import jakarta.annotation.security.RolesAllowed;

@Route(value = "Manage-page", layout = MainView.class)
@RolesAllowed("ADMIN")
public class ManagePage extends VerticalLayout{

    public ManagePage() {
        initcomponent();
        setDisplay();
    }

    private void initcomponent() {

        var crud = new GridCrud<>(Student.class) ;
        crud.getGrid().setColumns("id");
        crud.getCrudFormFactory().setVisibleProperties("id");
        
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
