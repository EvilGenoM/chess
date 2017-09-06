package Server.Game;

import java.util.*;

public abstract class Figure {

    Map<String, Figure> board;
    ArrayList<String> strokeFigure;
    public String name = "";

    Figure(Map<String, Figure> board){
        this.board = board;
    }

    abstract boolean move(String stroke);

    abstract void attack(String stroke);


    public boolean stroke(ArrayList<String > strokeFigure, String stroke, String location){
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
                return true;
            }
        }
        return false;
    }


    public void writeList(ArrayList<String> strokeFigure, String loc){
            strokeFigure.add(loc);
    }


    char[] findSymbolNumber(String stroke){
        char[] element = new char[2];
        element[0] = stroke.charAt(0);
        element[1] = stroke.charAt(1);

        return element;
    }


}

class King extends Figure{
    String location;

    King(Map<String, Figure> board, String loc) {
        super(board);
        name = "K";
        this.location = loc;
    }

    @Override
    public boolean move(String stroke){
        boolean result = false;
        char[] element = findSymbolNumber(location);

        strokeFigure = new ArrayList<String>();

        int number = Character.getNumericValue(element[1]);
        char sym = element[0];

        if(element[1] != '1'){
            writeList(strokeFigure, ""+element[0]+(number-1));
            sym = element[0];
            if(element[0] != 'a'){
                writeList(strokeFigure, ""+(--sym) + (number-1));
            }
            sym = element[0];
            if(element[0] != 'h'){
                writeList(strokeFigure, ""+(++sym) + (number-1));
            }
        }

        if(element[1] != '8'){
            writeList(strokeFigure, ""+element[0] + (number+1));
            sym = element[0];
            if(element[0] != 'a'){
                writeList(strokeFigure, ""+(--sym) + (number+1));
            }
            sym = element[0];
            if(element[0] != 'h'){
                writeList(strokeFigure, ""+(++sym) + (number+1));
            }
        }

        if(element[0] != 'a'){
            sym = element[0];
            writeList(strokeFigure, ""+(--sym) + (number));
        }

        if(element[0] != 'h'){
            sym = element[0];
            writeList(strokeFigure, ""+(++sym) + (number));
        }



        if(stroke(strokeFigure, stroke, location)) {
            this.location = stroke;
            return true;
        } else {
            return false;
        }


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

        if((element[0] != 'a')
                && (elementAtack[0] == (element[0]-1))
                && (Character.getNumericValue(elementAtack[1]) == Character.getNumericValue(element[1])+1)
                && (board.get(stroke) != null)){
            attack(stroke);
            return true;
        }


        if((element[0] != 'h')
                && (elementAtack[0] == element[0]+1)
                && (Character.getNumericValue(elementAtack[1]) == Character.getNumericValue(element[1])+1)
                && (board.get(stroke) != null)){
            attack(stroke);
            return true;
        }

        strokeFigure = new ArrayList<String >();

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

        if(stroke(strokeFigure, stroke, location)) {
            this.location = stroke;
            return true;
        } else {
            return false;
        }
    }


    @Override
    public void attack(String stroke){
        for(Map.Entry entry : board.entrySet()){
            String key = (String) entry.getKey();
            if(key.equals(stroke)){
                entry.setValue(this);
            }
            if(key.equals(location)){
                entry.setValue(null);
            }
        }
        this.location = stroke;

    }


}