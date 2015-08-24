package com.example.jsondemo.Bean;

public class RetData {
	private String city;
	private String weather;
	private String temp;
	private String l_tmp;
	private String h_tmp;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public String getL_tmp() {
		return l_tmp;
	}
	@Override
	public String toString() {
		return "RetData [city=" + city + ", weather=" + weather + ", temp="
				+ temp + ", l_tmp=" + l_tmp + ", h_tmp=" + h_tmp + "]";
	}
	public void setL_tmp(String l_tmp) {
		this.l_tmp = l_tmp;
	}
	public String getH_tmp() {
		return h_tmp;
	}
	public void setH_tmp(String h_tmp) {
		this.h_tmp = h_tmp;
	}
}
