package com.kodilla.eprojectkfrontend.forms;

import com.kodilla.eprojectkfrontend.domains.QuotesDto;
import com.kodilla.eprojectkfrontend.services.QuotesService;
import com.kodilla.eprojectkfrontend.views.QuotesView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class QuotesForm extends FormLayout {

    private QuotesView quotesView;
    private Button resultTypeKeywordButton= new Button("What are the odds?");

    private TextField keywords = new TextField("Type KEYWORD to gain quotes about it! For example: Wisdom");

    private QuotesDto quotesDto = new QuotesDto();

    private Binder<QuotesDto> binder = new Binder<>(QuotesDto.class);

    private QuotesService quotesService = new QuotesService();

    private TextArea resultTypeKeywordTextAre = new TextArea();
    private TextArea tutorial = new TextArea();

    public QuotesForm(QuotesView quotesView) {
        this.quotesView = quotesView;

        HorizontalLayout buttons = new HorizontalLayout(resultTypeKeywordButton);
        resultTypeKeywordButton.addThemeVariants(ButtonVariant.LUMO_SUCCESS);

        add(keywords, buttons);

        binder.bindInstanceFields(this);
        binder.setBean(quotesDto);

        resultTypeKeywordTextAre.setReadOnly(true);

        tutorial.setReadOnly(true);
        tutorial.setAutofocus(true);
        tutorial.setValue("Get random inspirigin quote for a day or get one with your keyword!");

        add(resultTypeKeywordTextAre);
        add(tutorial);


        resultTypeKeywordButton.addClickListener(event -> resultTypeKeywordTextAre.setValue(getQuoteByKeyword()));

    }


    public String getQuoteByKeyword(){
        QuotesDto quotesDto = binder.getBean();
        return quotesService.getQuoteByKeyword(quotesDto).toString();
    }

    public void setQuotesDto(QuotesDto quotesDto) {
        binder.setBean(quotesDto);
    }
}