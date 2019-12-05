package com.kodilla.eprojectkfrontend;

import com.kodilla.eprojectkfrontend.domains.MotiveDto;
import com.kodilla.eprojectkfrontend.services.MotiveService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

    private MotiveService motiveService = new MotiveService();
    private Grid<MotiveDto> gridMotiveDto = new Grid<>(MotiveDto.class);


    public MainView(){
        gridMotiveDto.setColumns("motiveID", "motiveText", "motiveAuthor", "motiveRating");
        gridMotiveDto.setItems(motiveService.getAllMotive());
        System.out.println("TUTAJ!!" + motiveService.getAllMotive());
        add(gridMotiveDto);
        setSizeFull();

    }

}
