package com.temt31zad1.WeatherApi;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Weather {
    private Long id;
    private String main;
    private String description;
    private String icon;
}
