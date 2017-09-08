package Server.Game;

import java.util.ArrayList;
import java.util.Map;

public class Stroke {

    Map<String, Figure> board;

    public Stroke(Map<String, Figure> board){
        this.board = board;
    }


    public void createListStrokes(ArrayList<String> listStrokes,
                                  char[] nameCell,
                                  Figure figure){
        switch (figure.getClass().getSimpleName()){
            case "King":
                strokesKing(listStrokes, nameCell, figure);
                break;
            case "Queen":
                strokesQueen(listStrokes, nameCell, figure);
                break;
            case "Bishop":
                strokesBishop(listStrokes, nameCell, figure);
                break;
            case "kNight":
                strokesKNight(listStrokes, nameCell, figure);
                break;
            case "Rook":
                strokesRook(listStrokes, nameCell, figure);
                break;
            case "Pawn":
                strokesPawn(listStrokes, nameCell, figure);
                break;
            default:
                break;

        }

    }


    public boolean moveFigure(ArrayList<String > allStrokesFigure,
                              String yourStroke,
                              String locationFigure,
                              Figure figure){

        for(String str : allStrokesFigure){
            if(str.equals(yourStroke)){
                for(Map.Entry entry : board.entrySet()){
                    String key = (String) entry.getKey();
                    if(key.equals(yourStroke)){
                        entry.setValue(figure);
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

    private void writeStrokeInList(ArrayList<String> strokeFigure, String coordCell, Figure figure){

        if(board.get(coordCell) == null){
            strokeFigure.add(coordCell);
        } else {
            if (board.get(coordCell).getWhite() != figure.getWhite()) {
                strokeFigure.add(coordCell);
            }
        }

    }


    private void strokesKing(ArrayList<String> listStrokes, char[] nameCell, Figure figure){

        int numberCell = Character.getNumericValue(nameCell[1]);
        char symbolCell = nameCell[0];

        if(nameCell[1] != '1'){
            writeStrokeInList(listStrokes, ""+nameCell[0]+(numberCell-1), figure);
            symbolCell = nameCell[0];
            if(nameCell[0] != 'a'){
                writeStrokeInList(listStrokes, ""+(--symbolCell) + (numberCell-1), figure);
            }
            symbolCell = nameCell[0];
            if(nameCell[0] != 'h'){
                writeStrokeInList(listStrokes, ""+(++symbolCell) + (numberCell-1), figure);
            }
        }

        if(nameCell[1] != '8'){
            writeStrokeInList(listStrokes, ""+nameCell[0] + (numberCell+1), figure);
            symbolCell = nameCell[0];
            if(nameCell[0] != 'a'){
                writeStrokeInList(listStrokes, ""+(--symbolCell) + (numberCell+1), figure);
            }
            symbolCell = nameCell[0];
            if(nameCell[0] != 'h'){
                writeStrokeInList(listStrokes, ""+(++symbolCell) + (numberCell+1), figure);
            }
        }

        if(nameCell[0] != 'a'){
            symbolCell = nameCell[0];
            writeStrokeInList(listStrokes, ""+(--symbolCell) + (numberCell), figure);
        }

        if(nameCell[0] != 'h'){
            symbolCell = nameCell[0];
            writeStrokeInList(listStrokes, ""+(++symbolCell) + (numberCell), figure);
        }

    }

    private void strokesQueen(ArrayList<String> listStrokes, char[] nameCell, Figure figure){

        strokesBishop(listStrokes, nameCell, figure);
        strokesRook(listStrokes, nameCell, figure);

    }

    private void strokesBishop(ArrayList<String> listStrokes, char[] nameCell, Figure figure){

        int numberCell = Character.getNumericValue(nameCell[1]);
        char symbolCell = nameCell[0];

        while(numberCell != 8 && symbolCell != 'h'){
            ++symbolCell;
            ++numberCell;
            writeStrokeInList(listStrokes, ""+(symbolCell)+(numberCell), figure);
            if(board.get(""+(symbolCell)+(numberCell)) != null){
                break;
            }
        }

        numberCell = Character.getNumericValue(nameCell[1]);
        symbolCell = nameCell[0];

        while(numberCell != 8 && symbolCell != 'a'){
            --symbolCell;
            ++numberCell;
            writeStrokeInList(listStrokes, ""+(symbolCell)+(numberCell), figure);
            if(board.get(""+(symbolCell)+(numberCell)) != null){
                break;
            }
        }

        numberCell = Character.getNumericValue(nameCell[1]);
        symbolCell = nameCell[0];

        while(numberCell != 1 && symbolCell != 'h'){
            ++symbolCell;
            --numberCell;
            writeStrokeInList(listStrokes, ""+(symbolCell)+(numberCell), figure);
            if(board.get(""+(symbolCell)+(numberCell)) != null){
                break;
            }
        }

        numberCell = Character.getNumericValue(nameCell[1]);
        symbolCell = nameCell[0];

        while(numberCell != 1 && symbolCell != 'a'){
            --symbolCell;
            --numberCell;
            writeStrokeInList(listStrokes, ""+(symbolCell)+(numberCell), figure);
            if(board.get(""+(symbolCell)+(numberCell)) != null){
                break;
            }
        }

    }

    private void strokesKNight(ArrayList<String> listStrokes, char[] nameCell, Figure figure){

        int numberCell = Character.getNumericValue(nameCell[1]);
        char symbolCell = nameCell[0];

        if(numberCell <= 6){
            symbolCell = nameCell[0];
            if(nameCell[0] != 'a') {
                writeStrokeInList(listStrokes, "" + (--symbolCell) + (numberCell + 2), figure);
            }
            symbolCell = nameCell[0];
            if(nameCell[0] != 'h') {
                writeStrokeInList(listStrokes, "" + (++symbolCell) + (numberCell + 2), figure);
            }
        }

        if(numberCell >= 3){
            symbolCell = nameCell[0];
            if(nameCell[0] != 'a') {
                writeStrokeInList(listStrokes, "" + (--symbolCell) + (numberCell - 2), figure);
            }
            symbolCell = nameCell[0];
            if(nameCell[0] != 'h') {
                writeStrokeInList(listStrokes, "" + (++symbolCell) + (numberCell - 2), figure);
            }
        }

        if(nameCell[0] >= 'c'){
            symbolCell = nameCell[0];
            if(numberCell != 1) {
                --symbolCell;
                --symbolCell;
                writeStrokeInList(listStrokes, "" + (symbolCell) + (--numberCell), figure);
            }
            symbolCell = nameCell[0];
            if(numberCell != 8) {
                --symbolCell;
                --symbolCell;
                writeStrokeInList(listStrokes, "" + (symbolCell) + (++numberCell), figure);
            }
        }

        if(nameCell[0] <= 'f'){
            symbolCell = nameCell[0];
            if(numberCell != 1) {
                ++symbolCell;
                ++symbolCell;
                writeStrokeInList(listStrokes, "" + (symbolCell) + (--numberCell), figure);
            }
            symbolCell = nameCell[0];
            if(numberCell != 8) {
                ++symbolCell;
                ++symbolCell;
                writeStrokeInList(listStrokes, "" + (symbolCell) + (++numberCell), figure);
            }
        }
    }

    private void strokesRook(ArrayList<String> listStrokes, char[] nameCell, Figure figure){

        int numberCell = Character.getNumericValue(nameCell[1]);
        char symbolCell = nameCell[0];

        while(symbolCell != 'a'){
            --symbolCell;
            writeStrokeInList(listStrokes, ""+symbolCell+numberCell, figure);
            if(board.get(""+symbolCell+numberCell) != null){
                break;
            }
        }

        while(numberCell != 1){
            --numberCell;
            writeStrokeInList(listStrokes, ""+nameCell[0]+numberCell, figure);
            if(board.get(""+nameCell[0]+numberCell) != null){
                break;
            }
        }

        numberCell = Character.getNumericValue(nameCell[1]);
        symbolCell = nameCell[0];

        while(symbolCell != 'h'){
            ++symbolCell;
            writeStrokeInList(listStrokes, ""+symbolCell+numberCell, figure);
            if(board.get(""+symbolCell+numberCell) != null){
                break;
            }
        }

        while(numberCell != 8){
            ++numberCell;
            writeStrokeInList(listStrokes, ""+nameCell[0]+numberCell, figure);
            if(board.get(""+nameCell[0]+numberCell) != null){
                break;
            }
        }

    }

    private void strokesPawn(ArrayList<String> listStrokes, char[] nameCell, Figure figure){

        if(figure.getWhite()){
            strokesWhitePawn(listStrokes, nameCell, figure);
            attackWhitePawn(listStrokes, nameCell, figure);
        } else {
            strokesBlackPawn(listStrokes, nameCell, figure);
            attackBlackPawn(listStrokes, nameCell, figure);
        }

    }

    private void strokesWhitePawn(ArrayList<String> listStrokes, char[] nameCell, Figure figure){

        int numberCell = Character.getNumericValue(nameCell[1]);

        if (nameCell[1] != '8') {
            ++numberCell;
            Figure cell = board.get("" + nameCell[0] + numberCell);
            if (cell == null) {
                listStrokes.add("" + nameCell[0] + numberCell);
            }
            if(figure.getOneStroke() && cell == null){
                ++numberCell;
                cell = board.get("" + nameCell[0] + numberCell);
                if (cell == null) {
                    listStrokes.add("" + nameCell[0] + numberCell);
                }
            }
        }

    }

    private void strokesBlackPawn(ArrayList<String> listStrokes, char[] nameCell, Figure figure){

        int numberCell = Character.getNumericValue(nameCell[1]);

        if (nameCell[1] != '1') {
            --numberCell;
            Figure cell = board.get("" + nameCell[0] + numberCell);
            if (cell == null) {
                listStrokes.add("" + nameCell[0] + numberCell);
            }
            if(figure.getOneStroke() && cell == null){
                --numberCell;
                cell = board.get("" + nameCell[0] + numberCell);
                if (cell == null) {
                    listStrokes.add("" + nameCell[0] + numberCell);
                }
            }
        }

    }

    private void attackWhitePawn(ArrayList<String> listStrokes, char[] nameCell, Figure figure){

        char symbolCell = nameCell[0];
        int numberCell = Character.getNumericValue(nameCell[1]);

        String attackCell = ""+(--symbolCell)+(++numberCell);
        Figure attackFigure = board.get(attackCell);

        if ((nameCell[0] != 'a') && attackFigure != null){
            writeStrokeInList(listStrokes, attackCell, figure);
        }

        attackCell = ""+(++symbolCell)+(++numberCell);
        attackFigure = board.get(attackCell);

        if ((nameCell[0] != 'h') && attackFigure != null){
            writeStrokeInList(listStrokes, attackCell, figure);
        }

    }

    private void attackBlackPawn(ArrayList<String> listStrokes, char[] nameCell, Figure figure){

        char symbolCell = nameCell[0];
        int numberCell = Character.getNumericValue(nameCell[1]);
        String attackCell = ""+(--symbolCell)+(--numberCell);
        Figure attackFigure = board.get(attackCell);

        if ((nameCell[0] != 'a') && attackFigure != null){
            writeStrokeInList(listStrokes, attackCell, figure);
        }

        symbolCell = nameCell[0];
        numberCell = Character.getNumericValue(nameCell[1]);

        attackCell = ""+(++symbolCell)+(--numberCell);
        attackFigure = board.get(attackCell);

        if ((nameCell[0] != 'h') && attackFigure != null){
            writeStrokeInList(listStrokes, attackCell, figure);
        }

    }




}
