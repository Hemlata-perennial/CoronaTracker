package com.hemlata.covidtracker.Model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class LocationStats {

	@JsonProperty("province")
    private String state;
	@JsonProperty("country")
    private String country;
	@JsonProperty("confirmed")
    public int cc;
	@JsonProperty("deaths")
    public int dc;
	@JsonProperty("recovered")
    public int rc;
	@JsonProperty("province")
	public String getState() {
		return state;
	}
	@JsonProperty("province")
		public void setState(String state) {
		this.state = state;
	}
	@JsonProperty("country")
	public String getCountry() {
		return country;
	}
	@JsonProperty("country")
	public void setCountry(String country) {
		this.country = country;
	}
	@JsonProperty("confirmed")
	public int getCc() {
		return cc;
	}
	@JsonProperty("confirmed")
	public void setCc(int cc) {
		this.cc = cc;
	}
	@JsonProperty("deaths")
	public int getDc() {
		return dc;
	}
	@JsonProperty("deaths")
	public void setDc(int dc) {
		this.dc = dc;
	}
	@JsonProperty("recovered")
	public int getRc() {
		return rc;
	}
	@JsonProperty("recovered")
	public void setRc(int rc) {
		this.rc = rc;
	}
	@Override
	public String toString() {
		return "LocationStats [state=" + state + ", country=" + country + ", cc=" + cc + ", dc=" + dc + ", rc=" + rc + "]";
	}

   

}
