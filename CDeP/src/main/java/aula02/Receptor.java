/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 *
 * @author guilherme
 */
public class Receptor {
    private DatagramSocket sock;
    private int port;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira a porta do receptor: ");
        int portaReceptor = sc.nextInt();
        Receptor receptor = new Receptor(portaReceptor);
        receptor.run();
    }
    
    public Receptor(int m_Port) {
        this.port = m_Port;
        try {
            this.sock = new DatagramSocket(m_Port);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void run() {
        byte[] recvBuffer = new byte[1024];
        while (true) {
            try {
                DatagramPacket response = new DatagramPacket(recvBuffer, recvBuffer.length);
                this.sock.receive(response);
                InetAddress address = response.getAddress();
                int port = response.getPort();
                response = new DatagramPacket(recvBuffer, recvBuffer.length, address, port);
                String receivedMessage = new String(response.getData(), 0, response.getLength());
                System.out.println("Recebido: " + receivedMessage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
