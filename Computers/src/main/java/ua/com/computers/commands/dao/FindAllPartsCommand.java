package ua.com.computers.commands.dao;

import ua.com.computers.commands.Command;
import ua.com.computers.models.Part;
import ua.com.computers.services.PartService;

import java.util.List;

public class FindAllPartsCommand implements Command {
    PartService partService;

    public FindAllPartsCommand(PartService partService) {
        this.partService = partService;
    }

    @Override
    public void execute() {
        List<Part> parts = null;

        parts = partService.getAll();

        for (Part part : parts) {
            System.out.println(part.toString());
        }

    }
}
