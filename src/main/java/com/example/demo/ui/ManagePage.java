package com.example.demo.ui;

import org.vaadin.crudui.crud.impl.GridCrud;

import com.example.demo.backend.Students;
import com.example.demo.backend.Service.StudentsService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

import jakarta.annotation.security.RolesAllowed;

@Route(value = "Manage-page", layout = MainView.class)
@RolesAllowed("Admin")
public class ManagePage extends VerticalLayout{

    private StudentsService service ;
    private GridCrud<Students> crud ;
    private TextField filterTextField ;
    private Button addButton ;
    private Button configButton ;
    private Button deleteButton ;
    private Button checkButton ;

    public ManagePage(StudentsService service) {
        this.service = service;
        initcomponent();
        setDisplay();
    }

    private void initcomponent() {
        add(crud());
    }

    public Component crud() {
        // Crud Ui add-ons -
        this.crud = new GridCrud<>(Students.class, service);

        // Crud/Grid ui -
        crud.getGrid().setColumns(
            "studentid","firstname", "lastname", "email", "birth"
        );
        crud.getCrudFormFactory().setVisibleProperties(
            "studentid","firstname", "lastname", "email", "birth"
        );

        crud.addClassNames(
            LumoUtility.Display.FLEX
        );

        // Check Data Button -
        CHECKBTN();
        
        // Add Data Button -
        ADDBTN();
        
        // Modified Data Button -
        MODIFIEDBTN();
        
        // Delete Data Button -
        DELETEBTN();
        
        // New Tools Filter (Search bar) -
        crud.getCrudLayout().addToolbarComponent(FILTERBAR());
        
        return crud ;
    }

    private void CHECKBTN() {

        // Check Data Button -
        checkButton = crud.getFindAllButton();
        checkButton.setText(" CHECK - DATA");
        checkButton.setIcon(VaadinIcon.REFRESH.create());
        checkButton.addClassNames(
            LumoUtility.BorderRadius.MEDIUM,
            LumoUtility.BoxShadow.SMALL,
            LumoUtility.Display.FLEX
        );
        
    }

    private Component FILTERBAR() { 

        filterTextField = new TextField();

         // Filter (Search bar) -
        filterTextField.setWidth("250px");
        filterTextField.setPlaceholder("Search By StudentID");
        filterTextField.setPrefixComponent(new Icon(VaadinIcon.SEARCH));
        filterTextField.setClearButtonVisible(true);
        filterTextField.setValueChangeMode(ValueChangeMode.LAZY);
        // Style -
        filterTextField.addClassNames(
            LumoUtility.BorderRadius.MEDIUM,
            LumoUtility.Display.FLEX
        );
        // event -
        filterTextField.addValueChangeListener(e -> {
            String filterText = e.getValue();
            crud.getGrid().setItems(service.findAll(filterText));
        });
        return filterTextField ;

    }

    private void ADDBTN() {

        // Add Data Button -
        addButton = crud.getAddButton();
        addButton.setText(" New - Student");
        addButton.setIcon(VaadinIcon.PLUS.create());
        // Style -
        addButton.addClassNames(
            LumoUtility.BorderRadius.MEDIUM,
            LumoUtility.TextColor.SUCCESS,
            LumoUtility.BoxShadow.SMALL,
            LumoUtility.Display.FLEX
        );

    }

    private void MODIFIEDBTN() {

        // Modified Data Button -
        configButton = crud.getUpdateButton();
        configButton.setText(" Config - Data");
        configButton.setIcon(VaadinIcon.PENCIL.create());
        // Style -
        configButton.addClassNames(
            LumoUtility.BorderRadius.MEDIUM,
            LumoUtility.TextColor.PRIMARY,
            LumoUtility.BoxShadow.SMALL,
            LumoUtility.Display.FLEX
        );

    }

    private void DELETEBTN() {

        // Delete Data Button -
        deleteButton = crud.getDeleteButton();
        deleteButton.setText(" Delete - Data");
        deleteButton.setIcon(VaadinIcon.TRASH.create());
        // Style -
        deleteButton.addClassNames(
            LumoUtility.BorderRadius.MEDIUM,
            LumoUtility.TextColor.ERROR,
            LumoUtility.BoxShadow.SMALL,
            LumoUtility.Display.FLEX
        );

    }

    private void setDisplay() {

        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        
    }
}
