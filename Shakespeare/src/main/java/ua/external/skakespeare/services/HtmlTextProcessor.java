package ua.external.skakespeare.services;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlTextProcessor {
    private final static String TEXT_INSIDE_BODY_TAGS_PATTERN = "<BODY>(.+?)</BODY>";
    private final static String NONLETTERS_PATTERN = "[^a-zA-Z]";
    private final static String HTML_TAGS_PATTERN = "\\<.*?>";
    private final static String BLANK_SPACE = " ";

    public static Map<String, Integer> calculateFrequency(String rawHtmlText) {
        Map<String, Integer> wordsFrequency = new HashMap<String, Integer>();
        String[] words = removeHtml(rawHtmlText).replaceAll(NONLETTERS_PATTERN, BLANK_SPACE).toLowerCase().split("\\s+");

        for (String word : words) {
            Integer freq = wordsFrequency.get(word);
            wordsFrequency.put(word, (freq == null) ? 1 : freq + 1);
        }

        return wordsFrequency;
    }

    private static String removeHtml(String rawText) {
        String result = "";
        Pattern pattern = Pattern.compile(TEXT_INSIDE_BODY_TAGS_PATTERN, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(rawText);
        matcher.find();
        result = matcher.group(1);
        result = result.replaceAll(HTML_TAGS_PATTERN, BLANK_SPACE);
        return result;
    }

}
