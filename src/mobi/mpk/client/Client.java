package mobi.mpk.client;

import mobi.mpk.controller.Reply;
import mobi.mpk.controller.Request;

import java.io.IOException;
import java.io.*;
import java.net.*;

public class Client {

    private int port = 8080;
    private String adress = "127.0.0.1";
    private ObjectInputStream in;
    private ObjectOutputStream out;


    public static void main(String[] args) {
        Client client = new Client();
    }


    public Client(){
        try{
            Socket socket = new Socket(adress, port);
            System.out.println("Вы подключились!");


            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String line;

            Request request = new Request();

            request.setStart(true);

            line = reader.readLine();
            request.setText(line);

            out.writeObject(request);


            Render render = new Render();
            render.start();


            while(true){
                request = new Request();
                line = reader.readLine();
                request.setText(line);
                out.writeObject(request);
                if(line.equals("exit")) break;

            }

            in.close();
            out.close();
            socket.close();

        } catch (IOException ex){
            System.out.println(ex);
        }
    }


    public class Render extends Thread{
        private boolean stop = false;

        public void setStop(){
            this.stop = true;
        }

        @Override
        public void run(){
            try{

                Reply reply;

                while (!stop) {
                    reply =(Reply) in.readObject();
                    if(reply.getText() != null){
                        System.out.println(reply.getText());
                    } else {
                        System.out.println(reply.getLog());
                    }
                }
            } catch (IOException ex){
                System.out.println(ex);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }



}
