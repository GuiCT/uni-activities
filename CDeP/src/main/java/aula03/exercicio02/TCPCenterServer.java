package aula03.exercicio02;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TCPCenterServer {
  public static void main(String[] args) {
    TCPCenterServer instance = new TCPCenterServer();
    instance.run();
  }

  private ServerSocket tcpSocket = null;
  private final int[] availablePorts = new int[]{9001, 9002};

  public TCPCenterServer() {
    try {
      this.tcpSocket = new ServerSocket(9999);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void run() {
    try {
      while (true) {
        Socket sock = this.tcpSocket.accept();
        String multicastAddress = "224.224.6.6";
        String sentStr = String.format(
                "%s %d %d", multicastAddress, this.availablePorts[0], this.availablePorts[1]);
        sock.getOutputStream().write(sentStr.getBytes(StandardCharsets.UTF_8));
        sock.getOutputStream().flush();
        sock.close();
      }
    }
    catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
