package aula03.exercicio02;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class TCPReceiverServer {
    public static void main(String[] args) {
        TCPReceiverServer tcpReceiverServer = new TCPReceiverServer();
        tcpReceiverServer.updateAddressPorts();
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

    public int chosePort() {
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

        return option;
    }

    public void listenPort(int port) {

    }
}
