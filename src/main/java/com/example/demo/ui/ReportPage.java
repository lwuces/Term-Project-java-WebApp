package com.example.demo.ui;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "Report-page", layout = MainView.class)
public class ReportPage extends VerticalLayout{

    public ReportPage() {
        initcomponent() ;
        setDisplay() ;
    }

    private void initcomponent() {
        add(
            new H1("Report-page")
        );
    }

    private void setDisplay() {
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
    }
}
