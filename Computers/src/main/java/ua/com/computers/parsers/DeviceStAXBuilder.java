package ua.com.computers.parsers;

import ua.com.computers.models.Part;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

public class DeviceStAXBuilder extends AbstractDeviceBuilder{

    private XMLInputFactory inputFactory;

    public DeviceStAXBuilder() {
        inputFactory = XMLInputFactory.newInstance();
    }

    public DeviceStAXBuilder(Set<Part> parts) {
        super(parts);
        inputFactory = XMLInputFactory.newInstance();
    }


    @Override
    public void buildSetParts(String fileName) {
        FileInputStream inputStream = null;
        XMLStreamReader reader = null;
        String name;

        try {
            inputStream = new FileInputStream(new File(fileName));
            reader = inputFactory.createXMLStreamReader(inputStream);

            //StAX parsing
            while (reader.hasNext()) {
                int type = reader.next();

                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (PartEnum.valueOf(name.toUpperCase()) == PartEnum.PART) {
                        Part part = buildPart(reader);
                        parts.add(part);
                    }
                }
            }

        } catch (XMLStreamException ex) {
            System.err.println("StAX parsing error! " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            System.err.println("File " + fileName + " not found! " + ex);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.err.println("Impossible close file " + fileName + " : " + e);
            }
        }
    }

    private Part buildPart(XMLStreamReader reader) throws XMLStreamException {
        Part part = new Part();

        String name;

        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();

                    switch (PartEnum.valueOf(name.toUpperCase())) {
                        case NAME:
                            part.setName(getXMLText(reader));
                            break;
                        case ORIGIN:
                            part.setOrigin(getXMLText(reader));
                            break;
                        case PRICE:
                            name = getXMLText(reader);
                            part.setPrice(Integer.parseInt(name));
                        case TYPE:
                            part.setType(getXMLType(reader));
                            break;
                        case CRITICAL:
                            name = getXMLText(reader);
                            part.setCritical(Boolean.parseBoolean(name));
                            break;
                    }

                    break;

                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (PartEnum.valueOf(name.toUpperCase()) == PartEnum.PART) {
                        return part;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Student");

    }

    private Part.Type getXMLType(XMLStreamReader reader) throws XMLStreamException {

        Part.Type partType = new Part.Type();

        int type;
        String name;

        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (PartEnum.valueOf(name.toUpperCase())) {
                        case PERIPHERY:
                            name = getXMLText(reader);
                            partType.setPeriphery(Boolean.parseBoolean(name));
                            break;
                        case ENERGYCONSUMPTION:
                            name = getXMLText(reader);
                            partType.setEnergyConsumption(Integer.parseInt(name));
                            break;
                        case COOLERINCLUDED:
                            name = getXMLText(reader);
                            partType.setCoolerIncluded(Boolean.parseBoolean(name));
                            break;
                        case GROUP:
                            partType.setGroup(getXMLText(reader));
                            break;
                        case PORT:
                            partType.setPort(getXMLText(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (PartEnum.valueOf(name.toUpperCase()) == PartEnum.TYPE) {
                        return partType;
                    }
                    break;
            }
        }

        throw new XMLStreamException("Unknown element in tag Type");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }


}
