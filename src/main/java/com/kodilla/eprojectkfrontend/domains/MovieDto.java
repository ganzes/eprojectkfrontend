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
public class MovieDto {

    @JsonProperty("movieID")
    private long movieID;
    @JsonProperty("movieTitle")
    private String movieTitle;
    @JsonProperty("movieDirector")
    private String movieDirector;
    @JsonProperty("movieRating")
    private String movieRating;
    @JsonProperty("movieCreated")
    private LocalDate movieCreated;

}