package com.hemlata.covidtracker.Service;

import com.hemlata.covidtracker.Model.LocationStats;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;
@Service
public class CoronaDataService {
	
	
	static String ydate() {


		String datey=null;
		int yday;
		String ymon;
		String yyear;

		//to get calendar instance 
		Calendar cal = Calendar.getInstance();
		
		//format date
		DateFormat dateFormat = new SimpleDateFormat("dd");
		
		//get formatted day
		datey=dateFormat.format(cal.getTime());
		yday=Integer.parseInt(datey);
		yday=yday-1;
        //get month
        DateFormat datemon = new SimpleDateFormat("mm");
		ymon=datemon.format(cal.getTime());
        //get formatted year
        DateFormat dateyear = new SimpleDateFormat("yyyy");
		yyear=dateyear.format(cal.getTime());

		//concatinate year, month and day to get desired date
		datey=Integer.toString(yday);
		List<String> vallist = Arrays.asList("09",datey,yyear);
		String ydate = String.join("-",vallist);
		System.out.println("Yesterday's date = "+ ydate);
		return ydate;
	}

	//Form complete url by adding date to it
	static String name_url="https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_daily_reports/";
	static String yd=ydate();
	static List<String> valuesList = Arrays.asList(name_url,"01-01-2021",".csv");
	static String complete_url = String.join("",valuesList);
	
	//public static final repos reps = null;
    private static String VIRUS_DATA_URL =complete_url;
    		private List<LocationStats> allStats = new ArrayList<>();

    public List<LocationStats> getAllStats() {
        return allStats;
    }

    @PostConstruct
    @Scheduled(cron = "* * 1 * * *")    //to uodate data daily
    public String fetchVirusData() throws IOException, InterruptedException {
        List<LocationStats> newStats = new ArrayList<>();

        /*Rest Template to fetch Data from specificURL
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(VIRUS_DATA_URL))
                .build();
        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(httpResponse);
        StringReader csvBodyReader = new StringReader(httpResponse.body());*/
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(VIRUS_DATA_URL , String.class);
        Logger.getLogger(String.valueOf(response.getStatusCode()));

/*
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);
        for (CSVRecord record : records) {
            LocationStats locationStat = new LocationStats();
            locationStat.setState(record.get("Province_State"));
            locationStat.setCountry(record.get("Country_Region"));
            locationStat.setCc(Integer.parseInt(record.get("Confirmed")));
            locationStat.setDc(Integer.parseInt(record.get("Deaths")));
            locationStat.setRc(Integer.parseInt(record.get("Recovered")));
            newStats.add(locationStat);
        }
        this.allStats = newStats;

 */
        return String.valueOf(response);
    }

}
