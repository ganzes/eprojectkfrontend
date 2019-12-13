package com.kodilla.eprojectkfrontend.views;

import com.kodilla.eprojectkfrontend.domains.BookDto;
import com.kodilla.eprojectkfrontend.forms.BookForm;
import com.kodilla.eprojectkfrontend.forms.BookForm;
import com.kodilla.eprojectkfrontend.services.BookService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;

@Route("bookView")
public class BookView extends VerticalLayout {

    private BookService bookService = new BookService();
    private Grid<BookDto> gridBookDto = new Grid<>(BookDto.class);
    private Grid<BookDto> gridSearchResult = new Grid<>(BookDto.class);

    private Button goToLoveView = new Button("Go to Love Calculator!");
    private Button goToQuoteView = new Button("Go to Quotes!");
    private Button goToMotiveView = new Button("Go to Motives!");


    private BookForm bookForm = new BookForm(this);

    private Label labelBookView = new Label("Books");
    private Label gridBookDtoLabel = new Label("Main view from Books");
    private Label gridSearchResultLabel = new Label("Search results from Books");


    private TextArea tutorialBooks = new TextArea();

    public Grid<BookDto> getGridBookDto() {
        return gridBookDto;
    }

    public Grid<BookDto> gridSearchResult() {
        return gridSearchResult;
    }

    public BookView(){
        gridBookDto.setColumns("bookTitle", "bookAuthor", "bookRating");
        gridSearchResult.setColumns("bookTitle", "bookAuthor", "bookRating");

        HorizontalLayout sercondContent = new HorizontalLayout(gridSearchResult, bookForm);
        sercondContent.setSizeFull();
        HorizontalLayout mainContent = new HorizontalLayout(gridBookDtoLabel, gridBookDto);
        mainContent.setSizeFull();
        gridBookDto.setSizeFull();
        gridSearchResult.setSizeFull();

        goToLoveView.addThemeVariants(ButtonVariant.LUMO_SMALL);
        goToLoveView.addClickListener(event -> goToLoveView.getUI().ifPresent(ui -> ui.navigate("loveCalculatorView")));

        goToQuoteView.addThemeVariants(ButtonVariant.LUMO_SMALL);
        goToQuoteView.addClickListener(event -> goToQuoteView.getUI().ifPresent(ui -> ui.navigate("quotesView")));

        goToMotiveView.addThemeVariants(ButtonVariant.LUMO_SMALL);
        goToMotiveView.addClickListener(event -> goToMotiveView.getUI().ifPresent(ui -> ui.navigate("motiveView")));

        HorizontalLayout goTos = new HorizontalLayout(goToMotiveView, goToLoveView, goToQuoteView);

        tutorialBooks.setReadOnly(true);
        tutorialBooks.setValue("Add your favourite books, and rate them! When in doubt, refresh page!");
        tutorialBooks.setAutofocus(true);
        tutorialBooks.setWidthFull();

        add(goTos);
        add(labelBookView);
        add(tutorialBooks);

        add(mainContent);
        add(gridSearchResultLabel);
        add(sercondContent);
        setSizeFull();
        refresh();

        gridBookDto.asSingleSelect().addValueChangeListener(event -> bookForm.setBookDto(gridBookDto.asSingleSelect().getValue()));
        gridSearchResult.asSingleSelect().addValueChangeListener(event -> bookForm.setBookDto(gridSearchResult.asSingleSelect().getValue()));

    }

    public void refresh(){
        gridBookDto.setItems(bookService.getAllBook());
    }

    public void refreshByAllAuthors(String author){
        gridSearchResult.setItems(bookService.findBookByAuthor(author));
    }

    public void refreshByAllRatings(String bookRating){
        gridSearchResult.setItems(bookService.findBookByRating(bookRating));
    }
}
