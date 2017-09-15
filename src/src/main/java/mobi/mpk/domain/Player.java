package mobi.mpk.domain;

import mobi.mpk.domain.rules.Rules;
import mobi.mpk.net.User;

import static mobi.mpk.Constant.ERROR_MOVE;

public class Player {

    private User user;

    public Player(User user){
        this.user = user;
    }

    public User getUser(){
        return this.user;
    }

    public ResultStroke move(Stroke stroke, Board board, Rules rules, Color color){

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

            return rules.move(from, to, board, color);

        }

        ResultStroke resultStroke = new ResultStroke();
        resultStroke.setText(ERROR_MOVE);

        return resultStroke;

    }


    public boolean equals(Player player){
        if(player.user.equals(user)){
            return true;
        } else {
            return false;
        }
    }


}
