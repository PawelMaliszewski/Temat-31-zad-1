package com.temt31zad1.WeatherApi;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Map;

@Getter
@Setter
class WeatherApiData {
    private ArrayList<Weather> weather;
    private WeatherParams main;
    private Map<String, Double> wind;
    private Map<String, Integer> clouds;
    private Map<String, String> sys;
}
