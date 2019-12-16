package com.kodilla.eprojectkfrontend.services;

import com.kodilla.eprojectkfrontend.domains.BookDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private RestTemplate restTemplate = new RestTemplate();

    public List<BookDto> getAllBook() {
        List<BookDto> bookDtoList = new ArrayList<>();
        BookDto[] allBookList = restTemplate.getForObject("http://localhost:8080/eprojectk/book/getBooks", BookDto[].class);

        for (int i = 0; i < allBookList.length; i++) {
            bookDtoList.add(allBookList[i]);
        }

        return bookDtoList;
    }

    public void createBook(final BookDto bookDto) {
        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/eprojectk/book/createBook")
                .build().encode().toUri();
        restTemplate.postForObject(url, bookDto, BookDto.class);
    }

    public void deleteBook(final Long bookID) {
        restTemplate.delete("http://localhost:8080/eprojectk/book/deleteBook?bookID=" + bookID);
    }

    public void updateBook(final BookDto bookDto) {
        restTemplate.put("http://localhost:8080/eprojectk/book/updateBook", bookDto, BookDto.class);
    }

    public void deleteAllBooks() {
        restTemplate.delete("http://localhost:8080/eprojectk/book/deleteAllBooks");
    }

    public List<BookDto> findBookByAuthor(final String author){
        List<BookDto> bookDtoList = new ArrayList<>();

        BookDto[] allBookList = restTemplate.getForObject("http://localhost:8080/eprojectk/book/getBookByAuthor?bookAuthor=" + author, BookDto[].class);

        for (int i = 0; i < allBookList.length; i++) {
            bookDtoList.add(allBookList[i]);
        }

        return bookDtoList;
    }

    public List<BookDto> findBookByRating(final String bookRating){
        List<BookDto> bookDtoList = new ArrayList<>();

        BookDto[] allBookList = restTemplate.getForObject("http://localhost:8080/eprojectk/book/getBookByRating?bookRating=" + bookRating, BookDto[].class);

        for (int i = 0; i < allBookList.length; i++) {
            bookDtoList.add(allBookList[i]);
        }

        return bookDtoList;
    }

    public  Long countAllBooks() throws NullPointerException {
        long allBook = restTemplate.getForObject("http://localhost:8080/eprojectk/book/countAllBooks", Long.class);
        return allBook;
    }
}
