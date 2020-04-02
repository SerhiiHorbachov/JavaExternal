package ua.com.computers.parsers;

public enum PartEnum {

    DEVICE("device"),
    PART("part"),
    NAME("name"),
    ORIGIN("origin"),
    PRICE("price"),
    TYPE("type"),
    PERIPHERY("periphery"),
    ENERGYCONSUMPTION("energyConsumption"),
    COOLERINCLUDED("coolerIncluded"),
    GROUP("group"),
    PORT("port"),
    CRITICAL("critical");

    private String value;

    private PartEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
