import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    public Runnable getRunnable(int id) {
        return () -> {
            int port = 8080;
            try (
                Socket socket = new Socket(InetAddress.getByName("localhost"), port);
                PrintWriter toSocket = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()))
            ) {
                toSocket.println("Hello, server! This is client #" + id + ".");
                String response = fromSocket.readLine();
                System.out.println("Client #" + id + " - Server response: " + response);
            } catch (IOException e) {
                System.err.println("Client #" + id + " - Error: " + e.getMessage());
                e.printStackTrace();
            }
        };
    }

    public static void main(String[] args) {
        Client client = new Client();
        for (int i = 0; i < 100; i++) {
            try {
                Thread thread = new Thread(client.getRunnable(i));
                thread.start();
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }
}