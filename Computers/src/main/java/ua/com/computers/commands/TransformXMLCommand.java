package ua.com.computers.commands;

import ua.com.computers.transform.Transformer;

public class TransformXMLCommand implements Command {

    Transformer transformer;

    public TransformXMLCommand(Transformer transformer) {
        this.transformer = transformer;
    }

    @Override
    public void execute() {
        transformer.transformXmlToXml();
    }
}
