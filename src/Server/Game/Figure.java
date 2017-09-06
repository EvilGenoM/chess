package Server.Game;

import java.util.*;

public abstract class Figure {

    Map<String, Figure> board;
    ArrayList<String> strokeFigure = new ArrayList<String>();
    private String location;
    public String name = "";

    Figure(Map<String, Figure> board){
        this.board = board;
    }

    Figure(Map<String, Figure> board, String loc){
        this.board = board;
        this.location = loc;
    }

    abstract boolean move(String stroke);

    abstract void attack(String stroke);

    char[] findSymbolNumber(String stroke){
        char[] element = new char[2];
        element[0] = stroke.charAt(0);
        element[1] = stroke.charAt(1);

        return element;
    }
}

class King extends Figure{

    King(Map<String, Figure> board) {
        super(board);
        name = "K";
    }

    @Override
    public boolean move(String stroke){
        boolean result = false;

        return result;
    }

    @Override
    public void attack(String stroke){

    }


}

class Queen extends Figure{

    Queen(Map<String, Figure> board) {
        super(board);
        name = "Q";
    }

    @Override
    public boolean move(String stroke){
        boolean result = false;

        return result;
    }

    @Override
    public void attack(String stroke){

    }


}

class Bishop extends Figure{

    Bishop(Map<String, Figure> board) {
        super(board);
        name = "B";
    }

    @Override
    public boolean move(String stroke){
        boolean result = false;

        return result;
    }

    @Override
    public void attack(String stroke){

    }


}

class kNight extends Figure{

    kNight(Map<String, Figure> board) {
        super(board);
        name = "H";
    }

    @Override
    public boolean move(String stroke){
        boolean result = false;

        return result;
    }

    @Override
    public void attack(String stroke){

    }

}

class Rook extends Figure{

    Rook(Map<String, Figure> board) {
        super(board);
        name = "R";
    }

    @Override
    public boolean move(String stroke){
        boolean result = false;

        return result;
    }

    @Override
    public void attack(String stroke){

    }


}


class Pawn extends Figure{

    private boolean one;
    private String location;

    Pawn(Map<String, Figure> board, String loc) {
        super(board);
        one = true;
        location = loc;
        name = "P";
    }

    @Override
    public boolean move(String stroke){
        boolean result = false;
        char[] element = findSymbolNumber(location);
        char[] elementAtack = findSymbolNumber(stroke);
        int number = Character.getNumericValue(element[1]);
        /*
        if((element[0] != 'a')
                && (elementAtack[0] == element[0]--)
                && (Character.getNumericValue(elementAtack[1]) == number++)
                && (board.get(stroke) != null)){
            attack(stroke);
            return true;
        }

        number--;

        if((element[0] != 'h')
                && (elementAtack[0] == element[0]++)
                && (Character.getNumericValue(elementAtack[1]) == number++)
                && (board.get(stroke) != null)){
            attack(stroke);
            return true;
        }

        number--;
        */
        if(element[1] != '8'){
            number++;
            if(board.get(""+element[0]+number) == null){
                strokeFigure.add(""+element[0]+number);
            } else {
                return false;
            }
        } else {
            return false;
        }

        for(String str : strokeFigure){
            if(str.equals(stroke)){
                for(Map.Entry entry : board.entrySet()){
                    String key = (String) entry.getKey();
                    if(key.equals(stroke)){
                        entry.setValue(this);
                    }
                    if(key.equals(location)){
                        entry.setValue(null);
                    }
                }
                this.location = str;
                return true;
            }
        }

        return result;
    }

    @Override
    public void attack(String stroke){

    }


}