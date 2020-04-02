package ua.com.computers.parsers;

import ua.com.computers.models.Part;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractDeviceBuilder {
    protected Set<Part> parts;

    public AbstractDeviceBuilder() {
        parts = new HashSet<Part>();
    }

    public AbstractDeviceBuilder(Set<Part> parts) {
        parts = new HashSet<Part>();
    }

    public Set<Part> getParts() {
        return parts;
    }

    abstract public void buildSetParts(String fileName);

}
