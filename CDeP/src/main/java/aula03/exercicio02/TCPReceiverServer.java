package aula03.exercicio02;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class TCPReceiverServer {
    public static void main(String[] args) {
        TCPReceiverServer tcpReceiverServer = new TCPReceiverServer();
        tcpReceiverServer.updateAddressPorts();
        tcpReceiverServer.chosePort();
        tcpReceiverServer.listenPort();
    }

    private MulticastSocket multicastSocket;
    private String multicastAddress;
    private int[] availablePorts = new int[2];

    public void updateAddressPorts() {
        try {
            Socket sock;
            sock = new Socket(InetAddress.getLocalHost(), 9999);
            byte[] buffer = new byte[1024];
            int lenBytes = sock.getInputStream().read(buffer);
            byte[] received;
            received = Arrays.copyOfRange(buffer, 0, lenBytes);
            String receivedMessage = new String(received, StandardCharsets.UTF_8);
            // Parsing address and ports
            String[] recv = receivedMessage.strip().split(" ");
            System.out.println(receivedMessage);
            this.multicastAddress = recv[0];
            this.availablePorts[0] = Integer.parseInt(recv[1]);
            this.availablePorts[1] = Integer.parseInt(recv[2]);
            if (!sock.isClosed()) sock.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void chosePort() {
        Scanner sc = new Scanner(System.in);
        boolean correctInput = false;
        int option;
        String prompt = String.format("""
Selecione uma porta:
1: %d
2: %d
""", this.availablePorts[0], this.availablePorts[1]);
        do {
            System.out.println(prompt);
            option = sc.nextInt();
            if (option > 0 && option < 3)
                correctInput = true;
        } while(!correctInput);

        try {
            this.multicastSocket = new MulticastSocket(this.availablePorts[option - 1]);
            InetAddress group = InetAddress.getByName(this.multicastAddress);
            this.multicastSocket.joinGroup(group);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void listenPort() {
        byte[] buffer = new byte[1024];
        try {
            while (true) {
                DatagramPacket messageIn = new DatagramPacket(buffer, buffer.length);
                this.multicastSocket.receive(messageIn);
                String receivedMessage = new String(messageIn.getData());
                receivedMessage = receivedMessage.trim();
                System.out.println("Received:" + receivedMessage + " " + receivedMessage.length());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
