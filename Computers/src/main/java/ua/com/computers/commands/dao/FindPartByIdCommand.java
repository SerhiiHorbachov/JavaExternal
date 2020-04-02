package ua.com.computers.commands.dao;

import ua.com.computers.commands.Command;
import ua.com.computers.models.Part;
import ua.com.computers.services.PartService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindPartByIdCommand implements Command {

    PartService partService;

    public FindPartByIdCommand(PartService partService) {
        this.partService = partService;
    }

    @Override
    public void execute() {
        int id = -1;
        Part part = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (id < 1) {
            try {
                System.out.println("Enter part id: ");
                id = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                System.out.println("Please enter a positive integer");
                e.printStackTrace();
            }
        }

        part = partService.findById(id);
        System.out.println(part.toString());

    }
}
