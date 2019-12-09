package com.kodilla.eprojectkfrontend.views;

import com.kodilla.eprojectkfrontend.forms.LoveCalculatorForm;
import com.kodilla.eprojectkfrontend.services.LoveCalculatorService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

        private Button goToMotiveView = new Button("Go to Motives!");
        private Button goToLoveView = new Button("Go to Love Calculator!");
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


            add(goToMotiveView, goToLoveView);
            setSizeFull();

    }
}