package javalabpart3;
import java.net.*;
import java.util.Scanner;

public class UDPClient_7 {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket();

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter message: ");
            String msg = sc.nextLine();

            byte[] data = msg.getBytes();

            InetAddress ip = InetAddress.getByName("localhost");

            DatagramPacket dp = new DatagramPacket(data, data.length, ip, 6000);
            ds.send(dp);

            byte[] buffer = new byte[1024];
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            ds.receive(reply);

            String response = new String(reply.getData(), 0, reply.getLength());
            System.out.println("Server says: " + response);

            ds.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}