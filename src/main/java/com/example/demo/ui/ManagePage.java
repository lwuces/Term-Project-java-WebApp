package com.example.demo.ui;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "Manage-page", layout = MainView.class)
public class ManagePage extends VerticalLayout{

    public ManagePage() {
        initcomponent();
        setDisplay();
    }

    private void initcomponent() {
        add(
            new H1("Coffee Mangement")
        );
    }

    private void setDisplay() {
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
    }
}
