package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static Server.Server.getUserList;

public class ClientThread extends Thread {

    private Socket socket;
    private User enemy = null;

    public ClientThread(Socket socket){
        this.socket = socket;
    }

    public void run(){
        try{
            DataInputStream in = new DataInputStream(this.socket.getInputStream());
            DataOutputStream out = new DataOutputStream(this.socket.getOutputStream());

            String name = in.readUTF();

            User player = new User(this.socket, in, out, name);
            getUserList().add(player);

            String enemy = in.readUTF();

            if(player.enemy != null){
                this.enemy = player.enemy;
                this.enemy.getOutputStream().writeUTF(player.getName()+":" + enemy);
            }

                while (player.getConnect() == false) {
                    player.getOutputStream().writeUTF(connect(player, enemy));
                    if (this.enemy != null) {
                        player.setConnect();
                        this.enemy.setConnect();
                        this.enemy.enemy = player;
                        break;
                    }
                    enemy = in.readUTF();
                }

            System.out.println("Player" + this.enemy.getName());
            String line = null;

            while(true){
                line = in.readUTF();
                System.out.println("Получена строка: " + line);
                this.enemy.getOutputStream().writeUTF(player.getName() + ": " + line);
            }

        } catch (IOException ex){
            System.out.println(ex);
        }
    }

    public String connect(User player, String enemy) throws IOException {
        String con = " ";
        for(User user : getUserList()){
            if(user.getName().equals(enemy)){
                user.getOutputStream().writeUTF("К вам подсоединился игрок  " + player.getName());
                this.enemy = user;
                con = "Успех";
                break;
            }
            con = "Неверное имя. Повторите попытку...";
        }
        return con;
    }


}
