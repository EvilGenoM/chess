package mobi.mpk.chess.net;



import mobi.mpk.chess.Message;
import mobi.mpk.chess.controller.Controller;
import mobi.mpk.chess.controller.ControllerGame;
import mobi.mpk.chess.controller.ControllerLobby;

import java.io.*;
import java.net.Socket;


public class ClientThread extends Thread {

    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private Controller controller;

    public ClientThread(Socket socket){

        this.socket = socket;

    }

    public void run(){
        try{
            in = new ObjectInputStream(this.socket.getInputStream());
            out = new ObjectOutputStream(this.socket.getOutputStream());

            while(true){

            }

        } catch (IOException ex){
            System.out.println(ex);
        }
    }




}
