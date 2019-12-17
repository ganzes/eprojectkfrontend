package com.kodilla.eprojectkfrontend.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookDto {

    @JsonProperty("bookID")
    private long bookID;

    @JsonProperty("bookTitle")
    private String bookTitle;

    @JsonProperty("bookAuthor")
    private String bookAuthor;

    @JsonProperty("bookRating")
    private String bookRating;

    @JsonProperty("bookCreated")
    private LocalDate bookCreated;
}
