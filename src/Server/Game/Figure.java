package Server.Game;

import java.util.*;

public abstract class Figure {

    Map<String, Figure> board;

    Figure(Map<String, Figure> board){
        this.board = board;
    }

    abstract void move(String stroke);

    abstract void attack(String stroke);
}

class King extends Figure{

    King(Map<String, Figure> board) {
        super(board);
    }

    @Override
    public void move(String stroke){

    }

    @Override
    public void attack(String stroke){

    }


}

class Queen extends Figure{

    Queen(Map<String, Figure> board) {
        super(board);
    }

    @Override
    public void move(String stroke){

    }

    @Override
    public void attack(String stroke){

    }


}

class Bishop extends Figure{

    Bishop(Map<String, Figure> board) {
        super(board);
    }

    @Override
    public void move(String stroke){

    }

    @Override
    public void attack(String stroke){

    }


}

class kNight extends Figure{

    kNight(Map<String, Figure> board) {
        super(board);
    }

    @Override
    public void move(String stroke){

    }

    @Override
    public void attack(String stroke){

    }

}

class Rook extends Figure{

    Rook(Map<String, Figure> board) {
        super(board);
    }

    @Override
    public void move(String stroke){

    }

    @Override
    public void attack(String stroke){

    }


}


class Pawn extends Figure{

    Pawn(Map<String, Figure> board) {
        super(board);
    }

    @Override
    public void move(String stroke){

    }

    @Override
    public void attack(String stroke){

    }


}