package net;

import controller.Controller;
import domain.Player;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    int port = 8080;
    private static ArrayList<User> userList = new ArrayList<User>();
    private static ArrayList<Controller> contollerList = new ArrayList<Controller>();
    private static ArrayList<Player> playersList = new ArrayList<Player>();

    public Server(){
        try{
            ServerSocket serverSocket = new ServerSocket(this.port);

            System.out.println("Ожидание подключения...");

            while(true){
                Socket socket = null;
                while(socket == null){
                    socket = serverSocket.accept();
                }
                (new ClientThread(socket)).start();
            }

        } catch (IOException ex){
            System.out.println(ex);
        }

    }

    public static synchronized ArrayList<User> getUserList(){
        return userList;
    }

    public static synchronized ArrayList<Controller> getControllerList(){
        return contollerList;
    }

    public static synchronized ArrayList<Player> getPlayersList(){
        return playersList;
    }

}
