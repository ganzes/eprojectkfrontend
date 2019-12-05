package com.kodilla.eprojectkfrontend.services;

import com.kodilla.eprojectkfrontend.domains.MotiveDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class MotiveService {

    public RestTemplate restTemplate = new RestTemplate();

    public List<MotiveDto> getAllMotive(){
        List<MotiveDto> motiveDtoList = new ArrayList<>();
        MotiveDto[] allMotiveList = restTemplate.getForObject("http://localhost:8080/eprojectk/motive/getMotives", MotiveDto[].class);

        for (int i=0; i<allMotiveList.length; i++){
            motiveDtoList.add(allMotiveList[i]);
        }
        return motiveDtoList;
    }
}
