package ua.com.computers.parsers;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class DeviceSAXBuilder extends AbstractDeviceBuilder {

    private SAXPartHandler partHandler;
    private XMLReader reader;

    public DeviceSAXBuilder() {
        partHandler = new SAXPartHandler();

        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(partHandler);
        } catch (SAXException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void buildSetParts(String fileName) {
        try {
            reader.parse(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        parts = partHandler.getParts();
    }


}
