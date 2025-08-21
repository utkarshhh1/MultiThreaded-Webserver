import java.io.*;
import java.net.*;

public class Server {
    public void run() throws IOException {
        int port = 8080;
        ServerSocket socket = new ServerSocket(port);
        socket.setSoTimeout(10000);
        
        while (true) {
            try {
                System.out.println("Server is listening on port " + port);
                Socket client = socket.accept();
                System.out.println("Connection accepted from client " + client.getRemoteSocketAddress());
                
                PrintWriter toClient = new PrintWriter(client.getOutputStream(), true);
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
                
                String message = fromClient.readLine();
                System.out.println("Received from client: " + message);
                
                toClient.println("Hello, client! You are connected to the server.");
                
                toClient.close();
                fromClient.close();
                client.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        try {
            server.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}