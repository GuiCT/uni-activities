/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author guilherme
 */
public class Direcionador extends Thread {
    private Socket connection;
    private DatagramSocket sock;
    private InetAddress address;
    private int[] serversPort;
    private String message;
    
    public static void main(String[] args) {
        try {
            ServerSocket serverSock = new ServerSocket(9999);
            while (true) {
                Direcionador direcionador = new Direcionador(
                    serverSock.accept(),
                        new int[]{ 10100, 10200, 10300}
                );
                direcionador.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public Direcionador(Socket m_Sock, int[] m_ServersPort) {
        this.serversPort = m_ServersPort;
        this.connection = m_Sock;
        
        try {
            this.sock = new DatagramSocket();
            this.address = InetAddress.getLocalHost();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void run() {
        byte[] buffer;
        try {
            buffer = new byte[1024];
            this.connection.getInputStream().read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        
        for (int i = 0; i < serversPort.length; i++) {
            try { 
                DatagramPacket toSend =
                        new DatagramPacket(buffer, buffer.length,
                                this.address, this.serversPort[i]
                        );
                this.sock.send(toSend);
            } catch (IOException e) {
              e.printStackTrace();
            }
        }
    }
    
    public void finalize() {
        this.sock.close();
    }
}
