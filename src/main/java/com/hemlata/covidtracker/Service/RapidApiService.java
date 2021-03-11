package com.hemlata.covidtracker.Service;

import com.hemlata.covidtracker.Model.CovidTotal;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;

public class RapidApiService {
    RestTemplate restTemplate;

    public RapidApiService() {
    }

    public RapidApiService(RestTemplateBuilder tempBuilder) {
        restTemplate=tempBuilder.build();
    }

    public String covidData() throws URISyntaxException {
        URI uri;
        uri = new URI("https://covid-19-tracking.p.rapidapi.com/v1");
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", "d389aa5358msh4674e22ec76993ep1fb164jsnd244ab94763a");
        headers.set("x-rapidapi-host","covid-19-tracking.p.rapidapi.com");
        //headers.setContentType(MediaType.APPLICATION_JSON);
        //headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> request = new HttpEntity<String>(headers);
        ResponseEntity<CovidTotal[]> totalEntity = restTemplate.exchange(uri, HttpMethod.GET , request, CovidTotal[].class);
        CovidTotal total = totalEntity.getBody()[0];
        return total.toString();
    }
}
