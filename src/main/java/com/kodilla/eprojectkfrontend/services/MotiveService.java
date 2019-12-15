package com.kodilla.eprojectkfrontend.services;

import com.kodilla.eprojectkfrontend.domains.MotiveDto;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
public class MotiveService {

    private RestTemplate restTemplate = new RestTemplate();

    public List<MotiveDto> getAllMotive() {
        List<MotiveDto> motiveDtoList = new ArrayList<>();
        MotiveDto[] allMotiveList = restTemplate.getForObject("http://localhost:8080/eprojectk/motive/getMotives", MotiveDto[].class);

        for (int i = 0; i < allMotiveList.length; i++) {
            motiveDtoList.add(allMotiveList[i]);
        }

        return motiveDtoList;
    }

    public void createMotive(final MotiveDto motiveDto) {
        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/eprojectk/motive/createMotive")
                .build().encode().toUri();
        restTemplate.postForObject(url, motiveDto, MotiveDto.class);
    }

    public void deleteMotive(final Long motiveID) {
        restTemplate.delete("http://localhost:8080/eprojectk/motive/deleteMotive?motiveID=" + motiveID);
    }

    public void updateMotive(final MotiveDto motiveDto) {
        restTemplate.put("http://localhost:8080/eprojectk/motive/updateMotive", motiveDto, MotiveDto.class);
    }

    public void deleteAllMotives() {
        restTemplate.delete("http://localhost:8080/eprojectk/motive/deleteAllMotives");
    }

    public List<MotiveDto> findMotiveByAuthor(final String author){
        List<MotiveDto> motiveDtoList = new ArrayList<>();

        MotiveDto[] allMotiveList = restTemplate.getForObject("http://localhost:8080/eprojectk/motive/getMotiveByAuthor?motiveAuthor=" + author, MotiveDto[].class);

        for (int i = 0; i < allMotiveList.length; i++) {
            motiveDtoList.add(allMotiveList[i]);
        }

        return motiveDtoList;
    }

    public List<MotiveDto> findMotiveByRating(final String motiveRating){
        List<MotiveDto> motiveDtoList = new ArrayList<>();

        MotiveDto[] allMotiveList = restTemplate.getForObject("http://localhost:8080/eprojectk/motive/getMotiveByRating?motiveRating=" + motiveRating, MotiveDto[].class);

        for (int i = 0; i < allMotiveList.length; i++) {
            motiveDtoList.add(allMotiveList[i]);
        }

        return motiveDtoList;
    }

    public List<MotiveDto> getMotivesFacade() {
        List<MotiveDto> motiveDtoList = new ArrayList<>();
        MotiveDto[] allMotiveList = restTemplate.getForObject("http://localhost:8080/eprojectk/motive/getMotivesFacade", MotiveDto[].class);

        for (int i = 0; i < allMotiveList.length; i++) {
            motiveDtoList.add(allMotiveList[i]);
        }

        return motiveDtoList;
    }

    public  Long countAllMotives() throws NullPointerException {
        long allMotives = restTemplate.getForObject("http://localhost:8080/eprojectk/motive/countAllMotives", Long.class);
        return allMotives;
    }
}
