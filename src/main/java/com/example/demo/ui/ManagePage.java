package com.example.demo.ui;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.Route;

@Route(value = "Manage-page", layout = MainView.class)
public class ManagePage extends Div{

    public ManagePage() {
        initcomponent();
    }

    private void initcomponent() {
        H1 Test = new H1("Manage-page") ;
        add(Test);
    }
}
