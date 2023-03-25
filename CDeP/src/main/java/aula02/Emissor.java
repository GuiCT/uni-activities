/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula02;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author guilherme
 */
public class Emissor {
    private Socket sock;
    private int ownPort;
    private int destinationPort;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira a porta do direcionador: ");
        int portaDirecionador = sc.nextInt();
        Emissor emissor = new Emissor(portaDirecionador);
        emissor.run();
    }
    
    public Emissor(int m_DestinationPort) {
        this.destinationPort = m_DestinationPort;
        try {
            this.sock = new Socket("127.0.0.1", m_DestinationPort);
            this.ownPort = sock.getPort();
        }
        catch (UnknownHostException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void run() {
        String inputBuffer;
        Scanner sc = new Scanner(System.in);
        OutputStream sockOS;
        
        try {
            sockOS = this.sock.getOutputStream();
        }
        catch(IOException e) {
            System.out.println("Não foi possível obter OS a partir do socket");
            return;
        }
        
        do {
            System.out.println("Insira uma mensagem para ser enviada: ");
            inputBuffer = sc.nextLine();
            try {
                sockOS.write(inputBuffer.getBytes("UTF8"));
            }
            catch (IOException e) {
                System.out.println("Não foi possível enviar mensagem.");
            }
            System.out.println("Mensagem enviada com sucesso.");
        } while(!inputBuffer.equals(""));
        
        try {
            sockOS.close();
        }
        catch (IOException e) {
            System.out.println("Não foi possível fechar OS do Socket");
        }
    }
    
    @Override
    public void finalize() {
        try {
            this.sock.close();
        }
        catch (IOException e) {
            System.out.println("Não foi possível fechar Socket");
        }
    }
    
}
