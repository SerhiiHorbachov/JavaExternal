package ua.external.skakespeare.data;

import ua.external.skakespeare.services.HtmlTextProcessor;
import ua.external.skakespeare.models.PageContainer;
import ua.external.skakespeare.services.Parser;

import java.util.ArrayList;
import java.util.List;

public class TestData {
    public static List<PageContainer> pages;

    static {
        pages = new ArrayList<>();
        pages.add(new PageContainer("http://shakespeare.mit.edu/Poetry/sonnet.I.html"));
        pages.add(new PageContainer("http://shakespeare.mit.edu/Poetry/sonnet.II.html"));
        pages.add(new PageContainer("http://shakespeare.mit.edu/Poetry/sonnet.III.html"));
        pages.add(new PageContainer("http://shakespeare.mit.edu/Poetry/sonnet.IV.html"));
        pages.add(new PageContainer("http://shakespeare.mit.edu/Poetry/sonnet.V.html"));
        pages.add(new PageContainer("http://shakespeare.mit.edu/Poetry/sonnet.VI.html"));
        pages.add(new PageContainer("http://shakespeare.mit.edu/Poetry/sonnet.VII.html"));
        pages.add(new PageContainer("http://shakespeare.mit.edu/Poetry/sonnet.VIII.html"));
        pages.add(new PageContainer("http://shakespeare.mit.edu/Poetry/sonnet.IX.html"));
        pages.add(new PageContainer("http://shakespeare.mit.edu/Poetry/sonnet.X.html"));

        for (PageContainer page : TestData.pages) {
            try {
                page.setRawText(Parser.getTextFromWeb(page.getUrl()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            page.setFrequency(HtmlTextProcessor.calculateFrequency(page.getRawText()));
        }
    }

}
