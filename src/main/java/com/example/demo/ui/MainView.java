package com.example.demo.ui;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.dom.Style.Position;
import com.vaadin.flow.dom.ThemeList;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.Lumo;
import com.vaadin.flow.theme.lumo.LumoUtility;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;

@Route(value = " ")
public class MainView extends AppLayout {

    private H1 Title;
    private Button themeMode;

    public MainView() {
        initcomponent();
    }

    private void initcomponent() {

        Title = new H1("Coffee-MG");
        Title.getStyle().setFontSize("25px")
                .setLeft("20px")
                .setMargin(Margin.NONE)
                .setPosition(Position.ABSOLUTE);

        HorizontalLayout navigation = getNavigation();
        navigation.getElement();

        HorizontalLayout Theme = getTheme();
        
        addToNavbar(Title, navigation, Theme);
        setContent(new HomePage());
    }

    private HorizontalLayout getTheme() {
        HorizontalLayout theme = new HorizontalLayout();
        theme.addClassNames(
            LumoUtility.JustifyContent.END,
            LumoUtility.Padding.SMALL);

        themeMode = new Button(VaadinIcon.ADJUST.create(), click -> {
            ThemeList themeList = UI.getCurrent().getElement().getThemeList();
            if (themeList.contains(Lumo.DARK)) {
                themeList.remove(Lumo.DARK);
            } else {
                themeList.add(Lumo.DARK);
            }});
            themeMode.addClassNames(
                LumoUtility.BorderRadius.LARGE);

        theme.add(themeMode);

        return theme;
    }

    private HorizontalLayout getNavigation() {
        HorizontalLayout navigation = new HorizontalLayout();
        navigation.addClassNames(
                LumoUtility.JustifyContent.CENTER,
                LumoUtility.Gap.SMALL,
                LumoUtility.Width.FULL);
        navigation.add(createLink("Dashboard"), createLink("Management"));

        return navigation;
    }

    private RouterLink createLink(String path) {
        RouterLink link = new RouterLink();
        link.add(path);

        if (path.equals("Dashboard")) {
            link.setRoute(DashPage.class);
        }
        if (path.equals("Management")) {
            link.setRoute(ManagePage.class);
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
}
