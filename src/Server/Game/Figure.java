package Server.Game;

import java.util.*;

public abstract class Figure {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";


    Map<String, Figure> board;
    ArrayList<String> strokeFigure;
    public String name = "";
    private boolean white;

    Figure(Map<String, Figure> board, boolean white){
        this.board = board;
        this.white = white;
    }

    public void setWhite(boolean white){ this.white = white; }

    public boolean getWhite(){ return this.white; }

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
        if(board.get(loc).white != this.white) {
            strokeFigure.add(loc);
        }
    }


    char[] findSymbolNumber(String stroke){
        char[] element = new char[2];
        element[0] = stroke.charAt(0);
        element[1] = stroke.charAt(1);

        return element;
    }


    public void strokeDiagonal(ArrayList<String> strokeFigure, char[] element){
        int number = Character.getNumericValue(element[1]);
        char sym = element[0];
        while(number != 8 && sym != 'h'){
            ++sym;
            ++number;
            writeList(strokeFigure, ""+(sym)+(number));
            if(board.get(""+(sym)+(number)) != null){
                break;
            }
        }

        number = Character.getNumericValue(element[1]);
        sym = element[0];

        while(number != 8 && sym != 'a'){
            --sym;
            ++number;
            writeList(strokeFigure, ""+(sym)+(number));
            if(board.get(""+(sym)+(number)) != null){
                break;
            }
        }

        number = Character.getNumericValue(element[1]);
        sym = element[0];

        while(number != 1 && sym != 'h'){
            ++sym;
            --number;
            writeList(strokeFigure, ""+(sym)+(number));
            if(board.get(""+(sym)+(number)) != null){
                break;
            }
        }

        number = Character.getNumericValue(element[1]);
        sym = element[0];

        while(number != 1 && sym != 'a'){
            --sym;
            --number;
            writeList(strokeFigure, ""+(sym)+(number));
            if(board.get(""+(sym)+(number)) != null){
                break;
            }
        }

    }


    public void strokeLine(ArrayList<String> strokeFigure, char[] element){

        int number = Character.getNumericValue(element[1]);
        char sym = element[0];

        while(sym != 'a'){
            --sym;
            writeList(strokeFigure, ""+sym+number);
            if(board.get(""+sym+number) != null){
                break;
            }
        }

        while(number != 1){
            --number;
            writeList(strokeFigure, ""+element[0]+number);
            if(board.get(""+element[0]+number) != null){
                break;
            }
        }

        number = Character.getNumericValue(element[1]);
        sym = element[0];

        while(sym != 'h'){
            ++sym;
            writeList(strokeFigure, ""+sym+number);
            if(board.get(""+sym+number) != null){
                break;
            }
        }

        while(number != 8){
            ++number;
            writeList(strokeFigure, ""+element[0]+number);
            if(board.get(""+element[0]+number) != null){
                break;
            }
        }
    }


}

class King extends Figure{
    String location;

    King(Map<String, Figure> board, String loc, boolean white) {
        super(board, white);
        this.location = loc;
        if(white){
            name = ANSI_GREEN+"K"+ANSI_RESET;
        }else {
            name = ANSI_RED+"K"+ANSI_RESET;
        }
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

    String location;

    Queen(Map<String, Figure> board, String loc, boolean white) {
        super(board, white);
        this.location = loc;
        if(white){
            name = ANSI_GREEN+"Q"+ANSI_RESET;
        }else {
            name = ANSI_RED+"Q"+ANSI_RESET;
        }
    }

    @Override
    public boolean move(String stroke){
        boolean result = false;
        char[] element = findSymbolNumber(location);

        strokeFigure = new ArrayList<String>();


        strokeLine(strokeFigure, element);
        strokeDiagonal(strokeFigure, element);



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

class Bishop extends Figure{
    String location;

    Bishop(Map<String, Figure> board, String loc, boolean white) {
        super(board, white);
        this.location = loc;
        if(white){
            name = ANSI_GREEN+"B"+ANSI_RESET;
        }else {
            name = ANSI_RED+"B"+ANSI_RESET;
        }
    }

    @Override
    public boolean move(String stroke){
        boolean result = false;
        char[] element = findSymbolNumber(location);

        strokeFigure = new ArrayList<String>();


        int number = Character.getNumericValue(element[1]);
        char sym = element[0];

        strokeDiagonal(strokeFigure, element);



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

class kNight extends Figure{
    String location;

    kNight(Map<String, Figure> board, String loc, boolean white) {
        super(board, white);
        this.location = loc;
        if(white){
            name = ANSI_GREEN+"H"+ANSI_RESET;
        }else {
            name = ANSI_RED+"H"+ANSI_RESET;
        }
    }

    @Override
    public boolean move(String stroke){
        boolean result = false;
        char[] element = findSymbolNumber(location);

        strokeFigure = new ArrayList<String>();


        int number = Character.getNumericValue(element[1]);
        char sym = element[0];

        if(number <= 6){
            sym = element[0];
            if(element[0] != 'a') {
                writeList(strokeFigure, "" + (--sym) + (number + 2));
            }
            sym = element[0];
            if(element[0] != 'h') {
                writeList(strokeFigure, "" + (++sym) + (number + 2));
            }
        }

        if(number >= 3){
            sym = element[0];
            if(element[0] != 'a') {
                writeList(strokeFigure, "" + (--sym) + (number - 2));
            }
            sym = element[0];
            if(element[0] != 'h') {
                writeList(strokeFigure, "" + (++sym) + (number - 2));
            }
        }

        if(element[0] >= 'c'){
            sym = element[0];
            if(number != 1) {
                --sym;
                --sym;
                writeList(strokeFigure, "" + (sym) + (--number));
            }
            sym = element[0];
            if(number != 8) {
                --sym;
                --sym;
                writeList(strokeFigure, "" + (sym) + (++number));
            }
        }

        if(element[0] <= 'f'){
            sym = element[0];
            if(number != 1) {
                ++sym;
                ++sym;
                writeList(strokeFigure, "" + (sym) + (--number));
            }
            sym = element[0];
            if(number != 8) {
                ++sym;
                ++sym;
                writeList(strokeFigure, "" + (sym) + (++number));
            }
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

class Rook extends Figure{
    String location;

    Rook(Map<String, Figure> board, String loc, boolean white) {
        super(board, white);
        this.location = loc;
        if(white){
            name = ANSI_GREEN+"R"+ANSI_RESET;
        }else {
            name = ANSI_RED+"R"+ANSI_RESET;
        }
    }

    @Override
    public boolean move(String stroke){
        boolean result = false;
        char[] element = findSymbolNumber(location);

        strokeFigure = new ArrayList<String>();


        strokeLine(strokeFigure, element);



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


class Pawn extends Figure{

    private boolean one;
    private String location;

    Pawn(Map<String, Figure> board, String loc, boolean white) {
        super(board, white);
        one = true;
        location = loc;
        if(white){
            name = ANSI_GREEN+"P"+ANSI_RESET;
        }else {
            name = ANSI_RED+"P"+ANSI_RESET;
        }
    }

    @Override
    public boolean move(String stroke){
        boolean result = false;
        char[] element = findSymbolNumber(location);
        char[] elementAtack = findSymbolNumber(stroke);
        int number = Character.getNumericValue(element[1]);

        if(this.getWhite()) {



            if ((element[0] != 'a')
                    && (elementAtack[0] == (element[0] - 1))
                    && (Character.getNumericValue(elementAtack[1]) == Character.getNumericValue(element[1]) + 1)
                    && (board.get(stroke) != null)) {
                attack(stroke);
                one = false;
                return true;
            }


            if ((element[0] != 'h')
                    && (elementAtack[0] == element[0] + 1)
                    && (Character.getNumericValue(elementAtack[1]) == Character.getNumericValue(element[1]) + 1)
                    && (board.get(stroke) != null)) {
                attack(stroke);
                one = false;
                return true;
            }

            strokeFigure = new ArrayList<String>();

            if (element[1] != '8') {
                number++;
                if (board.get("" + element[0] + number) == null) {
                    strokeFigure.add("" + element[0] + number);
                } else {
                    return false;
                }
                if(one){
                    ++number;
                    if (board.get("" + element[0] + number) == null) {
                        strokeFigure.add("" + element[0] + number);
                    }
                }
            } else {
                return false;
            }

            if (stroke(strokeFigure, stroke, location)) {
                this.location = stroke;
                one = false;
                return true;
            } else {
                return false;
            }



        } else {



            if ((element[0] != 'a')
                    && (elementAtack[0] == (element[0] - 1))
                    && (Character.getNumericValue(elementAtack[1]) == Character.getNumericValue(element[1]) - 1)
                    && (board.get(stroke) != null)) {
                attack(stroke);
                one = false;
                return true;
            }


            if ((element[0] != 'h')
                    && (elementAtack[0] == element[0] + 1)
                    && (Character.getNumericValue(elementAtack[1]) == Character.getNumericValue(element[1]) - 1)
                    && (board.get(stroke) != null)) {
                attack(stroke);
                one = false;
                return true;
            }

            strokeFigure = new ArrayList<String>();

            if (element[1] != '1') {
                --number;
                if (board.get("" + element[0] + number) == null) {
                    strokeFigure.add("" + element[0] + number);
                } else {
                    return false;
                }
                if(one){
                    --number;
                    if (board.get("" + element[0] + number) == null) {
                        strokeFigure.add("" + element[0] + number);
                    }
                }
            } else {
                return false;
            }

            if (stroke(strokeFigure, stroke, location)) {
                this.location = stroke;
                one = false;
                return true;
            } else {
                return false;
            }



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