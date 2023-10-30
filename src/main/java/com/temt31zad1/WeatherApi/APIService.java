package com.temt31zad1.WeatherApi;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;

@Service
public class APIService {

    private WeatherApiData findCity(String cityName) {
        RestTemplate restTemplate = new RestTemplate();
        String key = "647cc0ca9f1f84f81d8cd55767ff285c";
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + cityName + ",pl&APPID=" + key + "&units=metric";
        WeatherApiData weatherApiData = null;
        try {
            weatherApiData = restTemplate.getForObject(url, WeatherApiData.class);
        } catch (HttpClientErrorException e) {
            System.out.println("Nie odnależiono miasta o takiej nazwie");
        }
        return weatherApiData;
    }

    public CityWeather getCityWeather(String city) {
        WeatherApiData w = findCity(city);
        if (w == null) {
            return null;
        }
        LocalTime sun_Rise = LocalTime.ofInstant(Instant.ofEpochSecond(Long.parseLong(w.getSys().get("sunrise"))), ZoneId.systemDefault());
        LocalTime sun_set = LocalTime.ofInstant(Instant.ofEpochSecond(Long.parseLong(w.getSys().get("sunset"))), ZoneId.systemDefault());
        String sunRise = sun_Rise.getHour() + ":" + sun_Rise.getMinute();
        String sunset = sun_set.getHour() + ":" + sun_set.getMinute();
        return new CityWeather(city, w.getMain().getTemp(), w.getMain().getPressure(), w.getMain().getHumidity()
                , w.getWind().get("speed"), w.getClouds().get("all"), sunRise , sunset);
    }
}
