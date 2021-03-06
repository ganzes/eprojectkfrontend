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
    private Button goToMovieView = new Button("Go to Movies!");
    private Button goToGameView = new Button("Go to Games!");
    private Button goToTvShowView = new Button("Go to TV Shows!");

    private Label labelLoveCalculator = new Label("Love Calculator");

    private TextArea tutorialLoveCalculator = new TextArea();

    public LoveCalculatorView(){
        VerticalLayout mainLoveContent = new VerticalLayout(loveCalculatorForm);
        mainLoveContent.setSizeFull();

        HorizontalLayout goTos = new HorizontalLayout(goToMotiveView, goToBookView, goToMovieView,
                goToTvShowView, goToGameView, goToQuoteView);

        goToMotiveView.addThemeVariants(ButtonVariant.LUMO_SMALL);
        goToMotiveView.addClickListener(event -> goToMotiveView.getUI().ifPresent(ui -> ui.navigate("motiveView")));

        goToQuoteView.addThemeVariants(ButtonVariant.LUMO_SMALL);
        goToQuoteView.addClickListener(event -> goToQuoteView.getUI().ifPresent(ui -> ui.navigate("quotesView")));

        goToBookView.addThemeVariants(ButtonVariant.LUMO_SMALL);
        goToBookView.addClickListener(event -> goToBookView.getUI().ifPresent(ui -> ui.navigate("bookView")));

        goToMovieView.addThemeVariants(ButtonVariant.LUMO_SMALL);
        goToMovieView.addClickListener(event -> goToMovieView.getUI().ifPresent(ui -> ui.navigate("movieView")));

        goToGameView.addThemeVariants(ButtonVariant.LUMO_SMALL);
        goToGameView.addClickListener(event -> goToGameView.getUI().ifPresent(ui -> ui.navigate("gameView")));

        goToTvShowView.addThemeVariants(ButtonVariant.LUMO_SMALL);
        goToTvShowView.addClickListener(event -> goToTvShowView.getUI().ifPresent(ui -> ui.navigate("tvShowView")));

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