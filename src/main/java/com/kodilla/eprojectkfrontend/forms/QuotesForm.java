package com.kodilla.eprojectkfrontend.forms;

import com.kodilla.eprojectkfrontend.domains.QuotesDto;
import com.kodilla.eprojectkfrontend.services.QuotesService;
import com.kodilla.eprojectkfrontend.views.QuotesView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class QuotesForm extends FormLayout {

    private QuotesView quotesView;
    private Button resultTypeKeywordButton = new Button("Typed your 'Keyword'? Click me.");
    private Button resultRandomQuoteButton = new Button(" Get random quote!");
    private Button resultTypeAuthorButton = new Button("Typed your 'Author'? Click me.");

    private TextField keywords = new TextField("Type a specific keyword to search quotes about it. Example: Wisdom.");
    private TextField author = new TextField("Type a name to search quotes from him/her. Example: Erich von Stroheim.");

    private QuotesDto quotesDto = new QuotesDto();

    private Binder<QuotesDto> binder = new Binder<>(QuotesDto.class);

    private QuotesService quotesService = new QuotesService();

    private TextArea resultTypeKeywordTextArea = new TextArea();
    private TextArea resultTypeAuthorTextArea = new TextArea();
    private TextArea resultRandomQuoteTextArea = new TextArea();

    public QuotesForm(QuotesView quotesView) {
        this.quotesView = quotesView;

        binder.bindInstanceFields(this);
        binder.setBean(quotesDto);

        resultTypeKeywordButton.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        resultRandomQuoteButton.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        resultTypeAuthorButton.addThemeVariants(ButtonVariant.LUMO_SUCCESS);

        resultTypeAuthorTextArea.setLabel("Result based on the author's name:");
        resultTypeAuthorTextArea.setReadOnly(true);

        resultTypeKeywordTextArea.setLabel("Result based upon your 'keywords:");
        resultTypeKeywordTextArea.setReadOnly(true);

        resultRandomQuoteTextArea.setLabel("Random quote:");
        resultRandomQuoteTextArea.setReadOnly(true);

        resultTypeKeywordButton.addClickListener(event -> resultTypeKeywordTextArea.setValue(getQuoteByKeyword()));
        resultRandomQuoteButton.addClickListener(event -> resultRandomQuoteTextArea.setValue(getRandomQuote()));
        resultTypeAuthorButton.addClickListener(event -> resultTypeAuthorTextArea.setValue(getQuoteByAuthor()));

        add(keywords, author);
        add(resultTypeKeywordButton);
        add(resultTypeKeywordTextArea);
        add(resultTypeAuthorButton);
        add(resultTypeAuthorTextArea);
        add(resultRandomQuoteButton);
        add(resultRandomQuoteTextArea);
    }

    public String getQuoteByKeyword() {
        QuotesDto quotesDto = binder.getBean();
        return quotesService.getQuoteByKeyword(quotesDto).toString();
    }

    public String getQuoteByAuthor() {
        QuotesDto quotesDto = binder.getBean();
        return quotesService.getQuoteByAuthor(quotesDto).toString();
    }

    public String getRandomQuote() {
        return quotesService.getRandomQuote().toString();
    }
}
/*
    public void setQuotesDto(QuotesDto quotesDto) {
        binder.setBean(quotesDto);
    }
}*/
