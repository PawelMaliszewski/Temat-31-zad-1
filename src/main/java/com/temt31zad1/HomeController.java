package com.temt31zad1;

import com.temt31zad1.weatherapi.APIService;
import com.temt31zad1.weatherapi.CityWeather;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
class HomeController {

    private final APIService apiService;

    public HomeController(APIService apiService) {
        this.apiService = apiService;
    }

    @GetMapping()
    public String home() {
        return "index";
    }

    @GetMapping("/weather")
    public String weatherCityInfo(@RequestParam String city, Model model) {
        if (city != null) {
            CityWeather cityWeather = apiService.getCityWeather(city);
            if (cityWeather != null) {
                model.addAttribute("weather", cityWeather);
            } else {
                model.addAttribute("city", city);
            }
        }
        return "index";
    }
}
