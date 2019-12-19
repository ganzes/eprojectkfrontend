package com.kodilla.eprojectkfrontend.services;

import com.kodilla.eprojectkfrontend.domains.MovieDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieService.class);

    private RestTemplate restTemplate = new RestTemplate();

    public List<MovieDto> getAllMovie() throws HttpServerErrorException {
        List<MovieDto> movieDtoList = new ArrayList<>();
        MovieDto[] allMovieList = restTemplate.getForObject("http://localhost:8080/eprojectk/movie/getMovies", MovieDto[].class);

        for (int i = 0; i < allMovieList.length; i++) {
            movieDtoList.add(allMovieList[i]);
        }

        return movieDtoList;
    }

    public void createMovie(final MovieDto movieDto) throws HttpServerErrorException {
        try {
            URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/eprojectk/movie/createMovie")
                    .build().encode().toUri();
            restTemplate.postForObject(url, movieDto, MovieDto.class);
        } catch (HttpClientErrorException e) {
            LOGGER.warn("User out of bounds! " + e);
        }
    }

    public void deleteMovie(final Long movieID) throws HttpClientErrorException {
        restTemplate.delete("http://localhost:8080/eprojectk/movie/deleteMovie?movieID=" + movieID);
    }

    public void updateMovie(final MovieDto movieDto) throws HttpServerErrorException {
        try {
            restTemplate.put("http://localhost:8080/eprojectk/movie/updateMovie", movieDto, MovieDto.class);
        } catch (HttpClientErrorException e) {
            LOGGER.warn("User out of bounds! " + e);
        }
    }

    public void deleteAllMovies() throws HttpServerErrorException {
        restTemplate.delete("http://localhost:8080/eprojectk/movie/deleteAllMovies");
    }

    public List<MovieDto> findMovieByDirector(final String author) throws HttpServerErrorException {
        List<MovieDto> movieDtoList = new ArrayList<>();

        MovieDto[] allMovieList = restTemplate.getForObject("http://localhost:8080/eprojectk/movie/getMovieByDirector?movieDirector=" + author, MovieDto[].class);

        for (int i = 0; i < allMovieList.length; i++) {
            movieDtoList.add(allMovieList[i]);
        }
        return movieDtoList;
    }

    public List<MovieDto> findMovieByRating(final String movieRating) throws HttpServerErrorException {
        List<MovieDto> movieDtoList = new ArrayList<>();

        MovieDto[] allMovieList = restTemplate.getForObject("http://localhost:8080/eprojectk/movie/getMovieByRating?movieRating=" + movieRating, MovieDto[].class);

        for (int i = 0; i < allMovieList.length; i++) {
            movieDtoList.add(allMovieList[i]);
        }
        return movieDtoList;
    }

    public Long countAllMovies() throws NullPointerException {
        long allMovie = restTemplate.getForObject("http://localhost:8080/eprojectk/movie/countAllMovies", Long.class);
        return allMovie;
    }
}