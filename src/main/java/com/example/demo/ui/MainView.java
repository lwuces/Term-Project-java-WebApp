package com.example.demo.ui;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.dom.Style.FontWeight;
import com.vaadin.flow.dom.Style.Position;
import com.vaadin.flow.dom.ThemeList;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.theme.lumo.Lumo;
import com.vaadin.flow.theme.lumo.LumoUtility;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;

@Route(value = " ")
@AnonymousAllowed
public class MainView extends AppLayout {

    private H1 Title;
    private Button themeMode;
    private Button loginButton;

    public MainView() {
        initcomponent();
    }

    private void initcomponent() {
        addToNavbar(
            Title(), navigations(), ThemeMode(), loginButton()
        );
        setContent(new Content());
    }

    private Component Title() {
        Title = new H1("Student-MG");
        Title.getStyle().setFontSize("25px")
                .setLeft("17px")
                .setFontWeight(FontWeight.BOLD)
                .setMargin(Margin.NONE)
                .setPosition(Position.ABSOLUTE);
        return Title ;
    }

    private Component ThemeMode() {
        themeMode = new Button(VaadinIcon.ADJUST.create(), click -> {
            ThemeList themeList = UI.getCurrent().getElement().getThemeList();
            if (themeList.contains(Lumo.DARK)) {
                themeList.remove(Lumo.DARK);
            } else {
                themeList.add(Lumo.DARK);
            }});

        themeMode.getStyle().setRight("7.5rem")
                            .setPosition(Position.ABSOLUTE);

        themeMode.addClassNames(
            LumoUtility.Margin.NONE,
            LumoUtility.BorderRadius.LARGE,
            LumoUtility.Background.TRANSPARENT,
            LumoUtility.TextColor.TERTIARY
            );

        return themeMode ;
    }

    private Component navigations() {
        HorizontalLayout navigation = getNavigation();
        navigation.getElement();
        return navigation ;
    }

    private HorizontalLayout getNavigation() {
        HorizontalLayout navigation = new HorizontalLayout();
        navigation.addClassNames(
                LumoUtility.JustifyContent.CENTER,
                LumoUtility.Gap.SMALL,
                LumoUtility.Width.FULL);
        navigation.add(createLink("Management"), createLink("Report-History"));

        return navigation;
    }

    private RouterLink createLink(String path) {
        RouterLink link = new RouterLink();
        link.add(path);

        if (path.equals("Management")) {
            link.setRoute(ManagePage.class);
        }
        if (path.equals("Report-History")) {
            link.setRoute(ReportPage.class);
        }

        link.addClassNames(
                LumoUtility.Display.FLEX,
                LumoUtility.AlignItems.CENTER,
                LumoUtility.Padding.Horizontal.SMALL,
                LumoUtility.TextColor.SECONDARY,
                LumoUtility.FontWeight.BOLD);
        link.getStyle().setTextDecoration("none");

        return link;
    }

    private Component loginButton() {
        loginButton = new Button("Login", VaadinIcon.SIGN_IN.create(), event -> {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {

                // User is logged in, so logout -
                SecurityContextHolder.clearContext();
                // Clear authentication -
                SecurityContextHolder.getContext().setAuthentication(null); 
                // Navigate to login page -
                UI.getCurrent().navigate(LoginPage.class); 

            } else {

                // User is logged out, so navigate to login page -
                // Navigate to LoginPage -
                UI.getCurrent().navigate(LoginPage.class); 

            }
        });

        loginButton.getStyle().setRight("0.6rem")
                              .setPosition(Position.ABSOLUTE);

        // Set Theme -
        loginButton.addThemeVariants(
            ButtonVariant.LUMO_PRIMARY
        );
    
        // Check authentication status and update button text/icon accordingly -
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            loginButton.setText("Logout");
            loginButton.setIcon(VaadinIcon.SIGN_OUT.create());
        }
    
        return loginButton;
    }

}
