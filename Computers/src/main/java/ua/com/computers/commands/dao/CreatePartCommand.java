package ua.com.computers.commands.dao;

import ua.com.computers.commands.Command;
import ua.com.computers.models.Part;
import ua.com.computers.services.PartService;

import java.util.List;

public class CreatePartCommand implements Command {


    PartService partService;

    public CreatePartCommand(PartService partService) {
        this.partService = partService;
    }

    @Override
    public void execute() {

        Part newPart = new Part();
        newPart.setName("monitor");
        newPart.setOrigin("Korea");
        newPart.setPrice(450);
        newPart.setCurrency("USD");
        newPart.getType().setPeriphery(true);
        newPart.getType().setEnergyConsumption(50);
        newPart.getType().setUnits("Watt");
        newPart.getType().setCoolerIncluded(false);
        newPart.getType().setGroup("output");
        newPart.getType().setPort("HDMI");

        partService.create(newPart);

        System.out.println("New part has been created");


    }
}
