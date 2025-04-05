package com.simpleapp.server;

import com.simpleapp.common.SimpleAppInterface;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class SimpleAppServer implements SimpleAppInterface {

    @Override
    public String getString() {
        return "This is a string stored in the server.";
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
