package ua.javaexternal;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) {
        System.out.println("Current Locale: " + Locale.getDefault());
        Locale.setDefault(new Locale("ua"));
        System.out.println("Current Locale: " + Locale.getDefault());

        ResourceBundle bundleUa = ResourceBundle.getBundle("prop/localization", new Locale("ua"));
        System.out.println(bundleUa.getString("hello"));

    }
}
