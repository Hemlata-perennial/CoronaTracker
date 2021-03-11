package com.hemlata.covidtracker.Model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class CovidTotal {
    @JsonProperty("confirmed")
    private String confirmed;
    @JsonProperty("recovered")
    private String recovered;
    @JsonProperty("critical")
    private Long critical;
    @JsonProperty("deaths")
    private Long deaths;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    @JsonProperty("confirmed")
    public String getConfirmed() {
        return confirmed;
    }
    @JsonProperty("confirmed")
    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }
    @JsonProperty("recovered")
    public String getRecovered() {
        return recovered;
    }
    @JsonProperty("recovered")
    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }
    @JsonProperty("critical")
    public Long getCritical() {
        return critical;
    }
    @JsonProperty("critical")
    public void setCritical(Long critical) {
        this.critical = critical;
    }
    @JsonProperty("deaths")
    public Long getDeaths() {
        return deaths;
    }
    @JsonProperty("deaths")
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

