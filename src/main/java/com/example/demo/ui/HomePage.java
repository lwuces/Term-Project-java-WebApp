package com.example.demo.ui;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;

import com.vaadin.flow.router.Route;

@Route(value = "Home-page", layout = MainView.class)
public class HomePage extends Div{

    private H1 Title ;

    public HomePage() {
        initcomponent() ;
    }

    private void initcomponent() { 
        Title = new H1("Home-page") ;
        add(Title);
    }
}
