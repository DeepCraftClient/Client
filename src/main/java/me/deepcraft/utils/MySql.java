package me.deepcraft.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySql {
    private static final String host = "195.90.222.29";
    private static final String port = "3306";
    private static final String database = "deepcraft";
    private static final String password = "Dario";
    private static final String user = "root";
    private static Connection con;
    private static final Logger logger = Logger.getLogger(MySql.class.getName());

    public static boolean isConnected() {
        try {
            return con != null && !con.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }

    public static void connect() {
        if (!isConnected()) {
            int attempts = 0;
            final int maxAttempts = 3;
            while (attempts < maxAttempts) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, user, password);
                    logger.log(Level.INFO, "Connected to MySQL database.");
                    return; // Exit method if connection successful
                } catch (ClassNotFoundException | SQLException e) {
                    logger.log(Level.WARNING, "Error connecting to MySQL database. Retrying...", e);
                }
                attempts++;
                try {
                    Thread.sleep(2000); // Wait 2 seconds before retrying
                } catch (InterruptedException ignored) {
                }
            }
            logger.log(Level.SEVERE, "Failed to connect to MySQL database after multiple attempts.");
        }
    }

    public static void disconnect() {
        if (isConnected()) {
            try {
                con.close();
                con = null;
                logger.log(Level.INFO, "Disconnected from MySQL database.");
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "Error disconnecting from MySQL database.", e);
            }
        }
    }

    public static void update(String query) {
        try {
            if (!isConnected()) {
                connect(); // Reconnect if not connected
            }
            PreparedStatement ps = con.prepareStatement(query);
            ps.executeUpdate();
            logger.log(Level.INFO, "SQL query executed successfully: " + query);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error executing SQL query: " + query, e);
        }
    }
}
