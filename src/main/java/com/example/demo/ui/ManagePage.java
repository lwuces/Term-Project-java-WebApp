package com.example.demo.ui;

import org.vaadin.crudui.crud.impl.GridCrud;

import com.example.demo.backend.Students;
import com.example.demo.backend.Service.StudentsService;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;

@Route(value = "Manage-page", layout = MainView.class)
@RolesAllowed("Admin")
public class ManagePage extends VerticalLayout{

    private final GridCrud<Students> crud ;
    private TextField filterTextField = new TextField();

    public ManagePage(StudentsService service) {
        
        this.crud = new GridCrud<>(Students.class, service);

        crud.getGrid().setColumns(
            "studentid","firstname", "lastname", "email", "birth"
        );
        crud.getCrudFormFactory().setVisibleProperties(
            "studentid","firstname", "lastname", "email", "birth"
        );

        crud.setSavedMessage("+ ADD STUDENT SUCCEED ?!");
        crud.setDeletedMessage("- DELETE STUDENTS SUCCEED ?!");

        filterTextField.setWidth("250px");
        filterTextField.setPlaceholder("Search......");
        filterTextField.setPrefixComponent(new Icon(VaadinIcon.SEARCH));
        filterTextField.setClearButtonVisible(true);
        filterTextField.setValueChangeMode(ValueChangeMode.LAZY);
        filterTextField.addValueChangeListener(e -> {
            String filterText = e.getValue();
            crud.getGrid().setItems(service.findAll(filterText));
        });
        
        crud.getCrudLayout().addToolbarComponent(filterTextField);

        add(crud);
        setDisplay();
    }

    private void setDisplay() {
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
    }
}
