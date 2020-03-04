package ua.external.skakespeare;

import ua.external.skakespeare.data.TestData;
import ua.external.skakespeare.services.SearchEngine;

public class App {
    public static void main(String[] args) {
        SearchEngine searchEngine = new SearchEngine();
        searchEngine.displayFrequency("thy", TestData.pages);
    }
}
