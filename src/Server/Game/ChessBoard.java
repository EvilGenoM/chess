package Server.Game;

import java.util.*;

import static Server.Game.Figure.ANSI_GREEN;
import static Server.Game.Figure.ANSI_RED;
import static Server.Game.Figure.ANSI_RESET;

public class ChessBoard {

    public Map<String, Figure> board = new LinkedHashMap<String, Figure>();

    public ChessBoard(){

        // Ряд 8
        board.put("a8", new Rook(board, "a8", false));
        board.put("b8", new kNight(board, "b8", false));
        board.put("c8", new Bishop(board, "c8", false));
        board.put("d8", new Queen(board,"d8", false));
        board.put("e8", new King(board, "e8", false));
        board.put("f8", new Bishop(board, "f8", false));
        board.put("g8", new kNight(board, "b8", false));
        board.put("h8", new Rook(board, "h8", false));
        // Ряд 7
        board.put("a7", new Pawn(board, "a7", false));
        board.put("b7", new Pawn(board, "b7", false));
        board.put("c7", new Pawn(board, "c7", false));
        board.put("d7", new Pawn(board, "d7", false));
        board.put("e7", new Pawn(board, "e7", false));
        board.put("f7", new Pawn(board, "f7", false));
        board.put("g7", new Pawn(board, "g7", false));
        board.put("h7", new Pawn(board, "h7", false));
        // Ряд 6
        board.put("a6", null);
        board.put("b6", null);
        board.put("c6", null);
        board.put("d6", null);
        board.put("e6", null);
        board.put("f6", null);
        board.put("g6", null);
        board.put("h6", null);
        // Ряд 5
        board.put("a5", null);
        board.put("b5", null);
        board.put("c5", null);
        board.put("d5", null);
        board.put("e5", null);
        board.put("f5", null);
        board.put("g5", null);
        board.put("h5", null);
        // Ряд 4
        board.put("a4", null);
        board.put("b4", null);
        board.put("c4", null);
        board.put("d4", null);
        board.put("e4", null);
        board.put("f4", null);
        board.put("g4", null);
        board.put("h4", null);
        // Ряд 3
        board.put("a3", null);
        board.put("b3", null);
        board.put("c3", null);
        board.put("d3", null);
        board.put("e3", null);
        board.put("f3", null);
        board.put("g3", null);
        board.put("h3", null);
        // Ряд 2
        board.put("a2", new Pawn(board, "a2", true));
        board.put("b2", new Pawn(board, "b2", true));
        board.put("c2", new Pawn(board, "c2", true));
        board.put("d2", new Pawn(board, "d2", true));
        board.put("e2", new Pawn(board, "e2", true));
        board.put("f2", new Pawn(board, "f2", true));
        board.put("g2", new Pawn(board, "g2", true));
        board.put("h2", new Pawn(board, "h2", true));
        // Ряд 1
        board.put("a1", new Rook(board, "a1", true));
        board.put("b1", new kNight(board, "b1", true));
        board.put("c1", new Bishop(board, "c1", true));
        board.put("d1", new Queen(board, "d1", true));
        board.put("e1", new King(board, "e1", true));
        board.put("f1", new Bishop(board, "f1", true));
        board.put("g1", new kNight(board, "g1", true));
        board.put("h1", new Rook(board, "h1", true));


    }

    public boolean strokeFigure(String stroke, boolean white){


        String str[] = stroke.split(" ");
        Figure figure = board.get(str[0]);
        if(figure == null || white != figure.getWhite()){
            return false;
        }


        return figure.move(str[1]);
    }

    public String gameEnd(){
        boolean white = false;
        boolean black = false;
        for(Map.Entry entry : board.entrySet()){
            Figure figure = (Figure) entry.getValue();
            if(figure != null && figure.name.equals(ANSI_GREEN+"K"+ANSI_RESET)){
                white = true;
            }
            if(figure != null && figure.name.equals(ANSI_RED+"K"+ANSI_RESET)){
                black = true;
            }
        }
        if(white && black){
            return "";
        } else {
            if(white){
                return "Победили белые фигуры";
            } else {
                return "Победили черные фигуры";
            }
        }
    }

}
