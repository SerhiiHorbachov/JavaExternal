package ua.com.computers.commands;

import java.util.HashMap;
import java.util.Map;

public class CommandInvoker {
    Map<Integer, Command> commandMap;

    public CommandInvoker() {
        commandMap = new HashMap<>();
    }

    public void setCommands(int slot, Command command) {
        if (!commandMap.containsKey(slot)) {
            commandMap.put(slot, command);
        } else {
            System.out.println("The slot is already taken");
        }
    }

    public void runCommand(int command){
        commandMap.get(command).execute();
    }

    @Override
    public String toString() {
        StringBuffer stringBuff = new StringBuffer();
        stringBuff.append("\n--------Commands-------\n");

        for (Map.Entry<Integer, Command> entry : commandMap.entrySet()) {
            stringBuff.append("\n[" + entry.getKey() + "]");
            stringBuff.append("  -   " + entry.getValue().getClass().getSimpleName());
        }

        return stringBuff.toString();
    }
}
