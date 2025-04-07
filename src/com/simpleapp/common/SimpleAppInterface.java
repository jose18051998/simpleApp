package com.simpleapp.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SimpleAppInterface extends Remote {
    String getString() throws RemoteException;
}