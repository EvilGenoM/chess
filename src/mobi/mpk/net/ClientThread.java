package mobi.mpk.server;

import mobi.mpk.server.Game.ChessBoard;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static java.lang.System.currentTimeMillis;

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
            Server.getUserList().add(player);

            this.comand();

        } catch (IOException ex){
            Server.getUserList().remove(player);
            System.out.println(ex);
        }
    }

    private boolean connect(String enemy) throws IOException {
        for(User user : Server.getUserList()){
            if(user.getName().equals(enemy) && user.getConnect() == false){
                player.getOutputStream().writeUTF("Ожидайте ответа...");
                user.getOutputStream().writeUTF("Вам предложил поиграть игрок " + player.getName()+" Введите [Y/N]");
                player.setConnect(true);
                user.setConnect(true);
                player.enemy = user;
                user.enemy = player;
                ChessBoard board = new ChessBoard();
                player.setWhite(board.whoWhite());
                player.setChessBoard(board);
                player.setStroke(player.getWhite());
                long time = currentTimeMillis();
                while(player.getCon()){
                    if(currentTimeMillis() - time > 20000){
                        unconnect(user);
                        return false;
                    }
                    if(user.getConnect() == false){
                        return false;
                    }
                }
                game(user);
                player.setCon(true);
                return true;
            }
        }

        return false;

    }

    synchronized private void unconnect(User enemy){
        player.setCon(true);
        enemy.setCon(true);
        player.setConnect(false);
        enemy.setConnect(false);
        player.enemy = null;
        enemy.enemy = null;
    }

    private void game(User enemy){
        String line = null;
        try{
            player.getOutputStream().writeUTF("Началась игра");
            player.getOutputStream().writeUTF(listCommandGame());
            if(player.getWhite()){
                player.getOutputStream().writeUTF("Ваши белые фигуры(желтые)");
            } else {
                player.getOutputStream().writeUTF("Ваши черные фигуры(красные)");
            }
            while(true) {
                if(player.getStroke() == true) {
                    player.getOutputStream().writeUTF("Ваш ход:");
                    line = in.readUTF();
                    System.out.println(player.getName() + ": " + line);

                    if(line.equals("close")) {
                        unconnect(enemy);
                        enemy.getOutputStream().writeUTF("Вы победили! Игрок "+player.getName()+" сдался!");
                        player.getOutputStream().writeUTF("Вы сдались! Игрок "+enemy.getName()+" победил!");
                        break;
                    }

                    if(line.equals("board")){
                        line = player.getChessBoard().viewBoard();
                        player.getOutputStream().writeUTF(line);
                        continue;
                    }

                    if(line.equals("figure")) {
                        line = listFigure();
                        player.getOutputStream().writeUTF(line);
                        continue;
                    }

                    boolean resultStroke = player.getChessBoard().strokeFigure(line, player.getWhite());
                    if(resultStroke){
                        player.getOutputStream().writeUTF("Успех");
                    } else {
                        player.getOutputStream().writeUTF("Ошибка");
                        continue;
                    }

                    enemy.getOutputStream().writeUTF(player.getName() + ": " + line);
                    String end = player.getChessBoard().gameEnd();
                    if(!(end.equals(""))){
                        player.getOutputStream().writeUTF(end);
                        enemy.getOutputStream().writeUTF(end);
                        unconnect(enemy);
                        break;
                    }

                    if(enemy.getChessBoard().takeStep(player.getWhite())){
                        enemy.getOutputStream().writeUTF("Вам шаг!");
                        player.getOutputStream().writeUTF("Вы поставили шаг!");
                    }


                    player.setStroke(false);
                    enemy.setStroke(true);
                }
                if(player.getConnect() == false){
                    player.setCon(true);
                    player.getOutputStream().writeUTF("Разрыв соединения...");
                    break;
                }
            }

        } catch (IOException ex){
            System.out.println(ex);
            unconnect(player.enemy);
        }
    }

    private void comand() {
        String line = null;
        try{
            player.getOutputStream().writeUTF(listCommand());
            while (true) {
                line = in.readUTF();
                System.out.println(player.getName() + ": " + line);

                String comand[] = line.split(" ");

                if(line.equals("help")){ player.getOutputStream().writeUTF(listCommand()); continue;}

                if (comand[0].equals("join") && comand[1] != null) { connectPlayer(comand[1]); continue;}

                if(line.equals("players")){ listPlayers(); continue;}

                if(line.equals("Y")){ confirmConnect(); continue;}
                else if(line.equals("N") && player.getConnect() == true){
                    unconnect(player.enemy);
                    continue;
                }

            }

        } catch (IOException ex){
            System.out.println(ex);
            Server.getUserList().remove(player);
        }

    }

    private String listCommand(){
        String list = "\njoin Name - пригласить игрока в игру\nplayers - список игроков в игре\nhelp - список команд";
        return list;
    }


    private void confirmConnect(){
        player.enemy.setCon(false);
        player.setWhite(!player.enemy.getWhite());
        player.setStroke(!player.enemy.getStroke());
        player.setChessBoard(player.enemy.getChessBoard());
        game(player.enemy);
    }

    private void connectPlayer(String name){
        try{
            boolean resultConnect = connect(name);
            if(!resultConnect){
                player.getOutputStream().writeUTF("Ошибка подключения...");
            }
        } catch (IOException ex){
            System.out.println(ex);
        }

    }

    private void listPlayers(){
        try {
            String line = "";
            for (User user : Server.getUserList()) {
                if (user.getConnect() == false) {
                    line += user.getName() + "\n";
                }
            }
            player.getOutputStream().writeUTF(line);
        } catch (IOException ex){
            System.out.println(ex);
        }

    }

    private String listCommandGame(){
        String list = "\nboard - показать доску\nfigure - показать наименования фигур\nclose - сдаться и завершить игру\nhelp - список команд";
        return list;
    }

    private String listFigure(){
        String line = "P - пешка\nK-король\nQ - ферзь\nB - слон\nH - конь\nR - ладья";
        return line;
    }



}
