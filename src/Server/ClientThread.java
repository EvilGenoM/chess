package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static Server.Server.getUserList;

public class ClientThread extends Thread {

    private Socket socket;
    private User enemy = null;
    private User player = null;
    DataInputStream in;
    DataOutputStream out;

    public ClientThread(Socket socket){
        this.socket = socket;
    }

    public void run(){
        try{
            in = new DataInputStream(this.socket.getInputStream());
            out = new DataOutputStream(this.socket.getOutputStream());

            String name = in.readUTF();

            player = new User(this.socket, in, out, name);
            getUserList().add(player);

            this.comand();

        } catch (IOException ex){
            System.out.println(ex);
        }
    }

    public void connect(String enemy) throws IOException {
        for(User user : getUserList()){
            if(user.getName().equals(enemy)){
                user.getOutputStream().writeUTF("К вам подсоединился игрок  " + player.getName());
                player.setConnect(true);
                user.setConnect(true);
                player.enemy = user;
                user.enemy = player;
                player.setStroke(true);
                while(player.getCon()){

                }
                game(user);
                break;
            }
        }

        player.getOutputStream().writeUTF("Игрок не найден");

    }

    public void game(User user){
        String line = null;
        try{
            player.getOutputStream().writeUTF("Началась игра");
            while(true) {
                if(player.getStroke() == true) {
                    player.getOutputStream().writeUTF("Ваш ход:");
                    line = in.readUTF();
                    System.out.println(player.getName() + ": " + line);

                    user.getOutputStream().writeUTF(player.getName() + ": " + line);
                    player.setStroke(false);
                    user.setStroke(true);
                }
            }

        } catch (IOException ex){
            System.out.println(ex);
        }
    }

    public void comand() {
        String line = null;
        try{
            while (true) {
                line = in.readUTF();
                System.out.println(player.getName() + ": " + line);

                String comand[] = line.split(" ");

                if (comand[0].equals("find")) {
                    connect(comand[1]);
                }

                if(line.equals("Y")){
                    player.enemy.setCon(false);
                    game(player.enemy);
                }

            }

        } catch (IOException ex){
            System.out.println(ex);
        }

    }



}
