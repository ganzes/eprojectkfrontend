package com.kodilla.eprojectkfrontend.views;

import com.kodilla.eprojectkfrontend.forms.LoveCalculatorForm;
import com.kodilla.eprojectkfrontend.services.LoveCalculatorService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("loveCalculatorView")
public class LoveCalculatorView extends VerticalLayout {

    private LoveCalculatorService loveCalculatorService = new LoveCalculatorService();
  //  private Grid<LoveCalculatorDto> gridLove = new Grid<>(LoveCalculatorDto.class);
    private LoveCalculatorForm loveCalculatorForm = new LoveCalculatorForm(this);
    private Button goToMotiveView = new Button("Go to Motives!");
    private Button goToQuoteView = new Button("Go to Quotes!");

    private Label labelLoveCalculator = new Label("Love Calculator");


 /*   public Grid<LoveCalculatorDto> getGridLove() {
        return gridLove;
    }*/

    public LoveCalculatorView(){
        //gridLove.setColumns("fname", "sname", "percentage", "result");

        VerticalLayout mainLoveContent = new VerticalLayout(loveCalculatorForm);
        mainLoveContent.setSizeFull();
        //gridLove.setSizeFull();

        goToMotiveView.addThemeVariants(ButtonVariant.LUMO_SMALL);
        goToMotiveView.addClickListener(event -> goToMotiveView.getUI().ifPresent(ui -> ui.navigate("motiveView")));

        goToQuoteView.addThemeVariants(ButtonVariant.LUMO_SMALL);
        goToQuoteView.addClickListener(event -> goToQuoteView.getUI().ifPresent(ui -> ui.navigate("quotesView")));


        add(labelLoveCalculator);

        add(mainLoveContent);
        add(goToMotiveView);
        add(goToQuoteView);
        setSizeFull();



        // refreshLove();
        //gridLove.asSingleSelect().addValueChangeListener(event -> loveForm.setLoveDto(gridLove.asSingleSelect().getValue()));

    }

/*    public void refreshLove(){
        gridLove.setItems(loveCalculatorService.setLoveNull());
    }*/
}
