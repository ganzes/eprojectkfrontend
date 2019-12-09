package com.kodilla.eprojectkfrontend.services;

import com.kodilla.eprojectkfrontend.domains.LoveCalculatorDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class LoveCalculatorService {

    private RestTemplate restTemplate = new RestTemplate();

    public LoveCalculatorDto getPercentage(final LoveCalculatorDto loveCalculatorDto){
        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/eprojectk/lc/?fname=" + loveCalculatorDto.getFname() + "&sname=" + loveCalculatorDto.getSname())
                .build().encode().toUri();
        LoveCalculatorDto loveCalculatorDto1 = restTemplate.getForObject(url, LoveCalculatorDto.class);
        return loveCalculatorDto1;
    }

    public LoveCalculatorDto setLoveNull(){
        LoveCalculatorDto loveCalculatorDto = new LoveCalculatorDto();
        loveCalculatorDto.setFname(null);
        loveCalculatorDto.setSname(null);
        loveCalculatorDto.setPercentage(null);
        loveCalculatorDto.setResult(null);
        return loveCalculatorDto;
    }
}