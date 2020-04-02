package ua.com.computers.commands;

import ua.com.computers.parsers.AbstractDeviceBuilder;
import ua.com.computers.parsers.DeviceBuilderFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GeneratePartsFromXMLCommand implements Command {

    private static final String FILE_PATH = "src/main/resources/device.xml";
    private DeviceBuilderFactory deviceFactory;

    public GeneratePartsFromXMLCommand(DeviceBuilderFactory deviceFactory) {
        this.deviceFactory = deviceFactory;
    }

    @Override
    public void execute() {
        int method = -1;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        AbstractDeviceBuilder builder = null;

        while (method < 1 || method > 3) {
            try {
                System.out.println("Choose generation method: 1-SAX, 2-StAX, 3-DOM");
                method = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        switch (method) {
            case 1:
                builder = deviceFactory.createDeviceBuilder("SAX");
                builder.buildSetParts(FILE_PATH);
                System.out.println(builder.getParts());
                break;
            case 2:
                builder = deviceFactory.createDeviceBuilder("StAX");
                builder.buildSetParts(FILE_PATH);
                System.out.println(builder.getParts());
                break;
            case 3:
                builder = deviceFactory.createDeviceBuilder("DOM");
                builder.buildSetParts(FILE_PATH);
                System.out.println(builder.getParts());
                break;

        }

    }
}

