package com.kodilla.eprojectkfrontend.forms;

import com.kodilla.eprojectkfrontend.domains.LoveCalculatorDto;
import com.kodilla.eprojectkfrontend.services.LoveCalculatorService;
import com.kodilla.eprojectkfrontend.views.LoveCalculatorView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class LoveCalculatorForm extends FormLayout {
    private LoveCalculatorView loveCalculatorView;

    private TextField fname = new TextField("fname");
    private TextField sname = new TextField("sname");


    private Button result = new Button("result");


    private Binder<LoveCalculatorDto> binder = new Binder<>(LoveCalculatorDto.class);

    private LoveCalculatorService loveCalculatorService = new LoveCalculatorService();

    private LoveCalculatorDto loveCalculatorDto = new LoveCalculatorDto();

    public LoveCalculatorForm(LoveCalculatorView loveCalculatorView) {
        this.loveCalculatorView = loveCalculatorView;

        HorizontalLayout buttons = new HorizontalLayout(result);
        result.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(fname, sname, buttons);

        binder.bindInstanceFields(this);
        binder.setBean(loveCalculatorDto);

        //  result.addClickListener(event -> getPercentage());
        result.addClickListener(event -> Notification.show(getPercentage()));

    }


    public String getPercentage() {
        LoveCalculatorDto loveCalculatorDto = binder.getBean();
        String result = loveCalculatorService.getPercentage(loveCalculatorDto).toString();
        loveCalculatorView.refreshLove();
        return result;
    }

    public void setLoveDto(LoveCalculatorDto loveCalculatorDto) {
        binder.setBean(loveCalculatorDto);
    }
}
