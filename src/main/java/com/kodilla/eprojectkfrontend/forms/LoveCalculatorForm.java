package com.kodilla.eprojectkfrontend.forms;

import com.kodilla.eprojectkfrontend.domains.LoveCalculatorDto;
import com.kodilla.eprojectkfrontend.services.LoveCalculatorService;
import com.kodilla.eprojectkfrontend.views.LoveCalculatorView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class LoveCalculatorForm extends FormLayout {

    private LoveCalculatorView loveCalculatorView;

    private TextField fname = new TextField("Type first name");
    private TextField sname = new TextField("Type second name");

    private Button result = new Button("What are the odds?");

    private Binder<LoveCalculatorDto> binder = new Binder<>(LoveCalculatorDto.class);

    private LoveCalculatorService loveCalculatorService = new LoveCalculatorService();

    private LoveCalculatorDto loveCalculatorDto = new LoveCalculatorDto();

    private TextArea resultGetPercentage = new TextArea();

    private TextArea tutorialLoveCalculator = new TextArea();

    public LoveCalculatorForm(LoveCalculatorView loveCalculatorView) {
        this.loveCalculatorView = loveCalculatorView;

        HorizontalLayout buttons = new HorizontalLayout(result);
        result.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        add(fname, sname, buttons);
        binder.bindInstanceFields(this);
        binder.setBean(loveCalculatorDto);
        resultGetPercentage.setReadOnly(true);
        tutorialLoveCalculator.setReadOnly(true);
        tutorialLoveCalculator.setValue("Ever wonder who of your closest friends have a shot at love? " +
                "Just type their names and find out! Be patient! Third party API needs some time to work!");
        tutorialLoveCalculator.setAutofocus(true);
        add(tutorialLoveCalculator);
        add(resultGetPercentage);
        //result.addClickListener(event -> Notification.show(getPercentage()));
        result.addClickListener(event -> resultGetPercentage.setValue(getPercentage()));
    }

    public String getPercentage() {
        LoveCalculatorDto loveCalculatorDto = binder.getBean();
        //loveCalculatorView.refreshLove();
        return loveCalculatorService.getPercentage(loveCalculatorDto).toString();
    }

    public void setLoveDto(LoveCalculatorDto loveCalculatorDto) {
        binder.setBean(loveCalculatorDto);
    }
}
