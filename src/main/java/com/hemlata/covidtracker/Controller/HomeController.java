package com.hemlata.covidtracker.Controller;

import com.hemlata.covidtracker.Model.LocationStats;
import com.hemlata.covidtracker.Service.CoronaDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.io.IOException;
import java.util.List;

@Controller
public class HomeController {


   CoronaDataService coronaDataService=new CoronaDataService();

    @GetMapping("/")
    public String home() throws IOException, InterruptedException {
        /*
        List<LocationStats> allStats = coronaDataService.getAllStats();
        int totalconfirmedCases = allStats.stream().mapToInt(stat -> stat.cc).sum();
        int totalRecoveredCases = allStats.stream().mapToInt(stat -> stat.rc).sum();
        int totalDeathCases= allStats.stream().mapToInt(stat -> stat.dc).sum();
        int totalActiveCases= allStats.stream().mapToInt(stat -> stat.ac).sum();
        model.addAttribute("locationStats", allStats);
        model.addAttribute("totalconfirmedCases", totalconfirmedCases);
        model.addAttribute("totalRecoveredCases", totalRecoveredCases);
        model.addAttribute("totalDeathCases", totalDeathCases);
        model.addAttribute("totalActiveCases", totalActiveCases);
        */

        return coronaDataService.fetchVirusData();
    }
}
