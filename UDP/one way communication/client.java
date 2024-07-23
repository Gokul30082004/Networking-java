package networking.one_way_communication;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class udpclient {
    public static void main(String[] args) {
        try {
            System.out.println("Client started.");
            DatagramSocket socket = new DatagramSocket();
            int data = 10;
            byte[] sendData = String.valueOf(data).getBytes();
            InetAddress ip = InetAddress.getLocalHost();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ip, 9000);
            socket.send(sendPacket);
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);
            String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received from server: " + receivedMessage);
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
