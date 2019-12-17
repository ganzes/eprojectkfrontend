package com.kodilla.eprojectkfrontend.services;

import com.kodilla.eprojectkfrontend.domains.TvShowDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
public class TvShowService {

    private RestTemplate restTemplate = new RestTemplate();

    public List<TvShowDto> getAllTvShow() throws HttpServerErrorException {
        List<TvShowDto> tvShowDtoList = new ArrayList<>();
        TvShowDto[] allTvShowList = restTemplate.getForObject("http://localhost:8080/eprojectk/tvShow/getTvShows", TvShowDto[].class);

        for (int i = 0; i < allTvShowList.length; i++) {
            tvShowDtoList.add(allTvShowList[i]);
        }

        return tvShowDtoList;
    }

    public void createTvShow(final TvShowDto tvShowDto) throws HttpServerErrorException {
        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/eprojectk/tvShow/createTvShow")
                .build().encode().toUri();
        restTemplate.postForObject(url, tvShowDto, TvShowDto.class);
    }

    public void deleteTvShow(final Long tvShowID) throws HttpServerErrorException {
        restTemplate.delete("http://localhost:8080/eprojectk/tvShow/deleteTvShow?tvShowID=" + tvShowID);
    }

    public void updateTvShow(final TvShowDto tvShowDto) throws HttpServerErrorException {
        restTemplate.put("http://localhost:8080/eprojectk/tvShow/updateTvShow", tvShowDto, TvShowDto.class);
    }

    public void deleteAllTvShows() throws HttpServerErrorException {
        restTemplate.delete("http://localhost:8080/eprojectk/tvShow/deleteAllTvShows");
    }

    public List<TvShowDto> findTvShowByCategory(final String author) throws HttpServerErrorException {
        List<TvShowDto> tvShowDtoList = new ArrayList<>();

        TvShowDto[] allTvShowList = restTemplate.getForObject("http://localhost:8080/eprojectk/tvShow/getTvShowByCategory?tvShowCategory=" + author, TvShowDto[].class);

        for (int i = 0; i < allTvShowList.length; i++) {
            tvShowDtoList.add(allTvShowList[i]);
        }

        return tvShowDtoList;
    }

    public List<TvShowDto> findTvShowByRating(final String tvShowRating) throws HttpServerErrorException {
        List<TvShowDto> tvShowDtoList = new ArrayList<>();

        TvShowDto[] allTvShowList = restTemplate.getForObject("http://localhost:8080/eprojectk/tvShow/getTvShowByRating?tvShowRating=" + tvShowRating, TvShowDto[].class);

        for (int i = 0; i < allTvShowList.length; i++) {
            tvShowDtoList.add(allTvShowList[i]);
        }

        return tvShowDtoList;
    }

    public Long countAllTvShows() throws NullPointerException {
        long allTvShow = restTemplate.getForObject("http://localhost:8080/eprojectk/tvShow/countAllTvShows", Long.class);
        return allTvShow;
    }
}