package ua.com.computers.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class BasicConnectionPool {

    private static int INITIAL_POOL_SIZE = 5;
    private static int MAX_POOL_SIZE = 10;

    private static ResourceBundle resource = ResourceBundle.getBundle("database");

    private static String url = resource.getString("db.url");
    private static String user = resource.getString("db.user");
    private static String password = resource.getString("db.password");

    private static List<Connection> connectionPool;
    private static List<Connection> usedConnections = new ArrayList<>(INITIAL_POOL_SIZE);

    private BasicConnectionPool() {

    }

    public synchronized static Connection getConnection() {

        if (connectionPool == null) {
            connectionPool = new ArrayList<>(INITIAL_POOL_SIZE);
            for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
                try {
                    connectionPool.add(createConnection(url, user, password));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        if (connectionPool.isEmpty()) {
            if (usedConnections.size() < MAX_POOL_SIZE) {
                try {
                    connectionPool.add(createConnection(url, user, password));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                throw new RuntimeException(
                        "Maximum pool size reached, no available connections!");
            }
        }

        Connection connection = connectionPool.remove(connectionPool.size() - 1);
        usedConnections.add(connection);

        return connection;
    }

    public synchronized static boolean releaseConnection(Connection connection) {
        connectionPool.add(connection);
        return usedConnections.remove(connection);
    }

    public static int getSize() {
        return connectionPool.size() + usedConnections.size();
    }

    private static Connection createConnection(
            String url, String user, String password)
            throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static void shutdown()  {
        System.out.println("Shutdown\n...connectionPool: " + connectionPool.size());
        System.out.println("...returning usedConnections: " + usedConnections.size());
        if (usedConnections.size() > 0) {
            for (int i = 0; i < usedConnections.size(); i++) {
                releaseConnection(usedConnections.get(i));
            }
        }

        System.out.println("...usedConnections: " + usedConnections.size());
        System.out.println("...connectionPool: " + connectionPool.size());

        for (int i = 0; i < connectionPool.size(); i++) {
            try {
                connectionPool.get(i).close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        connectionPool.clear();
        System.out.println("...connectionPool: " + connectionPool.size());

    }

}
