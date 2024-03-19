package com.example.demo.ui;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.Route;

@Route(value = "Report-page", layout = MainView.class)
public class ReportPage extends Div{

    public ReportPage() {
        initcomponent() ;
    }

    private void initcomponent() {
        H1 Test = new H1("Dash-page") ;
        add(Test);
    }
}
