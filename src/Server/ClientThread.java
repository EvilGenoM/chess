package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static Server.Server.getUserList;

public class ClientThread extends Thread {

    private Socket socket;

    public ClientThread(Socket socket){
        this.socket = socket;
    }

    public void run(){
        try{
            DataInputStream in = new DataInputStream(this.socket.getInputStream());
            DataOutputStream out = new DataOutputStream(this.socket.getOutputStream());

            String name = in.readUTF();

            getUserList().add(new User(this.socket, in, out, name));

            String line = null;

            while(true){
                line = in.readUTF();
                System.out.println("Получена строка: " + line);
                for(User user : getUserList()){
                    user.getOutputStream().writeUTF(user.getName() + ": " + line);
                }
            }

        } catch (IOException ex){
            System.out.println(ex);
        }
    }

}
