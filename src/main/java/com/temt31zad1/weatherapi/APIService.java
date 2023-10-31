package com.temt31zad1.weatherapi;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Service
public class APIService {

    private WeatherApiData findCity(String cityName) {
        RestTemplate restTemplate = new RestTemplate();
        String key = "647cc0ca9f1f84f81d8cd55767ff285c";
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + cityName + ",pl&APPID=" + key + "&units=metric";
        WeatherApiData weatherApiData = null;
        try {
            weatherApiData = restTemplate.getForObject(url, WeatherApiData.class);
        } catch (HttpClientErrorException ignored) {
        }
        return weatherApiData;
    }

    public CityWeather getCityWeather(String city) {
        WeatherApiData w = findCity(city);
        if (w == null) {
            return null;
        }
        DateTimeFormatter dTF = DateTimeFormatter.ofPattern("HH:mm");
        return new CityWeather(city, w.getMain().getTemp(), w.getMain().getPressure(), w.getMain().getHumidity()
                , w.getWind().get("speed"), w.getClouds().get("all"), dTF.format(getTimeFromSeconds(w.getSys().getSunrise()))
                , dTF.format(getTimeFromSeconds(w.getSys().getSunset())));
    }

    private static LocalTime getTimeFromSeconds(Long seconds) {
        return LocalTime.ofInstant(Instant.ofEpochSecond(seconds), ZoneId.systemDefault());
    }
}
