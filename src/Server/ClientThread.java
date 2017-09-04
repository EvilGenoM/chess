package Server;

import java.net.Socket;

public class ClientThread extends Thread {

    private Socket socket;

    public ClientThread(Socket socket){
        this.socket = socket;
        this.start();
    }

    public void run(){

    }

}
