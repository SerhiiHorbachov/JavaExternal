package ua.external.skakespeare.models;

import java.util.HashMap;
import java.util.Map;

public class PageContainer {
    private String url;
    private String rawText;
    private Map<String, Integer> frequency = new HashMap<>();

    public PageContainer(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRawText() {
        return rawText;
    }

    public void setRawText(String rawText) {
        this.rawText = rawText;
    }

    public Map<String, Integer> getFrequency() {
        return frequency;
    }

    public void setFrequency(Map<String, Integer> frequency) {
        this.frequency = frequency;
    }
}
