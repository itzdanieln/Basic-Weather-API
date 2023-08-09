package com.weatherapp.weatherapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class WeatherController {

    @Value("${openweathermap.apikey}")
    private String apiKey;

    @GetMapping("/weather")
    public ResponseEntity<String> getWeather() {
        
        // Geo-Coordinates of Enugu
        String latitude = "6.5536094";
        String longitude = "7.4143061";

        String apiUrl = "http://api.openweathermap.org/data/2.5/weather?lat=" + latitude + "&lon=" + longitude + "&appid=" + apiKey;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        WeatherData weatherData = objectMapper.readValue(response.getBody(), WeatherData.class);

        return ResponseEntity.ok(weatherData);
    }
}
