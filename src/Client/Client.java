package Client;

import java.io.IOException;
import java.io.*;
import java.net.*;

public class Client {

    private int port = 8080;
    private String adress = "127.0.0.1";
    private DataInputStream in;
    private DataOutputStream out;


    public static void main(String[] args) {
        Client client = new Client();
    }


    public Client(){
        try{
            Socket socket = new Socket(adress, port);
            System.out.println("Мы подключились!");


            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Введите имя:");

            String name = reader.readLine();
            out.writeUTF(name);

            System.out.println("Присоединится к игроку с именем:");

            String line = null;

            Render render = new Render();
            render.start();

            String enemy = reader.readLine();
            out.writeUTF(enemy);

            while(true){
                line = reader.readLine();
                out.writeUTF(line);
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
        private boolean stop;

        public void setStop(){
            this.stop = true;
        }

        @Override
        public void run(){
            try{
                while (!stop) {
                    String str = in.readUTF();
                    System.out.println(str);
                }
            } catch (IOException ex){
                System.out.println(ex);
            }
        }

    }



}
