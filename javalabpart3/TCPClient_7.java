package javalabpart3;
import java.io.*;
import java.net.*;

public class TCPClient_7 {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 8000);

            BufferedReader keyboard = new BufferedReader(
                    new InputStreamReader(System.in)
            );

            PrintWriter out = new PrintWriter(s.getOutputStream(), true);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(s.getInputStream())
            );

            System.out.print("Enter message: ");
            String msg = keyboard.readLine();

            out.println(msg);

            String reply = in.readLine();
            System.out.println("Server says: " + reply);

            s.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}