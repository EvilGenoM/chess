package net;

import cli.Reply;
import cli.Request;
import controller.Controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class ClientThread extends Thread {

    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private Controller controller;

    public ClientThread(Socket socket){

        this.socket = socket;
        controller = new Controller();

    }

    public void run(){
        try{
            in = new ObjectInputStream(this.socket.getInputStream());
            out = new ObjectOutputStream(this.socket.getOutputStream());

            SendTheard sendTheard = new SendTheard();
            sendTheard.start();

            while(true){
                Request request =(Request) in.readObject();
                controller.handleRequest(request);
                System.out.println(request.getText());
            }

        } catch (IOException ex){
            System.out.println(ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    class SendTheard extends Thread{

        private boolean stop = false;

        public void setStop(){
            this.stop = true;
        }

        @Override
        public void run(){

            try{


                while (!stop) {
                    Reply reply = controller.getReply();
                    if(reply!= null) {
                        out.writeObject(reply);
                    }
                }


            } catch (IOException ex){

                System.out.println(ex);

            }

        }

    }


}
