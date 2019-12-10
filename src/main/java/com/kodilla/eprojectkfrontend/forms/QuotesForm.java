package com.kodilla.eprojectkfrontend.forms;

import com.kodilla.eprojectkfrontend.domains.QuotesDto;
import com.kodilla.eprojectkfrontend.services.QuotesService;
import com.kodilla.eprojectkfrontend.views.QuotesView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class QuotesForm extends FormLayout {

    private QuotesView quotesView;
    private Button resultTypeKeywordButton= new Button("Typed your keyword? Click me.");
    private Button resultRandomQuoteButton = new Button(" Get random quote!");
    private Button resultTypeAuthorButton= new Button("Typed your Author? Click me.");


    private TextField keywords = new TextField("Type a specific keyword to search quotes about it. Example: Wisdom.");
    private TextField authors = new TextField("Type a name to search quotes from him/her. Example: Erich von Stroheim.");


    private QuotesDto quotesDto = new QuotesDto();

    private Binder<QuotesDto> binder = new Binder<>(QuotesDto.class);

    private QuotesService quotesService = new QuotesService();

    private TextArea resultTypeKeywordTextAre = new TextArea();
    private TextArea resultRandomQuoteTextArea = new TextArea();
    private TextArea resultTypeAuthorTextAre = new TextArea();

    private TextArea tutorial = new TextArea();

    public QuotesForm(QuotesView quotesView) {
        this.quotesView = quotesView;

        tutorial.setReadOnly(true);
        tutorial.setAutofocus(true);
        tutorial.setWidthFull();
        tutorial.setValue("Get some inspiration by either:\n- typing your own keyword,\n- or get one randomly,\n" +
                "from over +15000 quotes!");

        VerticalLayout buttons = new VerticalLayout(resultTypeKeywordButton, resultRandomQuoteButton, resultTypeAuthorButton);
        resultTypeKeywordButton.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        resultRandomQuoteButton.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        resultTypeAuthorButton.addThemeVariants(ButtonVariant.LUMO_SUCCESS);


        add(keywords, authors, buttons);

        binder.bindInstanceFields(this);
        binder.setBean(quotesDto);

        resultTypeKeywordTextAre.setErrorMessage("Cannot be empty, or it won't work. Oh, and we honor Capital letters.");
        resultTypeKeywordTextAre.setReadOnly(true);
        resultRandomQuoteTextArea.setReadOnly(true);
        resultTypeAuthorTextAre.setReadOnly(true);

        add(resultTypeKeywordTextAre);
        add(resultRandomQuoteTextArea);
        add(resultTypeAuthorTextAre);
        add(tutorial);


        resultTypeKeywordButton.addClickListener(event -> resultTypeKeywordTextAre.setValue(getQuoteByKeyword()));
        resultRandomQuoteButton.addClickListener(event -> resultRandomQuoteTextArea.setValue(getRandomQuote()));
        resultTypeAuthorButton.addClickListener(event -> resultTypeAuthorTextAre.setValue(getQuoteByAuthor()));
    }


    public String getQuoteByKeyword(){
        QuotesDto quotesDto = binder.getBean();
        return quotesService.getQuoteByKeyword(quotesDto).toString();
    }

    public String getRandomQuote(){
       // QuotesDto quotesDto = binder.getBean();
        return quotesService.getRandomQuote().toString();
    }

    public String getQuoteByAuthor(){
        QuotesDto quotesDto = binder.getBean();
        return quotesService.getQuoteByAuthor(quotesDto).toString();
    }

    public void setQuotesDto(QuotesDto quotesDto) {
        binder.setBean(quotesDto);
    }
}