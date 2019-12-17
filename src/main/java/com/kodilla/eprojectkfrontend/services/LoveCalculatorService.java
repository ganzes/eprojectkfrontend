package com.kodilla.eprojectkfrontend.services;

import com.kodilla.eprojectkfrontend.domains.LoveCalculatorDto;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

@Service
public class LoveCalculatorService {

    private RestTemplate restTemplate = new RestTemplate();

    public LoveCalculatorDto getPercentage(final LoveCalculatorDto loveCalculatorDto) throws HttpServerErrorException {
        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/eprojectk/lc/?fname=" + loveCalculatorDto.getFname() + "&sname=" + loveCalculatorDto.getSname())
                .build().encode().toUri();
        LoveCalculatorDto loveCalculatorDto1 = restTemplate.getForObject(url, LoveCalculatorDto.class);
        return loveCalculatorDto1;
    }

    //added for further implementation
/*    public void exportCSV() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("http://localhost:8080"));
        restTemplate.getForObject("/eprojectk/lc/export-LoveCalculatorResults", String.class);

    }
    public void downloadFile(){     // This method will download file using RestTemplate
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM));
            HttpEntity<String> entity = new HttpEntity<>(headers);
            ResponseEntity<byte[]> response = restTemplate.build()
                    .exchange("http://localhost:8080/downloadFile", HttpMethod.GET, entity, byte[].class);
            Files.write(Paths.get("e:\\download-files\\demo1.pdf"), response.getBody());
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/

/*    public void exportCSV() {
        RestTemplate restTemplate  = new RestTemplate();

// Optional Accept header
        RequestCallback requestCallback = request -> request.getHeaders()
                .setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM, MediaType.ALL));

// Streams the response instead of loading it all in memory
        ResponseExtractor<Void> responseExtractor = response -> {
            // Here I write the response to a file but do what you like
            Path path = Paths.get("some/path");
            Files.copy(response.getBody(), path);
            return null;
        };
        restTemplate.execute(URI.create("http://localhost:8080/eprojectk/lc/export-LoveCalculatorResults"), HttpMethod.GET, requestCallback, responseExtractor);
    }*/

    public LoveCalculatorDto setLoveNull() {
        LoveCalculatorDto loveCalculatorDto = new LoveCalculatorDto();
        loveCalculatorDto.setFname(null);
        loveCalculatorDto.setSname(null);
        loveCalculatorDto.setPercentage(null);
        loveCalculatorDto.setResult(null);
        return loveCalculatorDto;
    }
}