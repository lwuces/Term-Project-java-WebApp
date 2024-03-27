package com.example.demo.ui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.theme.lumo.LumoUtility;
import com.vaadin.flow.theme.lumo.LumoUtility.FontWeight;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;

@Route(value = "Home-page", layout = MainView.class)
@AnonymousAllowed
public class Content extends VerticalLayout implements RouterLayout{

    private H1 Title;
    private H4 SubTitle;
    private Button btn;
    
    public Content() {
        initcomponent();
        centerComponents();
        addListeners();
    }

    private void initcomponent() {
        add(
            MainTitle(), SubTitle(), Button()
        );
    }

    private Component MainTitle() {
        Title = new H1("STUDENT<>MANAGEMENT");
        Title.getStyle().setFontSize("75px")
                        .setFontWeight(FontWeight.BOLD)
                        .setMargin(Margin.NONE)
                        .setPadding(Padding.NONE);
        return Title ;
    }

    private Component SubTitle() {
        SubTitle = new H4("- F i n a l P r o j e c t < J A V A > -");
        SubTitle.getStyle().setFontSize("25px")
                           .setMargin(Margin.NONE)
                           .setPadding(Padding.NONE);
        return SubTitle ;
    }

    private Component Button() {
        btn = new Button(" let's work ! ") ;
        btn.addThemeVariants(
            ButtonVariant.LUMO_PRIMARY, 
            ButtonVariant.LUMO_LARGE
        );
        btn.addClassNames(
            LumoUtility.BoxShadow.MEDIUM
        );

        return btn ;
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
    