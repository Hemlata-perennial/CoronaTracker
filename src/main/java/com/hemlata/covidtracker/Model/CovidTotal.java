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
    private Long total;
    @JsonProperty("Active Cases_text")
    private Long active;
    @JsonProperty("Total Deaths_text")
    private Long deaths;
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
    public Long getTotal() {
        return total;
    }
    @JsonProperty("Total Cases_text")
    public void setTotal(Long total) {
        this.total = total;
    }
    @JsonProperty("Active Cases_text")
    public Long getActive() {
        return active;
    }
    @JsonProperty("Active Cases_text")
    public void setActive(Long active) {
        this.active = active;
    }
    @JsonProperty("Total Deaths_text")
    public Long getDeaths() {
        return deaths;
    }
    @JsonProperty("Total Deaths_text")
    public void setDeaths(Long deaths) {
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

