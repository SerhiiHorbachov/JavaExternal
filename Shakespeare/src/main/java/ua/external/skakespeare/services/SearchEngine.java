package ua.external.skakespeare.services;

import ua.external.skakespeare.models.PageContainer;

import java.util.*;

public class SearchEngine {

    public void displayFrequency(String word, List<PageContainer> pages) {
        for (Map.Entry<String, Integer> entry : calculateFrequency(word, pages).entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    private Map<String, Integer> calculateFrequency(String word, List<PageContainer> pages) {
        Map<String, Integer> frequency = new HashMap<>();

        for (PageContainer page : pages) {
            if (page.getFrequency().containsKey(word)) {
                frequency.put(page.getUrl(), page.getFrequency().get(word));
            }
        }

        return sortMapByValue(frequency);
    }

    private LinkedHashMap<String, Integer> sortMapByValue(Map<String, Integer> mapToSort) {
        LinkedHashMap<String, Integer> sortedByFrequencyValue = null;
        List<Map.Entry<String, Integer>> list = new LinkedList<>(mapToSort.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        sortedByFrequencyValue = new LinkedHashMap<>(list.size());
        for (Map.Entry<String, Integer> entry : list) {
            sortedByFrequencyValue.put(entry.getKey(), entry.getValue());
        }

        return sortedByFrequencyValue;
    }


}
