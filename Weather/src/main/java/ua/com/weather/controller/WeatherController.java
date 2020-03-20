package ua.com.weather.controller;

import ua.com.weather.data.WeatherData;
import ua.com.weather.displays.CurrentConditionsDisplay;
import ua.com.weather.parsers.XmlParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class WeatherController {
    private static final String XML_MODE = "xml";
    private static final String JSON_MODE = "json";
    private static final String UNIT_SYSTEM = "metric";
    private static final String API_KEY = "";
    private static final String URL_TEMPLATE = "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=%s&mode=%s";


    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private WeatherData weatherData;
    private CurrentConditionsDisplay display;
    Map<String, Float> data;

    public WeatherController(WeatherData weatherData) {
        this.weatherData = weatherData;
        this.display = new CurrentConditionsDisplay(weatherData);
    }

    public void showWeather() {
        System.out.println("Choose city:");
        String location = getInputFromUser();
        String url = prepareUrl(location, API_KEY, UNIT_SYSTEM, XML_MODE);

        try {
            data = XmlParser.getDataFromXML(url);
        } catch (Exception e) {
            e.printStackTrace();
        }

        float temperature = data.get("temperature");
        float humidity = data.get("humidity");
        float pressure = data.get("pressure");

        weatherData.setMeasurements(temperature, humidity, pressure);

    }

    private String prepareUrl(String location, String apiKey, String unitSystem, String documentMode) {
        return String.format(URL_TEMPLATE, location, apiKey, unitSystem, documentMode);
    }

    private String getInputFromUser() {
        String userInput = "";

        try {
            userInput = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userInput;
    }
}
