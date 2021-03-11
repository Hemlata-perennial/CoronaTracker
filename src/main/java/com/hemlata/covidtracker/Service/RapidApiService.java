package com.hemlata.covidtracker.Service;

import com.hemlata.covidtracker.Model.CovidTotal;
import com.hemlata.covidtracker.Model.LocationStats;
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

    public CovidTotal covidData() throws URISyntaxException {
        URI uri= new URI("https://covid-19-tracking.p.rapidapi.com/v1");
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", "d389aa5358msh4674e22ec76993ep1fb164jsnd244ab94763a");
        headers.set("x-rapidapi-host","covid-19-tracking.p.rapidapi.com");
        HttpEntity<String> request = new HttpEntity<String>(headers);
        ResponseEntity<CovidTotal[]> totalEntity = restTemplate.exchange(uri, HttpMethod.GET , request, CovidTotal[].class);
        CovidTotal total = totalEntity.getBody()[0];
        return total;
    }
    public LocationStats CountryData() throws URISyntaxException {
        URI uri= new URI("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats");
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", "d389aa5358msh4674e22ec76993ep1fb164jsnd244ab94763a");
        headers.set("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com");
        HttpEntity<String> request = new HttpEntity<String>(headers);
        ResponseEntity<LocationStats> totalEntity = restTemplate.exchange(uri, HttpMethod.GET , request, LocationStats.class);
        LocationStats total = totalEntity.getBody();
        return total;
    }
}
