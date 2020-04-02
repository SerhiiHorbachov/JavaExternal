package ua.com.computers.commands;

import ua.com.computers.validator.ValidatorSAX;

public class ValidateXmlCommand implements Command {
    ValidatorSAX validator;

    public ValidateXmlCommand(ValidatorSAX validator){
        this.validator = validator;
    }
    @Override
    public void execute() {
        validator.validate();
    }
}

