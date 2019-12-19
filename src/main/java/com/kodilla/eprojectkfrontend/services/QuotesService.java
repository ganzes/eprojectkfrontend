package com.kodilla.eprojectkfrontend.services;

import com.kodilla.eprojectkfrontend.domains.QuotesDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class QuotesService {

    private RestTemplate restTemplate = new RestTemplate();

    public QuotesDto getQuoteByKeyword(final QuotesDto quotesDto) throws HttpServerErrorException {
        URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/eprojectk/quotes/?keyword=" + quotesDto.getKeywords())
                .build().encode().toUri();

        QuotesDto quotesDto1 = restTemplate.getForObject(uri, QuotesDto.class);
        return quotesDto1;
    }

    public QuotesDto getQuoteByAuthor(final QuotesDto quotesDto) throws HttpServerErrorException {
        URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/eprojectk/quotes/byAuthor?author=" + quotesDto.getAuthor())
                .build().encode().toUri();

        QuotesDto quotesDto1 = restTemplate.getForObject(uri, QuotesDto.class);
        return quotesDto1;
    }

    public QuotesDto getRandomQuote() throws HttpServerErrorException {
        URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/eprojectk/quotes/getRandom")
                .build().encode().toUri();
        QuotesDto quotesDto1 = restTemplate.getForObject(uri, QuotesDto.class);
        return quotesDto1;
    }
}
