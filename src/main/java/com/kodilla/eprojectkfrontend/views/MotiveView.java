package com.kodilla.eprojectkfrontend.views;

import com.kodilla.eprojectkfrontend.domains.MotiveDto;
import com.kodilla.eprojectkfrontend.forms.MotiveForm;
import com.kodilla.eprojectkfrontend.services.MotiveService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("motiveView")
public class MotiveView extends VerticalLayout {

    private MotiveService motiveService = new MotiveService();
    private Grid<MotiveDto> gridMotiveDto = new Grid<>(MotiveDto.class);
    private Button goToLoveView = new Button("Go got Love Calculator!");
    private MotiveForm motiveForm = new MotiveForm(this);

    public Grid<MotiveDto> getGridMotiveDto() {
        return gridMotiveDto;
    }

    public MotiveView(){
        gridMotiveDto.setColumns("motiveText", "motiveAuthor", "motiveRating");
        HorizontalLayout mainContent = new HorizontalLayout(gridMotiveDto, motiveForm );
        mainContent.setSizeFull();
        gridMotiveDto.setSizeFull();

        goToLoveView.addClickListener(event -> goToLoveView.getUI().ifPresent(ui -> ui.navigate("loveCalculatorView")));

        //gridMotiveDto.setItems(motiveService.getAllMotive());
        //System.out.println("TUTAJ!!" + motiveService.getAllMotive());
        add(mainContent);
        add(goToLoveView);
        setSizeFull();
        refresh();

        gridMotiveDto.asSingleSelect().addValueChangeListener(event -> motiveForm.setMotiveDto(gridMotiveDto.asSingleSelect().getValue()));
    }

    public void refresh(){
        gridMotiveDto.setItems(motiveService.getAllMotive());
    }

}
