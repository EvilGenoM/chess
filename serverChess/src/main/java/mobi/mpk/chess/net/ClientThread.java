package mobi.mpk.chess.net;



import mobi.mpk.chess.message.ManagerMessages;
import mobi.mpk.chess.message.Message;
import mobi.mpk.chess.User;
import mobi.mpk.chess.controller.Controllable;
import mobi.mpk.chess.controller.LobbyController;
import mobi.mpk.chess.controller.ManagerConrollers;
import mobi.mpk.chess.registry.RegistryAllUsers;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.Socket;


public class ClientThread extends Thread {

    private Socket socket;
    private User user;
    private Controllable controller;

    public ClientThread(Socket socket, Controllable controller){

        this.socket = socket;
        this.controller = controller;

    }

    public ClientThread(Socket socket){

        this(socket, new LobbyController());

    }

    public void run(){
        try{
            DataInputStream in = new DataInputStream(this.socket.getInputStream());
            DataOutputStream out = new DataOutputStream(this.socket.getOutputStream());

            ManagerConrollers manager = new ManagerConrollers();

            String jsonString;
            while(true){

                jsonString = in.readUTF();
                Message messageIn = getMessage(jsonString);

                if(user != null) {
                    messageIn.checkIntegeryData(user.getName());
                }

                controller = manager.getController(user);
                Message messageOut = controller.handleMessage(messageIn);

                fillFieldUser(messageOut.getName());

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

        ManagerMessages manager = new ManagerMessages(json);

        Message message = manager.getMessage();

        return message;

    }

    private void fillFieldUser(String name){

        if(this.user == null){

            User user = RegistryAllUsers.getInstance().getUser(name);
            this.user = user;

        }

    }

    private String getJsonString(Message message){

        JSONObject jsonObject = message.getJson();

        return jsonObject.toJSONString();
    }


}
