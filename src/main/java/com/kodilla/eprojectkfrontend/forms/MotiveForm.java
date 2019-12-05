package com.kodilla.eprojectkfrontend.forms;

import com.kodilla.eprojectkfrontend.MainView;
import com.kodilla.eprojectkfrontend.domains.MotiveDto;
import com.kodilla.eprojectkfrontend.services.MotiveService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

import java.awt.*;
import java.awt.print.Book;

public class MotiveForm extends FormLayout {
    private MainView mainView;

    private TextField motiveText = new TextField("motiveText");
    private TextField motiveAuthor = new TextField("motiveAuthor");
    private TextField motiveRating = new TextField("motiveRating");

    private Button saveMotive = new Button("Add");
    private Button deleteMotive = new Button("Delete");

    private Binder<MotiveDto> binder = new Binder<>(MotiveDto.class);

    private MotiveService motiveService = new MotiveService();

    private MotiveDto motiveDto = new MotiveDto();

    public MotiveForm(MainView mainView){
        this.mainView = mainView;

        HorizontalLayout buttons = new HorizontalLayout(saveMotive, deleteMotive);
        saveMotive.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        deleteMotive.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(motiveText, motiveAuthor, motiveRating, buttons);

        binder.bindInstanceFields(this);
        binder.setBean(motiveDto);


       saveMotive.addClickListener(event -> saveMotive());
       deleteMotive.addClickListener(event -> deleteMotive());
    }

    private void saveMotive(){
        MotiveDto motiveDto = binder.getBean();
        motiveService.createMotive(motiveDto);
        mainView.refresh();
    }

    private void deleteMotive(){
        MotiveDto motiveDto = binder.getBean();
        motiveService.deleteMotive(motiveDto.getMotiveID());

        mainView.refresh();
    }

    public void setMotiveDto(MotiveDto motiveDto) {
        binder.setBean(motiveDto);
    }
}