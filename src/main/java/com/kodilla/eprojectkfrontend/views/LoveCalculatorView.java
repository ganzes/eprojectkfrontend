package com.kodilla.eprojectkfrontend.views;

import com.kodilla.eprojectkfrontend.domains.LoveCalculatorDto;
import com.kodilla.eprojectkfrontend.forms.LoveCalculatorForm;
import com.kodilla.eprojectkfrontend.services.LoveCalculatorService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("love")
public class LoveCalculatorView extends VerticalLayout {

    private LoveCalculatorService loveCalculatorService = new LoveCalculatorService();
    private Grid<LoveCalculatorDto> gridLove = new Grid<>(LoveCalculatorDto.class);
    private LoveCalculatorForm loveCalculatorForm = new LoveCalculatorForm(this);

    public Grid<LoveCalculatorDto> getGridLove() {
        return gridLove;
    }

    public LoveCalculatorView(){
        gridLove.setColumns("fname", "sname", "percentage", "result");

        VerticalLayout mainLoveContent = new VerticalLayout(loveCalculatorForm);
        mainLoveContent.setSizeFull();
        //gridLove.setSizeFull();

        add(mainLoveContent);
        setSizeFull();

        // refreshLove();
        //gridLove.asSingleSelect().addValueChangeListener(event -> loveForm.setLoveDto(gridLove.asSingleSelect().getValue()));

    }

    public void refreshLove(){
        gridLove.setItems(loveCalculatorService.setLoveNull());
    }
}
