package com.kodilla.eprojectkfrontend.services;

import com.kodilla.eprojectkfrontend.domains.LoveCalculatorDto;
import com.kodilla.eprojectkfrontend.domains.QuotesDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class QuotesService {

    private RestTemplate restTemplate = new RestTemplate();


    public QuotesDto getQuoteByKeyword(final QuotesDto quotesDto){
        URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/eprojectk/quotes/?keyword=" + quotesDto.getKeywords())
                .build().encode().toUri();
        QuotesDto quotesDto1 = restTemplate.getForObject(uri, QuotesDto.class);
        return quotesDto1;
    }


    public QuotesDto getRandomQuote(){
        URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/eprojectk/quotes/getRandom")
                .build().encode().toUri();
        QuotesDto quotesDto1 = restTemplate.getForObject(uri, QuotesDto.class);
        return quotesDto1;
    }

    public QuotesDto setQuotesNull() {
        QuotesDto quotesDto = new QuotesDto();
        quotesDto.setMessage(null);
        quotesDto.setAuthor(null);
        quotesDto.setKeywords(null);
        quotesDto.setProfession(null);
        quotesDto.setNationality(null);
        quotesDto.setAuthorBirth(null);
        quotesDto.setAuthorDeath(null);


        return quotesDto;
    }

}
