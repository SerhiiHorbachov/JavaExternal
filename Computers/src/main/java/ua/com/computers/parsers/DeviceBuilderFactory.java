package ua.com.computers.parsers;

public class DeviceBuilderFactory {
    private enum TypeParser {
        SAX, STAX, DOM
    }

    public AbstractDeviceBuilder createDeviceBuilder(String typeParser) {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());

        switch (type) {
            case DOM:
                return new DeviceDOMBuilder();
            case SAX:
                return new DeviceSAXBuilder();
            case STAX:
                return new DeviceStAXBuilder();
            default:
                throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
        }
    }
}
