package javalab;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

// Interface
interface AddInterface extends Remote {
    int add(int a, int b) throws RemoteException;
}

// Server
public class AddServer_5 extends UnicastRemoteObject implements AddInterface {

    public AddServer_5() throws RemoteException {
        super();
    }

    public int add(int a, int b) throws RemoteException {
        return a + b;
    }

    public static void main(String[] args) {
        try {
            AddServer_5 obj = new AddServer_5();

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("AddService", obj);

            System.out.println("Server running...");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}