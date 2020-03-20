package ua.com.weather.data;

import ua.com.weather.displays.Observer;

public interface Subject {
    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}
