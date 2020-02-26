package ua.externaljava.droid_wars.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dialogs {

    private static final String REQUEST_LANGUAGE = "Language|Мова:\n1-en\n2-ua";

    public static String requestLanguage() {
        int lang = 0;
        String language_str = "";

        System.out.println(REQUEST_LANGUAGE);

        while (true) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                lang = Integer.parseInt(reader.readLine());
                if (lang != 1 && lang != 2) {
                    throw new IllegalArgumentException();
                } else {
                    break;
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                System.out.println(REQUEST_LANGUAGE);
            }

        }

        if (lang == 1) {
            language_str = "en";
        } else if (lang == 2) {
            language_str = "ua";
        }


        return language_str;
    }

    public static int requestInt() {
        int input = 0;

        while (true) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                input = Integer.parseInt(reader.readLine());

                break;

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return input;
    }


}
