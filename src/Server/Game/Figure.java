package Server.Game;

import java.util.*;

public abstract class Figure {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    Map<String, Figure> board;
    ArrayList<String> strokeFigure;
    public String name = "";
    private String location;
    private boolean white;
    private boolean oneStroke = true;

    Figure(Map<String, Figure> board, String location, boolean white){
        this.board = board;
        this.location = location;
        this.white = white;
    }


    public boolean getWhite(){ return this.white; }


    public boolean getOneStroke(){ return this.oneStroke; }

    public String getLocation(){ return this.location; }


    public boolean move(String stroke){
        char[] nameCell = findSymbolNumber(location);

        strokeFigure = new ArrayList<String>();


        createListStrokes(strokeFigure, nameCell);

        boolean result = moveFigure(strokeFigure, stroke, location);


        if(result) {
            this.location = stroke;
            oneStroke = false;
            return true;
        } else {
            return false;
        }


    }

    abstract void createListStrokes(ArrayList<String> listStrokes, char[] nameCell);

    private boolean moveFigure(ArrayList<String > allStrokesFigure,
                              String yourStroke,
                              String locationFigure){

        for(String str : allStrokesFigure){
            if(str.equals(yourStroke)){
                for(Map.Entry entry : board.entrySet()){
                    String key = (String) entry.getKey();
                    if(key.equals(yourStroke)){
                        entry.setValue(this);
                    }
                    if(key.equals(locationFigure)){
                        entry.setValue(null);
                    }
                }
                return true;
            }
        }
        return false;

    }

    protected void writeStrokeInList(ArrayList<String> strokeFigure, String coordCell){

        if(board.get(coordCell) == null){
            strokeFigure.add(coordCell);
        } else {
            if (board.get(coordCell).getWhite() != this.getWhite()) {
                strokeFigure.add(coordCell);
            }
        }

    }


    public char[] findSymbolNumber(String stroke){
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

    @Override
    public void createListStrokes(ArrayList<String> listStrokes, char[] nameCell){

        int numberCell = Character.getNumericValue(nameCell[1]);
        char symbolCell = nameCell[0];

        if(nameCell[1] != '1'){
            writeStrokeInList(listStrokes, ""+nameCell[0]+(numberCell-1));
            symbolCell = nameCell[0];
            if(nameCell[0] != 'a'){
                writeStrokeInList(listStrokes, ""+(--symbolCell) + (numberCell-1));
            }
            symbolCell = nameCell[0];
            if(nameCell[0] != 'h'){
                writeStrokeInList(listStrokes, ""+(++symbolCell) + (numberCell-1));
            }
        }

        if(nameCell[1] != '8'){
            writeStrokeInList(listStrokes, ""+nameCell[0] + (numberCell+1));
            symbolCell = nameCell[0];
            if(nameCell[0] != 'a'){
                writeStrokeInList(listStrokes, ""+(--symbolCell) + (numberCell+1));
            }
            symbolCell = nameCell[0];
            if(nameCell[0] != 'h'){
                writeStrokeInList(listStrokes, ""+(++symbolCell) + (numberCell+1));
            }
        }

        if(nameCell[0] != 'a'){
            symbolCell = nameCell[0];
            writeStrokeInList(listStrokes, ""+(--symbolCell) + (numberCell));
        }

        if(nameCell[0] != 'h'){
            symbolCell = nameCell[0];
            writeStrokeInList(listStrokes, ""+(++symbolCell) + (numberCell));
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

    public void createListStrokes(ArrayList<String> listStrokes, char[] nameCell){

        strokesDiagonal(listStrokes, nameCell);
        strokesLine(listStrokes, nameCell);

    }

    private void strokesDiagonal(ArrayList<String> listStrokes, char[] nameCell){

        int numberCell = Character.getNumericValue(nameCell[1]);
        char symbolCell = nameCell[0];

        while(numberCell != 8 && symbolCell != 'h'){
            ++symbolCell;
            ++numberCell;
            writeStrokeInList(listStrokes, ""+(symbolCell)+(numberCell));
            if(board.get(""+(symbolCell)+(numberCell)) != null){
                break;
            }
        }

        numberCell = Character.getNumericValue(nameCell[1]);
        symbolCell = nameCell[0];

        while(numberCell != 8 && symbolCell != 'a'){
            --symbolCell;
            ++numberCell;
            writeStrokeInList(listStrokes, ""+(symbolCell)+(numberCell));
            if(board.get(""+(symbolCell)+(numberCell)) != null){
                break;
            }
        }

        numberCell = Character.getNumericValue(nameCell[1]);
        symbolCell = nameCell[0];

        while(numberCell != 1 && symbolCell != 'h'){
            ++symbolCell;
            --numberCell;
            writeStrokeInList(listStrokes, ""+(symbolCell)+(numberCell));
            if(board.get(""+(symbolCell)+(numberCell)) != null){
                break;
            }
        }

        numberCell = Character.getNumericValue(nameCell[1]);
        symbolCell = nameCell[0];

        while(numberCell != 1 && symbolCell != 'a'){
            --symbolCell;
            --numberCell;
            writeStrokeInList(listStrokes, ""+(symbolCell)+(numberCell));
            if(board.get(""+(symbolCell)+(numberCell)) != null){
                break;
            }
        }

    }

    private void strokesLine(ArrayList<String> listStrokes, char[] nameCell){
        int numberCell = Character.getNumericValue(nameCell[1]);
        char symbolCell = nameCell[0];

        while(symbolCell != 'a'){
            --symbolCell;
            writeStrokeInList(listStrokes, ""+symbolCell+numberCell);
            if(board.get(""+symbolCell+numberCell) != null){
                break;
            }
        }

        while(numberCell != 1){
            --numberCell;
            writeStrokeInList(listStrokes, ""+nameCell[0]+numberCell);
            if(board.get(""+nameCell[0]+numberCell) != null){
                break;
            }
        }

        numberCell = Character.getNumericValue(nameCell[1]);
        symbolCell = nameCell[0];

        while(symbolCell != 'h'){
            ++symbolCell;
            writeStrokeInList(listStrokes, ""+symbolCell+numberCell);
            if(board.get(""+symbolCell+numberCell) != null){
                break;
            }
        }

        while(numberCell != 8){
            ++numberCell;
            writeStrokeInList(listStrokes, ""+nameCell[0]+numberCell);
            if(board.get(""+nameCell[0]+numberCell) != null){
                break;
            }
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

    @Override
    public void createListStrokes(ArrayList<String> listStrokes, char[] nameCell){

        int numberCell = Character.getNumericValue(nameCell[1]);
        char symbolCell = nameCell[0];

        while(numberCell != 8 && symbolCell != 'h'){
            ++symbolCell;
            ++numberCell;
            writeStrokeInList(listStrokes, ""+(symbolCell)+(numberCell));
            if(board.get(""+(symbolCell)+(numberCell)) != null){
                break;
            }
        }

        numberCell = Character.getNumericValue(nameCell[1]);
        symbolCell = nameCell[0];

        while(numberCell != 8 && symbolCell != 'a'){
            --symbolCell;
            ++numberCell;
            writeStrokeInList(listStrokes, ""+(symbolCell)+(numberCell));
            if(board.get(""+(symbolCell)+(numberCell)) != null){
                break;
            }
        }

        numberCell = Character.getNumericValue(nameCell[1]);
        symbolCell = nameCell[0];

        while(numberCell != 1 && symbolCell != 'h'){
            ++symbolCell;
            --numberCell;
            writeStrokeInList(listStrokes, ""+(symbolCell)+(numberCell));
            if(board.get(""+(symbolCell)+(numberCell)) != null){
                break;
            }
        }

        numberCell = Character.getNumericValue(nameCell[1]);
        symbolCell = nameCell[0];

        while(numberCell != 1 && symbolCell != 'a'){
            --symbolCell;
            --numberCell;
            writeStrokeInList(listStrokes, ""+(symbolCell)+(numberCell));
            if(board.get(""+(symbolCell)+(numberCell)) != null){
                break;
            }
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

    @Override
    public void createListStrokes(ArrayList<String> listStrokes, char[] nameCell){

        int numberCell = Character.getNumericValue(nameCell[1]);
        char symbolCell = nameCell[0];

        if(numberCell <= 6){
            symbolCell = nameCell[0];
            if(nameCell[0] != 'a') {
                writeStrokeInList(listStrokes, "" + (--symbolCell) + (numberCell + 2));
            }
            symbolCell = nameCell[0];
            if(nameCell[0] != 'h') {
                writeStrokeInList(listStrokes, "" + (++symbolCell) + (numberCell + 2));
            }
        }

        if(numberCell >= 3){
            symbolCell = nameCell[0];
            if(nameCell[0] != 'a') {
                writeStrokeInList(listStrokes, "" + (--symbolCell) + (numberCell - 2));
            }
            symbolCell = nameCell[0];
            if(nameCell[0] != 'h') {
                writeStrokeInList(listStrokes, "" + (++symbolCell) + (numberCell - 2));
            }
        }

        if(nameCell[0] >= 'c'){
            symbolCell = nameCell[0];
            if(numberCell != 1) {
                --symbolCell;
                --symbolCell;
                writeStrokeInList(listStrokes, "" + (symbolCell) + (--numberCell));
            }
            symbolCell = nameCell[0];
            if(numberCell != 8) {
                --symbolCell;
                --symbolCell;
                writeStrokeInList(listStrokes, "" + (symbolCell) + (++numberCell));
            }
        }

        if(nameCell[0] <= 'f'){
            symbolCell = nameCell[0];
            if(numberCell != 1) {
                ++symbolCell;
                ++symbolCell;
                writeStrokeInList(listStrokes, "" + (symbolCell) + (--numberCell));
            }
            symbolCell = nameCell[0];
            if(numberCell != 8) {
                ++symbolCell;
                ++symbolCell;
                writeStrokeInList(listStrokes, "" + (symbolCell) + (++numberCell));
            }
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

    @Override
    public void createListStrokes(ArrayList<String> listStrokes, char[] nameCell){

        int numberCell = Character.getNumericValue(nameCell[1]);
        char symbolCell = nameCell[0];

        while(symbolCell != 'a'){
            --symbolCell;
            writeStrokeInList(listStrokes, ""+symbolCell+numberCell);
            if(board.get(""+symbolCell+numberCell) != null){
                break;
            }
        }

        while(numberCell != 1){
            --numberCell;
            writeStrokeInList(listStrokes, ""+nameCell[0]+numberCell);
            if(board.get(""+nameCell[0]+numberCell) != null){
                break;
            }
        }

        numberCell = Character.getNumericValue(nameCell[1]);
        symbolCell = nameCell[0];

        while(symbolCell != 'h'){
            ++symbolCell;
            writeStrokeInList(listStrokes, ""+symbolCell+numberCell);
            if(board.get(""+symbolCell+numberCell) != null){
                break;
            }
        }

        while(numberCell != 8){
            ++numberCell;
            writeStrokeInList(listStrokes, ""+nameCell[0]+numberCell);
            if(board.get(""+nameCell[0]+numberCell) != null){
                break;
            }
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


    @Override
    public void createListStrokes(ArrayList<String> listStrokes, char[] nameCell){

        if(this.getWhite()){
            strokesWhitePawn(listStrokes, nameCell);
            attackWhitePawn(listStrokes, nameCell);
        } else {
            strokesBlackPawn(listStrokes, nameCell);
            attackBlackPawn(listStrokes, nameCell);
        }

    }

    private void strokesWhitePawn(ArrayList<String> listStrokes, char[] nameCell){

        int numberCell = Character.getNumericValue(nameCell[1]);

        if (nameCell[1] != '8') {
            ++numberCell;
            Figure cell = board.get("" + nameCell[0] + numberCell);
            if (cell == null) {
                listStrokes.add("" + nameCell[0] + numberCell);
            }
            if(this.getOneStroke() && cell == null){
                ++numberCell;
                cell = board.get("" + nameCell[0] + numberCell);
                if (cell == null) {
                    listStrokes.add("" + nameCell[0] + numberCell);
                }
            }
        }

    }

    private void strokesBlackPawn(ArrayList<String> listStrokes, char[] nameCell){

        int numberCell = Character.getNumericValue(nameCell[1]);

        if (nameCell[1] != '1') {
            --numberCell;
            Figure cell = board.get("" + nameCell[0] + numberCell);
            if (cell == null) {
                listStrokes.add("" + nameCell[0] + numberCell);
            }
            if(this.getOneStroke() && cell == null){
                --numberCell;
                cell = board.get("" + nameCell[0] + numberCell);
                if (cell == null) {
                    listStrokes.add("" + nameCell[0] + numberCell);
                }
            }
        }

    }

    private void attackWhitePawn(ArrayList<String> listStrokes, char[] nameCell){

        char symbolCell = nameCell[0];
        int numberCell = Character.getNumericValue(nameCell[1]);

        String attackCell = ""+(--symbolCell)+(++numberCell);
        Figure attackFigure = board.get(attackCell);

        if ((nameCell[0] != 'a') && attackFigure != null){
            writeStrokeInList(listStrokes, attackCell);
        }

        attackCell = ""+(++symbolCell)+(++numberCell);
        attackFigure = board.get(attackCell);

        if ((nameCell[0] != 'h') && attackFigure != null){
            writeStrokeInList(listStrokes, attackCell);
        }

    }

    private void attackBlackPawn(ArrayList<String> listStrokes, char[] nameCell){

        char symbolCell = nameCell[0];
        int numberCell = Character.getNumericValue(nameCell[1]);
        String attackCell = ""+(--symbolCell)+(--numberCell);
        Figure attackFigure = board.get(attackCell);

        if ((nameCell[0] != 'a') && attackFigure != null){
            writeStrokeInList(listStrokes, attackCell);
        }

        symbolCell = nameCell[0];
        numberCell = Character.getNumericValue(nameCell[1]);

        attackCell = ""+(++symbolCell)+(--numberCell);
        attackFigure = board.get(attackCell);

        if ((nameCell[0] != 'h') && attackFigure != null){
            writeStrokeInList(listStrokes, attackCell);
        }

    }



}