package ua.com.weather.parsers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class XmlParser {

    public static Map<String, Float> getDataFromXML(String url) throws Exception {
        Map<String, Float> data = new HashMap<String, Float>();

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;

        try {
            db = dbf.newDocumentBuilder();
            Document doc = db.parse(new URL(url).openStream());
            NodeList nodeList = doc.getElementsByTagName("temperature");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node nNode = nodeList.item(i);
                Element eElement = (Element) nNode;
                Float temperature = Float.parseFloat(eElement.getAttribute("value"));
                data.put("temperature", temperature);
            }

            nodeList = doc.getElementsByTagName("humidity");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node nNode = nodeList.item(i);
                Element eElement = (Element) nNode;
                Float humidity = Float.parseFloat(eElement.getAttribute("value"));
                data.put("humidity", humidity);
            }

            nodeList = doc.getElementsByTagName("pressure");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node nNode = nodeList.item(i);
                Element eElement = (Element) nNode;
                Float pressure = Float.parseFloat(eElement.getAttribute("value"));
                data.put("pressure", pressure);
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        return data;

    }

}
