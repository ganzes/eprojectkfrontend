package com.kodilla.eprojectkfrontend.forms;

import com.kodilla.eprojectkfrontend.domains.BookDto;
import com.kodilla.eprojectkfrontend.services.BookService;
import com.kodilla.eprojectkfrontend.views.BookView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class BookForm  extends FormLayout {

    private BookView bookView;

    private TextField bookTitle = new TextField("Title");
    private TextField bookAuthor = new TextField("Author");
    private TextField bookRating = new TextField("Rating");

    private Button saveBook = new Button("Add");
    private Button deleteBook = new Button("Delete");
    private Button updateBook = new Button("Update");
    private Button deleteAllBooks = new Button("Delete All");
    private Button findBookByAuthor = new Button("Find by Author");
    private Button findBookByRating = new Button("Find by Rating");


    private Binder<BookDto> binder = new Binder<>(BookDto.class);

    private BookService bookService = new BookService();

    private BookDto bookDto = new BookDto();

    public BookForm(BookView bookView) {
        this.bookView = bookView;

        HorizontalLayout buttons = new HorizontalLayout(saveBook, deleteBook, updateBook, deleteAllBooks);
        HorizontalLayout buttonsSecondRow = new HorizontalLayout(findBookByAuthor, findBookByRating);

        saveBook.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        deleteBook.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        updateBook.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        deleteAllBooks.addThemeVariants(ButtonVariant.LUMO_ERROR);
        findBookByAuthor.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        findBookByRating.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        add(bookTitle, bookAuthor, bookRating, buttons, buttonsSecondRow);

        binder.bindInstanceFields(this);
        binder.setBean(bookDto);

        saveBook.addClickListener(event -> saveBook());
        deleteBook.addClickListener(event -> deleteBook());
        updateBook.addClickListener(event -> updateBook());
        deleteAllBooks.addClickListener(event -> deleteAllBooks());

        findBookByAuthor.addClickListener(event -> findBookByAuthor());
        findBookByRating.addClickListener(event -> findBookByRating());
    }

    private void saveBook() {
        BookDto bookDto = binder.getBean();
        bookService.createBook(bookDto);
        bookView.refresh();
    }

    private void deleteBook() {
        BookDto bookDto = binder.getBean();
        bookService.deleteBook(bookDto.getBookID());
        bookView.refresh();
    }

    private void deleteAllBooks() {
        bookService.deleteAllBooks();
        bookView.refresh();
    }

    public void updateBook() {
        BookDto bookDto = binder.getBean();
        bookService.updateBook(bookDto);
        bookView.refresh();
    }

    public void findBookByAuthor(){
        String bookDto = binder.getBean().getBookAuthor();
        bookService.findBookByAuthor(bookDto);
        bookView.refreshByAllAuthors(bookDto);
    }

    public void findBookByRating(){
        String bookDto = binder.getBean().getBookRating();
        bookService.findBookByRating(bookDto);
        bookView.refreshByAllRatings(bookDto);
    }

    public void setBookDto(BookDto bookDto) {
        binder.setBean(bookDto);
    }
}