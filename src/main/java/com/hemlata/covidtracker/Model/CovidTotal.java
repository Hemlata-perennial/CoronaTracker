package com.hemlata.covidtracker.Model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class CovidTotal {
    @JsonProperty("Total Recovered_text")
    private String recovered;
    @JsonProperty("Total Cases_text")
    private String total;
    @JsonProperty("Active Cases_text")
    private String active;
    @JsonProperty("Total Deaths_text")
    private String deaths;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    @JsonProperty("Total Recovered_text")
    public String getRecovered() {
        return recovered;
    }
    @JsonProperty("Total Recovered_text")
    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }
    @JsonProperty("Total Cases_text")
    public String getTotal() {
        return total;
    }
    @JsonProperty("Total Cases_text")
    public void setTotal(String total) {
        this.total = total;
    }
    @JsonProperty("Active Cases_text")
    public String getActive() {
        return active;
    }
    @JsonProperty("Active Cases_text")
    public void setActive(String active) {
        this.active = active;
    }
    @JsonProperty("Total Deaths_text")
    public String getDeaths() {
        return deaths;
    }
    @JsonProperty("Total Deaths_text")
    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }
    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}

