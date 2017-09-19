package mobi.mpk.chess.controller;

import mobi.mpk.chess.Message;
import mobi.mpk.chess.command.*;

import java.util.Date;

public class ControllerLobby implements Controller{

    @Override
    public Message handleMessage(Message message){

        String name = message.getName();
        String text = message.getText();

        String resultComand = executeCommand(name, text);

        message.setText(resultComand);
        message.setDate(new Date());

        return message;

    }

    private String executeCommand(String name, String text){

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

                command = new JoinPlayerCommand(splitCommand[1]);
                return command.execute();

            case "expect":

                command = new ExpectGameCommand(name);
                return command.execute();

            default:
                return "Error";
        }

    }

}
