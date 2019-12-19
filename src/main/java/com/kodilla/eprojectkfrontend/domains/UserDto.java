package com.kodilla.eprojectkfrontend.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

    @JsonProperty("userID")
    private Long userID;

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("userLastname")
    private String userLastname;

    @Override
    public String toString() {
        return "UserDto{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", userLastname='" + userLastname + '\'' +
                '}';
    }
}