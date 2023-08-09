package com.weatherapp.weatherapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestWeatherappApplication {

	public static void main(String[] args) {
		SpringApplication.from(WeatherappApplication::main).with(TestWeatherappApplication.class).run(args);
	}

}
