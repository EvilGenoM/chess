package Server.Game;

import java.util.*;

public class Figure {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    Map<String, Figure> board;
    ArrayList<String> strokeFigure;
    public String name = "";
    public String location;
    private boolean white;
    private boolean oneStroke = true;

    Figure(Map<String, Figure> board, String location, boolean white){
        this.board = board;
        this.location = location;
        this.white = white;
    }


    public boolean getWhite(){ return this.white; }


    public boolean getOneStroke(){ return this.oneStroke; }


    public boolean move(String stroke){
        char[] nameCell = findSymbolNumber(location);

        strokeFigure = new ArrayList<String>();

        Stroke strokeHandle = new Stroke(board);

        strokeHandle.createListStrokes(strokeFigure, nameCell, this);

        boolean result = strokeHandle.moveFigure(strokeFigure, stroke, location, this);


        if(result) {
            this.location = stroke;
            oneStroke = false;
            return true;
        } else {
            return false;
        }


    }


    char[] findSymbolNumber(String stroke){
        char[] element = new char[2];
        element[0] = stroke.charAt(0);
        element[1] = stroke.charAt(1);

        return element;
    }


}

class King extends Figure{

    King(Map<String, Figure> board, String location, boolean white) {
        super(board, location, white);
        if(white){
            name = ANSI_GREEN+"K"+ANSI_RESET;
        }else {
            name = ANSI_RED+"K"+ANSI_RESET;
        }
    }

}

class Queen extends Figure{

    Queen(Map<String, Figure> board, String location, boolean white) {
        super(board, location, white);
        if(white){
            name = ANSI_GREEN+"Q"+ANSI_RESET;
        }else {
            name = ANSI_RED+"Q"+ANSI_RESET;
        }
    }

}

class Bishop extends Figure{

    Bishop(Map<String, Figure> board, String location, boolean white) {
        super(board, location, white);
        if(white){
            name = ANSI_GREEN+"B"+ANSI_RESET;
        }else {
            name = ANSI_RED+"B"+ANSI_RESET;
        }
    }


}

class kNight extends Figure{
    String location;

    kNight(Map<String, Figure> board, String location, boolean white) {
        super(board, location, white);
        if(white){
            name = ANSI_GREEN+"H"+ANSI_RESET;
        }else {
            name = ANSI_RED+"H"+ANSI_RESET;
        }
    }


}

class Rook extends Figure{

    Rook(Map<String, Figure> board, String location, boolean white) {
        super(board, location, white);
        if(white){
            name = ANSI_GREEN+"R"+ANSI_RESET;
        }else {
            name = ANSI_RED+"R"+ANSI_RESET;
        }
    }

}


class Pawn extends Figure{

    Pawn(Map<String, Figure> board, String location, boolean white) {
        super(board, location, white);
        if(white){
            name = ANSI_GREEN+"P"+ANSI_RESET;
        }else {
            name = ANSI_RED+"P"+ANSI_RESET;
        }
    }


}