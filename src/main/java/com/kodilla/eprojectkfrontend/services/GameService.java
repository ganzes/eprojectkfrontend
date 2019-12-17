package com.kodilla.eprojectkfrontend.services;

import com.kodilla.eprojectkfrontend.domains.GameDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    private RestTemplate restTemplate = new RestTemplate();

    public List<GameDto> getAllGame() throws HttpServerErrorException {
        List<GameDto> gameDtoList = new ArrayList<>();
        GameDto[] allGameList = restTemplate.getForObject("http://localhost:8080/eprojectk/game/getGames", GameDto[].class);

        for (int i = 0; i < allGameList.length; i++) {
            gameDtoList.add(allGameList[i]);
        }

        return gameDtoList;
    }

    public void createGame(final GameDto gameDto) throws HttpServerErrorException {
        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/eprojectk/game/createGame")
                .build().encode().toUri();
        restTemplate.postForObject(url, gameDto, GameDto.class);
    }

    public void deleteGame(final Long gameID) throws HttpServerErrorException {
        restTemplate.delete("http://localhost:8080/eprojectk/game/deleteGame?gameID=" + gameID);
    }

    public void updateGame(final GameDto gameDto) throws HttpServerErrorException {
        restTemplate.put("http://localhost:8080/eprojectk/game/updateGame", gameDto, GameDto.class);
    }

    public void deleteAllGames() throws HttpServerErrorException {
        restTemplate.delete("http://localhost:8080/eprojectk/game/deleteAllGames");
    }

    public List<GameDto> findGameByDeveloper(final String author) throws HttpServerErrorException {
        List<GameDto> gameDtoList = new ArrayList<>();

        GameDto[] allGameList = restTemplate.getForObject("http://localhost:8080/eprojectk/game/getGameByDeveloper?gameDeveloper=" + author, GameDto[].class);

        for (int i = 0; i < allGameList.length; i++) {
            gameDtoList.add(allGameList[i]);
        }

        return gameDtoList;
    }

    public List<GameDto> findGameByRating(final String gameRating) throws HttpServerErrorException {
        List<GameDto> gameDtoList = new ArrayList<>();

        GameDto[] allGameList = restTemplate.getForObject("http://localhost:8080/eprojectk/game/getGameByRating?gameRating=" + gameRating, GameDto[].class);

        for (int i = 0; i < allGameList.length; i++) {
            gameDtoList.add(allGameList[i]);
        }

        return gameDtoList;
    }

    public Long countAllGames() throws NullPointerException {
        long allGame = restTemplate.getForObject("http://localhost:8080/eprojectk/game/countAllGames", Long.class);
        return allGame;
    }
}