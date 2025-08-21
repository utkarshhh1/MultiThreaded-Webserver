import java.io.*;
import java.net.*;

public class Client {
    public void run() throws UnknownHostException, IOException {
        int port = 8080;
        InetAddress address = InetAddress.getByName("localhost");
        Socket socket = new Socket(address, port);
        PrintWriter toSocket = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        toSocket.println("Hello, server! This is the client.");
        String response = fromSocket.readLine();
        System.out.println("Server response: " + response);
        
        // Close resources
        toSocket.close();
        fromSocket.close();
        socket.close();
    }
    public static void main( String[] args) {
        try {
         Client client = new Client();
  client.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}