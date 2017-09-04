package Server;

import java.io.*;
import java.net.*;

public class Server {
    int port = 8080;

    public static void main(String[] args) {
        Server server = new Server();
    }

    public Server(){
        try{
            ServerSocket serverSocket = new ServerSocket(this.port);

            System.out.println("Ожидание подключения...");

            while(true){
                Socket socket = null;
                while(socket == null){
                    socket = serverSocket.accept();
                }
                new ClientThread(socket);
            }

        } catch (IOException ex){
            System.out.println(ex);
        }

    }

}
