package com.kodilla.eprojectkfrontend.services;

import com.kodilla.eprojectkfrontend.domains.MovieDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

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
        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/eprojectk/movie/createMovie")
                .build().encode().toUri();
        restTemplate.postForObject(url, movieDto, MovieDto.class);
    }

    public void deleteMovie(final Long movieID) throws HttpServerErrorException {
        restTemplate.delete("http://localhost:8080/eprojectk/movie/deleteMovie?movieID=" + movieID);
    }

    public void updateMovie(final MovieDto movieDto) throws HttpServerErrorException {
        restTemplate.put("http://localhost:8080/eprojectk/movie/updateMovie", movieDto, MovieDto.class);
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