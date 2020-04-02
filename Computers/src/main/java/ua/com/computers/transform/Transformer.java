package ua.com.computers.transform;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class Transformer {

    private static final String FILE_TO_TRANSFORM_PATH = "src/main/resources/device.xml";
    private static final String XSL_PATH = "src/main/resources/part2critical.xsl";
    private static final String RESULT_FILE_PATH = "src/main/resources/critical.xsl";

    public void transformXmlToXml() {

        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            javax.xml.transform.Transformer transformer = tf.newTransformer(new StreamSource(XSL_PATH));
            transformer.transform(new StreamSource(FILE_TO_TRANSFORM_PATH),
                    new StreamResult(RESULT_FILE_PATH));
            System.out.println("initial XML has been transformed. Find transformed .xml here: " + RESULT_FILE_PATH);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            System.err.println("Impossible transform file " + e);
        }
    }

}
