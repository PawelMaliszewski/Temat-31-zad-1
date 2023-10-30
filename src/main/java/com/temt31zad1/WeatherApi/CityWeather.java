package com.temt31zad1.WeatherApi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CityWeather {
    private String cityName;
    private double temperature;
    private int pressure;
    private int humidity;
    private double windSpeed;
    private int clouds;
    private String sunRise;
    private String sunSet;

}
