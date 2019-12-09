package com.kodilla.eprojectkfrontend.views;

import com.kodilla.eprojectkfrontend.forms.QuotesForm;
import com.kodilla.eprojectkfrontend.services.QuotesService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("quotesView")
public class QuotesView extends VerticalLayout {

    private QuotesService quotesService = new QuotesService();
    private QuotesForm quotesForm = new QuotesForm(this);

    private Button goToMotiveView = new Button("Go to Motives!");



    public QuotesView(){

        VerticalLayout mainQuotesContent = new VerticalLayout(quotesForm);
        mainQuotesContent.setSizeFull();

        goToMotiveView.addThemeVariants(ButtonVariant.LUMO_SMALL);
        goToMotiveView.addClickListener(event -> goToMotiveView.getUI().ifPresent(ui -> ui.navigate("motiveView")));

        add(mainQuotesContent);
        add(goToMotiveView);
        setSizeFull();
    }
}
