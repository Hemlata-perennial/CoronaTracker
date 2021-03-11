package com.hemlata.covidtracker.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hemlata.covidtracker.Model.CovidTotal;
import com.hemlata.covidtracker.Service.CoronaDataService;
import com.hemlata.covidtracker.Service.RapidApiService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

@Controller
public class HomeController {


   CoronaDataService coronaDataService=new CoronaDataService();
    RapidApiService df = new RapidApiService();
    @GetMapping("restTest")
    public String test() throws URISyntaxException {
        return df.covidData();
    }
    @GetMapping("/")
    public ModelAndView home(ModelAndView modelAndView) throws IOException, InterruptedException, URISyntaxException {

        String responseJsonString=df.covidData();
        ObjectMapper mapper = new ObjectMapper();

        //parse JSON to display All cases
        CovidTotal ct = new CovidTotal();
        Map<String,Object> map= ct.getAdditionalProperties();
        System.out.println("JSON parsed to map");
        String ActiveCases,TotalDeath,TotalCases,TotalRecovered;
        TotalCases= (String) map.get("Total Cases_text");
        ActiveCases= (String) map.get("Active Cases_text");
        TotalDeath= (String) map.get("Total Deaths_text");
        TotalRecovered= (String) map.get("Total Recovered_text");
        modelAndView.addObject("total",TotalCases);
        modelAndView.addObject("active",ActiveCases);
        modelAndView.addObject("recovered",TotalRecovered);
        modelAndView.addObject("deaths",TotalDeath);
        modelAndView.addObject("cntry",coronaDataService.fetchVirusData());
        modelAndView.setViewName("CovidHome");

        return modelAndView;
    }
}
