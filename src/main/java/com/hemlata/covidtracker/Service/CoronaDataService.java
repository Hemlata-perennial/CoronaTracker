package com.hemlata.covidtracker.Service;

import com.hemlata.covidtracker.Model.LocationStats;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CoronaDataService {


    @PostConstruct
    @Scheduled(cron = "* * 1 * * *")    //to uodate data daily
    public String fetchVirusData() throws IOException, InterruptedException, URISyntaxException {
        List<LocationStats> newStats = new ArrayList<>();
/*
        //Rest template to fetch data
		String JsonString=df.covidData();
		cntryData=cntryData.replace("null","0");
		Map<String,Object> cntryMap=mapper.readValue(cntryData,Map.class);
		Map<String, Object> resultmap= (Map<String, Object>) cntryMap.get("data");

		ArrayList<String> data=(ArrayList<String>) resultmap.get("covid19Stats");


		Iterator itr=data.iterator();

		Iterable<Object> records= (Iterable<Object>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(itr, 0),false).collect(Collectors.toList());


		//Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);

        for (Object record : records) {
            LocationStats locationStat = new LocationStats();
            locationStat.setState(record.);
            locationStat.setCountry((String) resultmap.get("Country"));
            locationStat.setCc(Integer.parseInt(record.get("Confirmed")));
            locationStat.setDc(Integer.parseInt(record.get("Deaths")));
            locationStat.setRc(Integer.parseInt(record.get("Recovered")));
            newStats.add(locationStat);
        }
        this.allStats = newStats;
*/
        return null;
    }
}
