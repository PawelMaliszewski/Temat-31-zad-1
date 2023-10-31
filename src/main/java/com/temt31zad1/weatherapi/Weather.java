package com.temt31zad1.weatherapi;

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
