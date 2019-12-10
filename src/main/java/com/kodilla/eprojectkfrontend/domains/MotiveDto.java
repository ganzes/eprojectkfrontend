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
public class MotiveDto {

    @JsonProperty("motiveID")
    private Long motiveID;
    @JsonProperty("motiveText")
    private String motiveText;
    @JsonProperty("motiveAuthor")
    private String motiveAuthor;
    @JsonProperty("motiveRating")
    private String motiveRating;
    @JsonProperty("motiveCreated")
    private LocalDate motiveCreated;
}
