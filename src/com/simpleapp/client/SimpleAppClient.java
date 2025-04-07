package com.simpleapp.client;

import com.simpleapp.common.SimpleAppInterface;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class SimpleAppClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            SimpleAppInterface stub = (SimpleAppInterface) registry.lookup("SimpleAppServer");

            String response = stub.getString();

            System.out.println("Response from the server: " + response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}