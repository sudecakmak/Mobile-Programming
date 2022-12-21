package com.example.weather;

public class Weather {

    private String ID;
    private String city;
    private String temperature;
    private String weatherImg;
    private String weather;
    private String date;

    public Weather(String ID, String city, String temperature, String weatherImg, String weather, String date) {
        this.ID = ID;
        this.city = city;
        this.temperature = temperature;
        this.weatherImg = weatherImg;
        this.weather = weather;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWeatherImg() {
        return weatherImg;
    }

    public void setWeatherImg(String weatherImg) {
        this.weatherImg = weatherImg;
    }
}
