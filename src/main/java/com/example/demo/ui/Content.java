package com.example.demo.ui;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.theme.lumo.LumoUtility.FontWeight;

@Route(value = "Home-page", layout = MainView.class)
public class Content extends VerticalLayout implements RouterLayout{

    private H1 Title;
    private H3 SubTitle;
    private Button btn;
    
    public Content() {
        initcomponent();
        centerComponents();
        addListeners();
    }

    private void initcomponent() {
        
        Title = new H1("Coffee - Management") ;
        SubTitle = new H3("- Final Project Java -") ;
        btn = new Button("let's work!") ;

        Title.getStyle().setFontWeight(FontWeight.BOLD) ;
        
        btn.addThemeVariants(
            ButtonVariant.LUMO_PRIMARY, 
            ButtonVariant.LUMO_LARGE
        );
        
        add(
            Title, SubTitle, btn
        );
    }
        
    private void centerComponents() {
        setSizeFull();
        setMargin(false);
        setPadding(false);
        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);
    }

    private void addListeners() {
        btn.addClickListener(clickEvent -> {
            UI.getCurrent().navigate(ManagePage.class);
        });
    }
}
    