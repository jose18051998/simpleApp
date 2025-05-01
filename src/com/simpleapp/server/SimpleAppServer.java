package com.simpleapp.server;

import com.simpleapp.common.SimpleAppInterface;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class SimpleAppServer implements SimpleAppInterface {

    String dbUrl="jdbc:postgresql://localhost:5432/simpleapp";
    String dbUser ="postgres";
    String dbPassword ="ssplpms";

    @Override
    public String getString() {
        String result = "No data found";

        try (Connection dbConnection = DriverManager.getConnection(dbUrl, dbUser, dbPassword)){
            Statement statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT data FROM warehouse LIMIT 1");

            if (resultSet.next()) {
                result = resultSet.getString("data");
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return result;
    }

    public static void main(String[] args) {
        try {
            SimpleAppServer server = new SimpleAppServer();

            SimpleAppInterface stub = (SimpleAppInterface) UnicastRemoteObject.exportObject(server, 0);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("SimpleAppServer", stub);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}
