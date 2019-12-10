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
        private Label mainViewLabel = new Label("Welcome to InspirationVibe");
        private Icon vaadinIcon = new Icon(VaadinIcon.VAADIN_V);


        //private VerticalLayout verticalLayout = new VerticalLayout();

    public MainView(){

            //verticalLayout.add(goToLoveView, goToMotiveView);
            //verticalLayout.setAlignItems(Alignment.CENTER);

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

            mainViewLabel.setWidthFull();

            vaadinIcon.setColor("blue");
            vaadinIcon.setSize("66px");

            add(mainViewLabel);
            add(goToMotiveView, goToLoveView, goToQuoteView,vaadinIcon);


            setSizeFull();
    }
}