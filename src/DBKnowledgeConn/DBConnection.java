/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBKnowledgeConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Michel
 */
public class DBConnection {

    private static final String DRIVERNAME = "com.mysql.jdbc.Driver";
    private static final String SERVERNAME = "<SERVER NAME AND PORT>";
    private static final String MYDATABASE = "<DATABASE NAME>";
    private static final String USERNAME = "<USERNAME>";
    private static final String PASSWORD = "<PASSWORD>";

    public static String status = "Connection failed...";

    public DBConnection() {

    }

    public static java.sql.Connection getMySQLConnection() {
        Connection connection = null;

        try {

            //Connection set up
            Class.forName(DRIVERNAME);

            String url = "jdbc:mysql://" + SERVERNAME + "/" + MYDATABASE;

            connection = DriverManager.getConnection(url, USERNAME, PASSWORD);

            //Connection test
            if (connection != null) {

                status = ("STATUS--->Connection Successfull");

            } else {

                status = ("STATUS--->Connection Failed");
            }

            return connection;

        } catch (ClassNotFoundException e) {

            System.out.println("Driver not found");

            return null;

        } catch (SQLException e) {

            System.out.println("Connection Failed");

            return null;
        }
    }

    public static String statusConnection() {

        return status;
    }

    public static boolean CloseConnection() {

        try {

            DBConnection.getMySQLConnection().close();

            return true;

        } catch (SQLException e) {

            return false;

        }

    }

    public static java.sql.Connection RestartConnection() {

        CloseConnection();

        return DBConnection.getMySQLConnection();

    }

}
