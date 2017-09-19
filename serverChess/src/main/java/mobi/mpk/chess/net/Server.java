package mobi.mpk.chess.net;

import java.io.*;
import java.net.*;

public class Server {

    int port = Configure.PORT;

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


}
