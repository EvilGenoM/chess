package mobi.mpk.chess.net;



import mobi.mpk.chess.Message;
import mobi.mpk.chess.User;
import mobi.mpk.chess.controller.Controller;
import mobi.mpk.chess.controller.ControllerLobby;
import mobi.mpk.chess.registry.RegistryAllUsers;
import mobi.mpk.chess.registry.RegistryGames;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.Socket;


public class ClientThread extends Thread {

    private Socket socket;
    private User user;
    private Controller controller;

    public ClientThread(Socket socket, Controller controller){

        this.socket = socket;
        this.controller = controller;

    }

    public ClientThread(Socket socket){

        this(socket, new ControllerLobby());

    }

    public void run(){
        try{
            DataInputStream in = new DataInputStream(this.socket.getInputStream());
            DataOutputStream out = new DataOutputStream(this.socket.getOutputStream());

            String jsonString;
            while(true){

                jsonString = in.readUTF();
                Message messageIn = getMessage(jsonString);

                Message messageOut = controller.handleMessage(messageIn);

                fillFieldUser(messageOut.getName());
                checkStatusGame();

                jsonString = getJsonString(messageOut);
                out.writeUTF(jsonString);

            }

        } catch (IOException ex){
            System.out.println(ex);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private Message getMessage(String jsonString) throws ParseException {

        JSONParser jsonParser = new JSONParser();
        JSONObject json = (JSONObject) jsonParser.parse(jsonString);

        Message message = new Message(json);

        return message;
    }

    private void fillFieldUser(String name){

        User user = RegistryAllUsers.getInstance().getUser(name);
        if(this.user == null){
            this.user = user;
        }

    }

    private boolean checkStatusGame(){

        Controller controllerGame = RegistryGames.getInstance().getControllerGame(this.user);
        if(controllerGame != null){
            this.controller = controllerGame;
            return true;
        } else if(controller == null){
            this.controller = new ControllerLobby();
            return false;
        }

        return false;
    }

    private String getJsonString(Message message){

        JSONObject jsonObject = message.getJson();

        return jsonObject.toJSONString();
    }


}
