package javalabpart3;
import java.net.*;

public class UDPServer_7 {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket(6000);

            byte[] buffer = new byte[1024];

            DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
            System.out.println("UDP Server waiting for message...");

            ds.receive(dp);

            String msg = new String(dp.getData(), 0, dp.getLength());
            System.out.println("Client says: " + msg);

            String reply = "Hello Client, UDP message received.";
            byte[] data = reply.getBytes();

            InetAddress ip = dp.getAddress();
            int port = dp.getPort();

            DatagramPacket response = new DatagramPacket(data, data.length, ip, port);
            ds.send(response);

            ds.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}