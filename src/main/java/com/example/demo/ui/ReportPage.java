package com.example.demo.ui;

import org.vaadin.crudui.crud.impl.GridCrud;

import com.example.demo.backend.Students;
import com.example.demo.backend.Service.StudentsService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route(value = "Report-page", layout = MainView.class)
@AnonymousAllowed
public class ReportPage extends VerticalLayout{

    private StudentsService service ;
    private GridCrud<Students> crud ; 

    public ReportPage(StudentsService service) {
        this.service = service ;
        initcomponent();
        setDisplay() ;
    }

    private void initcomponent() {
        add(crud());
    }

    private Component crud() {

        // Crud ui -
        this.crud = new GridCrud<>(Students.class, service);

        crud.getGrid().setColumns(
            "studentid","firstname", "lastname", "email", "birth"
        );
        crud.getCrudFormFactory().setVisibleProperties(
            "studentid","firstname", "lastname", "email", "birth"
        );

        // Hide Tools -
        crud.setAddOperationVisible(false);
        crud.setDeleteOperationVisible(false);
        crud.setFindAllOperationVisible(false);
        crud.setUpdateOperationVisible(false);

        return crud ;

    }

    private void setDisplay() {
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
    }
}
