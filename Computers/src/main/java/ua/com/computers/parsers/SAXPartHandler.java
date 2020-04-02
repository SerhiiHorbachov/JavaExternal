package ua.com.computers.parsers;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import ua.com.computers.models.Part;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class SAXPartHandler extends DefaultHandler {

    private Set<Part> parts;
    private Part current = null;
    private PartEnum currentEnum = null;
    private EnumSet<PartEnum> withText;

    public SAXPartHandler(){
        parts = new HashSet<Part>();
        withText = EnumSet.range(PartEnum.NAME, PartEnum.PORT);
    }

    public Set<Part> getParts() {
        return parts;
    }

    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if ("part".equals(localName)) {
            current = new Part();
        } else if ("price".equals(localName)) {
            current.setCurrency(attrs.getValue(0));
        } else if ("currency".equals(localName)) {
            current.setCurrency(attrs.getValue(0));
        } else {

            PartEnum temp = PartEnum.valueOf(localName.toUpperCase());
            if (withText.contains(temp)) {

                currentEnum = temp;

            }
        }

    }

    public void endElement(String uri, String localName, String qName) {
        if ("part".equals(localName)) {
            parts.add(current);
        }
    }

    public void characters(char[] ch, int start, int length) {

        String s = new String(ch, start, length).trim();
        if (currentEnum != null) {

            switch (currentEnum) {
                case NAME:
                    current.setName(s);
                    break;
                case ORIGIN:
                    current.setOrigin(s);
                    break;
                case PRICE:
                    current.setPrice(Integer.parseInt(s));
                    break;
                case PERIPHERY:
                    current.getType().setPeriphery(Boolean.parseBoolean(s));
                    break;
                case ENERGYCONSUMPTION:
                    current.getType().setEnergyConsumption(Integer.parseInt(s));
                    break;
                case COOLERINCLUDED:
                    current.getType().setCoolerIncluded(Boolean.parseBoolean(s));
                    break;
                case GROUP:
                    current.getType().setGroup(s);
                    break;
                case PORT:
                    current.getType().setPort(s);
                    break;
                default:

                    throw new EnumConstantNotPresentException(
                            currentEnum.getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;
    }

}
