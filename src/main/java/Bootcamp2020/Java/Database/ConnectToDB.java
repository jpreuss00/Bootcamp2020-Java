package Bootcamp2020.Java.Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectToDB {

    private String host;
    private String user;
    private String password;
    private String database;

    public ConnectToDB(String host, String user, String password, String database) {
        this.host = host;
        this.user = user;
        this.password = password;
        this.database = database;
    }

    public Connection connect() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://" + host + ":5432/" + database + "?user=" + user + "&password=" + password);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }

}