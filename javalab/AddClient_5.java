package javalab;
import java.rmi.*;
import java.rmi.registry.*;

public class AddClient_5 {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            AddInterface obj = (AddInterface) registry.lookup("AddService");

            int result = obj.add(15, 6);

            System.out.println("Addition = " + result);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}