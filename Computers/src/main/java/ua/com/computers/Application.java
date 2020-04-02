package ua.com.computers;

import ua.com.computers.controllers.AppController;

public class Application {
    public static void main(String[] args) {
        AppController appController = new AppController();
        appController.start();
    }
}
