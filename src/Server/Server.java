package Server;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Server {
    int port = 8080;
    private static ArrayList<User> userList = new ArrayList<User>();

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
                new ClientThread(socket).start();
            }

        } catch (IOException ex){
            System.out.println(ex);
        }

    }

    public static synchronized ArrayList<User> getUserList(){
        return userList;
    }

}
