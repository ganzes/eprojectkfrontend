package com.kodilla.eprojectkfrontend.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

        private Button goToMotiveView = new Button("Go to Motives!");
        private Button goToLoveView = new Button("Go to Love Calculator!");
        private Button goToQuoteView = new Button("Go to 150000+ Quotes!");
        private Button goToBookView = new Button("Go to Books!");

        private Label mainViewLabel = new Label("Welcome to InspirationVibe");
        private Icon vaadinIcon = new Icon(VaadinIcon.VAADIN_V);

    public MainView(){

            setAlignItems(Alignment.CENTER);
            goToMotiveView.addThemeVariants(ButtonVariant.LUMO_LARGE);
            goToMotiveView.setAutofocus(true);
            goToMotiveView.addClickListener(event -> goToMotiveView.getUI().ifPresent(ui -> ui.navigate("motiveView")));

            goToLoveView.addThemeVariants(ButtonVariant.LUMO_LARGE);
            goToLoveView.setAutofocus(true);
            goToLoveView.addClickListener(event -> goToLoveView.getUI().ifPresent(ui -> ui.navigate("loveCalculatorView")));

            goToQuoteView.addThemeVariants(ButtonVariant.LUMO_LARGE);
            goToQuoteView.setAutofocus(true);
            goToQuoteView.addClickListener(event -> goToQuoteView.getUI().ifPresent(ui -> ui.navigate("quotesView")));

            goToBookView.addThemeVariants(ButtonVariant.LUMO_LARGE);
            goToBookView.setAutofocus(true);
            goToBookView.addClickListener(event -> goToBookView.getUI().ifPresent(ui -> ui.navigate("bookView")));




            mainViewLabel.setWidthFull();

            vaadinIcon.setColor("blue");
            vaadinIcon.setSize("66px");

            add(mainViewLabel);
            add(goToMotiveView, goToBookView, goToLoveView, goToQuoteView, vaadinIcon);

            setSizeFull();
    }
}