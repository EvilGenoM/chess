package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import static Server.Server.getUserList;

public class User {
    private Socket socket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    private String name;

    public User(Socket socket){
        this.socket = socket;
    }

    public User(Socket socket, DataInputStream inputStream, DataOutputStream outputStream, String name){
        this.socket = socket;
        this.inputStream = inputStream;
        this.outputStream = outputStream;
        this.name = this.createName(name);
    }

    public Socket getSocket(){
        return this.socket;
    }

    public DataInputStream getInputStream(){
        return this.inputStream;
    }

    public DataOutputStream getOutputStream() {
        return this.outputStream;
    }

    public  String getName(){ return this.name; }

    private String createName(String name){

        String fakeName = name;
        int i = 1;

        for(User user : getUserList()){
            if(user.name.equals(fakeName)){
                fakeName = name + i;
                i++;
            }
        }

        return fakeName;

    }
}
