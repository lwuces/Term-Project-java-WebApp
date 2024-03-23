package com.example.demo.ui;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "login-page")
public class LoginPage extends VerticalLayout{

    private LoginForm loginForm ;

    public LoginPage() {
        initcomponent();
        setDisplay();
    }

    private void initcomponent() {
        loginForm = new LoginForm();
        loginForm.setAction("login-page");
        loginForm.setForgotPasswordButtonVisible(false);

        add(
            new H1("STUDENT <> MM"), 
            loginForm
        );
    }

    private void setDisplay() {
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
    }

}
