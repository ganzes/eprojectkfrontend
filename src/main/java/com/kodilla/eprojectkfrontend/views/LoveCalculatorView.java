package com.kodilla.eprojectkfrontend.views;

import com.kodilla.eprojectkfrontend.forms.LoveCalculatorForm;
import com.kodilla.eprojectkfrontend.services.LoveCalculatorService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;

@Route("loveCalculatorView")
public class LoveCalculatorView extends VerticalLayout {

    private LoveCalculatorService loveCalculatorService = new LoveCalculatorService();

    private LoveCalculatorForm loveCalculatorForm = new LoveCalculatorForm(this);

    private Button goToMotiveView = new Button("Go to Motives!");
    private Button goToQuoteView = new Button("Go to Quotes!");
    private Button goToBookView = new Button("Go to Books!");

    private Label labelLoveCalculator = new Label("Love Calculator");

    private TextArea tutorialLoveCalculator = new TextArea();

    public LoveCalculatorView(){
        VerticalLayout mainLoveContent = new VerticalLayout(loveCalculatorForm);
        mainLoveContent.setSizeFull();

        goToMotiveView.addThemeVariants(ButtonVariant.LUMO_SMALL);
        goToMotiveView.addClickListener(event -> goToMotiveView.getUI().ifPresent(ui -> ui.navigate("motiveView")));

        goToQuoteView.addThemeVariants(ButtonVariant.LUMO_SMALL);
        goToQuoteView.addClickListener(event -> goToQuoteView.getUI().ifPresent(ui -> ui.navigate("quotesView")));

        goToBookView.addThemeVariants(ButtonVariant.LUMO_SMALL);
        goToBookView.addClickListener(event -> goToBookView.getUI().ifPresent(ui -> ui.navigate("bookView")));

        HorizontalLayout goTos = new HorizontalLayout(goToMotiveView, goToBookView, goToQuoteView);

        tutorialLoveCalculator.setReadOnly(true);
        tutorialLoveCalculator.setValue("Ever wonder who of your closest friends have a shot at love? " +
        "Just type their names and find out! Be patient! Third party API needs some time to work!\nExample: 'John' | 'Kate'");
        tutorialLoveCalculator.setAutofocus(true);
        tutorialLoveCalculator.setWidthFull();

        add(goTos);
        add(labelLoveCalculator);
        add(tutorialLoveCalculator);
        add(mainLoveContent);

        setSizeFull();
    }
}
