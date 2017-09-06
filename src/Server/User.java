package Server;

import Server.Game.ChessBoard;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import static Server.Server.getUserList;

public class User {
    private Socket socket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    private String name;
    private boolean connect = false;
    User enemy = null;
    private boolean stroke = false;
    private boolean con = true;
    private ChessBoard board;

    public User(Socket socket){
        this.socket = socket;
    }

    public User(Socket socket, DataInputStream inputStream, DataOutputStream outputStream, String name){
        this.socket = socket;
        this.inputStream = inputStream;
        this.outputStream = outputStream;
        this.name = this.createName(name);
        this.connect = false;
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

    public boolean getConnect(){ return  this.connect; }

    public void setConnect(boolean connect){ this.connect = connect; }

    synchronized public void setCon(boolean con){ this.con = con;}

    synchronized public boolean getCon(){ return this.con;}

    synchronized public void setStroke(boolean stroke){ this.stroke = stroke;}

    synchronized public boolean getStroke(){ return this.stroke;}

    synchronized public void setChessBoard(ChessBoard board){ this.board = board;}

    synchronized public ChessBoard getChessBoard(){ return this.board;}

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
