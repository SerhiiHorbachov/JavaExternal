package ua.com.computers.commands;

import ua.com.computers.database.BasicConnectionPool;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        //Shutdown ConnectionPool
        BasicConnectionPool.shutdown();
        System.exit(0);
    }
}
