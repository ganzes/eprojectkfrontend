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
    //private Button saveResultToFile = new Button("Save your results to file!");

    private Binder<LoveCalculatorDto> binder = new Binder<>(LoveCalculatorDto.class);

    private LoveCalculatorService loveCalculatorService = new LoveCalculatorService();

    private LoveCalculatorDto loveCalculatorDto = new LoveCalculatorDto();

    private TextArea resultGetPercentage = new TextArea();

    public LoveCalculatorForm(LoveCalculatorView loveCalculatorView) {
        this.loveCalculatorView = loveCalculatorView;

        binder.bindInstanceFields(this);
        binder.setBean(loveCalculatorDto);

        result.addThemeVariants(ButtonVariant.LUMO_SUCCESS);

        resultGetPercentage.setReadOnly(true);

        result.addClickListener(event -> resultGetPercentage.setValue(getPercentage()));

        add(fname, sname);
        add(result);
        add(resultGetPercentage);

        //HorizontalLayout buttons = new HorizontalLayout(result);
        //saveResultToFile.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        //add(saveResultToFile);

        //saveResultToFile.addClickListener(event -> resultGetPercentage());
    }

    public String getPercentage() {
        LoveCalculatorDto loveCalculatorDto = binder.getBean();
        return loveCalculatorService.getPercentage(loveCalculatorDto).toString();
    }

/*    added for further implementation
    public void resultGetPercentage() {
        loveCalculatorService.exportCSV();
    }*/

/*    public void setLoveDto(LoveCalculatorDto loveCalculatorDto) {
        binder.setBean(loveCalculatorDto);
    }*/
}
