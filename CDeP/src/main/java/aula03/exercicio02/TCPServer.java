import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
  public static void main(String[] args) {
    ServerSocket tcpSocket = null;
    InetAddress address = InetAddress.getLocalHost();
    try {
      tcpSocket = new ServerSocket(9999, 0, address);
    }
    
  }
}
