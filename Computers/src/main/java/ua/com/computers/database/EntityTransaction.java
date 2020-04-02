package ua.com.computers.database;

import ua.com.computers.dao.abstracts.AbstractDAO;

import java.sql.Connection;
import java.sql.SQLException;

public class EntityTransaction {
    private Connection connection;

    public void begin(AbstractDAO dao, AbstractDAO... daos) {
        if (connection == null) {
            connection = BasicConnectionPool.getConnection();
        }

        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        dao.setConnection(connection);
        for (AbstractDAO daoElement : daos) {
            daoElement.setConnection(connection);
        }
    }

    public void commit() {
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void rollback() {
        try {
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void end() {
        try {
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        BasicConnectionPool.releaseConnection(connection);
        connection = null;
    }


}
