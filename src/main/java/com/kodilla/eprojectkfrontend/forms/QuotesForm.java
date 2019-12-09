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
    private Button resultTypeKeywordButton= new Button("Typed your keyword? Click me.");
    private Button resultRandomQuoteButton = new Button(" Get random quote!");

    private TextField keywords = new TextField("Type a specific keyword to search quotes about it. Example: Wisdom.");

    private QuotesDto quotesDto = new QuotesDto();

    private Binder<QuotesDto> binder = new Binder<>(QuotesDto.class);

    private QuotesService quotesService = new QuotesService();

    private TextArea resultTypeKeywordTextAre = new TextArea();
    private TextArea resultRandomQuoteTextArea = new TextArea();
    private TextArea tutorial = new TextArea();

    public QuotesForm(QuotesView quotesView) {
        this.quotesView = quotesView;

        tutorial.setReadOnly(true);
        tutorial.setAutofocus(true);
        tutorial.setWidthFull();
        tutorial.setValue("Get some inspiration by either:\n- typing your own keyword,\n- or get one randomly,\n" +
                "from over +15000 quotes!");

        HorizontalLayout buttons = new HorizontalLayout(resultTypeKeywordButton, resultRandomQuoteButton);
        resultTypeKeywordButton.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        resultRandomQuoteButton.addThemeVariants(ButtonVariant.LUMO_SUCCESS);

        add(keywords, buttons);

        binder.bindInstanceFields(this);
        binder.setBean(quotesDto);

        resultTypeKeywordTextAre.setErrorMessage("Cannot be empty, or it won't work. Oh, and we honor Capital letters.");
        resultTypeKeywordTextAre.setReadOnly(true);
        resultRandomQuoteTextArea.setReadOnly(true);



        add(resultTypeKeywordTextAre);
        add(resultRandomQuoteTextArea);
        add(tutorial);


        resultTypeKeywordButton.addClickListener(event -> resultTypeKeywordTextAre.setValue(getQuoteByKeyword()));
        resultRandomQuoteButton.addClickListener(event -> resultRandomQuoteTextArea.setValue(getRandomQuote()));
    }


    public String getQuoteByKeyword(){
        QuotesDto quotesDto = binder.getBean();
        return quotesService.getQuoteByKeyword(quotesDto).toString();
    }

    public String getRandomQuote(){
       // QuotesDto quotesDto = binder.getBean();
        return quotesService.getRandomQuote().toString();

    }

    public void setQuotesDto(QuotesDto quotesDto) {
        binder.setBean(quotesDto);
    }
}