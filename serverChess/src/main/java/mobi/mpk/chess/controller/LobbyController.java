package mobi.mpk.chess.controller;

import mobi.mpk.chess.message.Message;
import mobi.mpk.chess.message.MessageCommand;
import mobi.mpk.chess.User;
import mobi.mpk.chess.command.*;
import mobi.mpk.chess.registry.RegistryAllUsers;

import java.util.Calendar;
import java.util.Date;

public class LobbyController implements Controllable {

    @Override
    public Message handleMessage(Message message){

        String name = message.getName();

        if(isNameNotExist(name)){
            message.setText("Error");
            return message;
        }

        String text = message.getText();

        String resultComand = executeCommand(name, text);

        message.setText(resultComand);
        message.setDate(new Date());

        return message;

    }

    private boolean isNameNotExist(String name){

        User user = RegistryAllUsers.getInstance().getUser(name);

        if(user == null){
            return true;
        } else {
            return false;
        }

    }

    private String executeCommand(String nameUser1, String text){

        String[] splitCommand = text.split(" ");
        Command command;

        switch (splitCommand[0]){
            case "lobby":

                command = new ShowUsersExpectGameCommand();
                return command.execute();

            case "listPlayers":

                command = new ShowUsersAppCommand();
                return command.execute();

            case "join":

                String nameUser2 = splitCommand[1];
                command = new JoinPlayerCommand(nameUser1, nameUser2);
                return command.execute();

            case "expect":

                command = new ExpectGameCommand(nameUser1);
                return command.execute();

            default:
                return "Error";
        }

    }

}
