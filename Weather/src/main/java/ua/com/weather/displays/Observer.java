package ua.com.weather.displays;

public interface Observer {
    void update(float temperature, float humidity, float pressure);
}
