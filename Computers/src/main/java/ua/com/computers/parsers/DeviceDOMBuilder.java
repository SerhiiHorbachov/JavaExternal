package ua.com.computers.parsers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import ua.com.computers.models.Part;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class DeviceDOMBuilder extends AbstractDeviceBuilder {

    private DocumentBuilder docBuilder;

    public DeviceDOMBuilder() {
        this.parts = new HashSet<Part>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.err.println("Ошибка конфигурации парсера: " + e);
        }
    }

    public DeviceDOMBuilder(Set<Part> parts) {
        super(parts);
        this.parts = new HashSet<Part>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.err.println("Ошибка конфигурации парсера: " + e);
        }
    }

    @Override
    public void buildSetParts(String fileName) {
        Document doc = null;

        try {
            // parsing XML-документа и создание древовидной структуры
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();

            // получение списка дочерних элементов <student>
            NodeList partsList = root.getElementsByTagName("part");

            for (int i = 0; i < partsList.getLength(); i++) {
                Element studentElement = (Element) partsList.item(i);
                Part student = buildPart(studentElement);
                parts.add(student);
            }

        } catch (SAXException e) {
            System.err.println("File error or I/O error: " + e);
        } catch (IOException e) {
            System.err.println("Parsing failure: " + e);
        }

    }

    private Part buildPart(Element partElement) {

        Part part = new Part();

        //заполнение объекта Part
        part.setName(getElementTextContent(partElement, "name"));
        part.setOrigin(getElementTextContent(partElement, "origin"));
        Integer price = Integer.parseInt(getElementTextContent(partElement, "price"));
        part.setPrice(price);
        part.setCurrency(partElement.getAttribute("currency"));

        Boolean isCritical = Boolean.parseBoolean(getElementTextContent(partElement, "critical"));
        part.setCritical(isCritical);

        Part.Type type = part.getType();

        // заполнение объекта Type
        Element typeElement = (Element) partElement.getElementsByTagName("type").item(0);

        Boolean isPeriphery = Boolean.parseBoolean(getElementTextContent(partElement, "periphery"));
        type.setPeriphery(isPeriphery);

        Integer energyConsumption = Integer.parseInt(getElementTextContent(partElement, "energyConsumption"));
        type.setEnergyConsumption(energyConsumption);

        Boolean isCoolerIncluded = Boolean.parseBoolean(getElementTextContent(partElement, "coolerIncluded"));
        type.setCoolerIncluded(isCoolerIncluded);

        type.setGroup(getElementTextContent(partElement, "group"));
        type.setPort(getElementTextContent(partElement, "port"));

        return part;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }

}
