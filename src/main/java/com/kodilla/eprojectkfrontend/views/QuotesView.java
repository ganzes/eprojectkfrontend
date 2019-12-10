package com.kodilla.eprojectkfrontend.views;

import com.kodilla.eprojectkfrontend.forms.QuotesForm;
import com.kodilla.eprojectkfrontend.services.QuotesService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;

@Route("quotesView")
public class QuotesView extends VerticalLayout {

   // private QuotesService quotesService = new QuotesService();
    private QuotesForm quotesForm = new QuotesForm(this);

    private Button goToMotiveView = new Button("Go to Motives!");
    private Button goToLoveView = new Button("Go to Love Calculator!");

    private Label labelQuotesView = new Label("Quotes");

    private TextArea tutorial = new TextArea();

    public QuotesView(){

        VerticalLayout mainQuotesContent = new VerticalLayout(quotesForm);
        mainQuotesContent.setSizeFull();

        goToMotiveView.addThemeVariants(ButtonVariant.LUMO_SMALL);
        goToMotiveView.addClickListener(event -> goToMotiveView.getUI().ifPresent(ui -> ui.navigate("motiveView")));

        goToLoveView.addThemeVariants(ButtonVariant.LUMO_SMALL);
        goToLoveView.addClickListener(event -> goToLoveView.getUI().ifPresent(ui -> ui.navigate("loveCalculatorView")));

        HorizontalLayout goTos = new HorizontalLayout(goToMotiveView, goToLoveView);

        tutorial.setReadOnly(true);
        tutorial.setAutofocus(true);
        tutorial.setWidthFull();
        tutorial.setValue("Get some inspiration for today from over +15000 quotes, by either:\n- typing your own 'Keyword', - 'Author's name, " +
                "- or get one randomly.");

        add(goTos);
        add(labelQuotesView);
        add(tutorial);

        add(mainQuotesContent);

        setSizeFull();
    }
}
