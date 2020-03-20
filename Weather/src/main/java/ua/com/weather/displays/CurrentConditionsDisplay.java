package ua.com.weather.displays;

import ua.com.weather.data.Subject;
import ua.com.weather.data.WeatherData;

import java.util.Observable;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    private float pressure;
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {

        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature + "C degrees, " + humidity + "% humidity, pressure " + pressure + "hPa");
    }

}
