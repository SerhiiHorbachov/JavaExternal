package ua.com.computers.controllers;

import ua.com.computers.commands.*;
import ua.com.computers.commands.dao.CreatePartCommand;
import ua.com.computers.commands.dao.DeletePartByIdCommand;
import ua.com.computers.commands.dao.FindAllPartsCommand;
import ua.com.computers.commands.dao.FindPartByIdCommand;
import ua.com.computers.parsers.DeviceBuilderFactory;
import ua.com.computers.services.PartService;
import ua.com.computers.transform.Transformer;
import ua.com.computers.validator.ValidatorSAX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppController {

    CommandInvoker commandInvoker = new CommandInvoker();

    public void start() {
        int option = -1;
        initiateCommands();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("\nChoose action:" + commandInvoker.toString());

            try {
                option = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Command option: " + option);

            switch (option) {
                case 0:
                    commandInvoker.runCommand(option);
                    break;
                case 1:
                    commandInvoker.runCommand(option);
                    break;
                case 2:
                    commandInvoker.runCommand(option);
                    break;
                case 3:
                    commandInvoker.runCommand(option);
                    break;
                case 4:
                    commandInvoker.runCommand(option);
                    break;
                case 5:
                    commandInvoker.runCommand(option);
                    break;
                case 6:
                    commandInvoker.runCommand(option);
                    break;
                case 7:
                    commandInvoker.runCommand(option);
                    break;
            }

        }
    }

    private void initiateCommands() {
        Transformer transformer = new Transformer();
        ValidatorSAX validatorSAX = new ValidatorSAX();
        DeviceBuilderFactory deviceBuilderFactory = new DeviceBuilderFactory();
        PartService partService = new PartService();

        commandInvoker.setCommands(0, new ExitCommand());
        commandInvoker.setCommands(1, new TransformXMLCommand(transformer));
        commandInvoker.setCommands(2, new ValidateXmlCommand(validatorSAX));
        commandInvoker.setCommands(3, new GeneratePartsFromXMLCommand(deviceBuilderFactory));
        commandInvoker.setCommands(4, new FindPartByIdCommand(partService));
        commandInvoker.setCommands(5, new FindAllPartsCommand(partService));
        commandInvoker.setCommands(6, new CreatePartCommand(partService));
        commandInvoker.setCommands(7, new DeletePartByIdCommand(partService));

    }

}
