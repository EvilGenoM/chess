package mobi.mpk.domain;

import mobi.mpk.domain.rules.Rules;
import mobi.mpk.net.User;

public class Player {

    private User user;

    public Player(User user){
        this.user = user;
    }

    public Player(){

    }

    public User getUser(){
        return this.user;
    }

    public String move(Stroke stroke, Board board, Rules rules){

        Cell[][] cells = board.getMassiveCell();
        Cell from = null;
        Cell to = null;

        for(int x = 0; x<8; x++){

            for (int y = 0; y<8; y++){

                if(cells[x][y].equals(stroke.getFrom())){

                    from = cells[x][y];

                } else if(cells[x][y].equals(stroke.getTo())){

                    to = cells[x][y];

                }

            }

        }

        if(from != null && to != null){

            boolean doStroke = rules.move(from, to, board);

            if(doStroke){
                return "Ход успешно сделан";
            } else {
                return "Ошибка хода";
            }

        }

        return "Ошибка хода";

    }

}
