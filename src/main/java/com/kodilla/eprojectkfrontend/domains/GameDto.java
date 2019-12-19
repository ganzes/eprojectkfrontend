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
public class GameDto {

    @JsonProperty("gameID")
    private long gameID;

    @JsonProperty("gameTitle")
    private String gameTitle;

    @JsonProperty("gameDeveloper")
    private String gameDeveloper;

    @JsonProperty("gameRating")
    private String gameRating;

    @JsonProperty("gameCreated")
    private LocalDate gameCreated;
}