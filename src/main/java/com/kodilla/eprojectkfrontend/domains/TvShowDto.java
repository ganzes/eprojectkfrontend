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
public class TvShowDto {

    @JsonProperty("tvShowID")
    private long tvShowID;
    
    @JsonProperty("tvShowTitle")
    private String tvShowTitle;
    
    @JsonProperty("tvShowCategory")
    private String tvShowCategory;
    
    @JsonProperty("tvShowRating")
    private String tvShowRating;
    
    @JsonProperty("tvShowCreated")
    private LocalDate tvShowCreated;
}