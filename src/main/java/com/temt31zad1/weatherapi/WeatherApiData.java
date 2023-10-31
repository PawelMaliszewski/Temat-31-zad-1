package com.temt31zad1.weatherapi;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
class WeatherApiData {
    private WeatherParams main;
    private Map<String, Double> wind;
    private Map<String, Integer> clouds;
    private DayLightTime sys;
}
