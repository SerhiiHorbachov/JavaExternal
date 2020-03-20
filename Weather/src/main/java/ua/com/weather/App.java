package ua.com.weather;

import ua.com.weather.controller.WeatherController;
import ua.com.weather.data.WeatherData;

public class App {

    public static void main(String[] args) {

        WeatherData weatherData = new WeatherData();
        WeatherController weatherController = new WeatherController(weatherData);
        weatherController.showWeather();

    }
}
