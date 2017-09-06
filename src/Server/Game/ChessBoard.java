package Server.Game;

import java.util.*;

public class ChessBoard {

    public Map<String, Figure> board = new LinkedHashMap<String, Figure>();

    public ChessBoard(){

        // Ряд 8
        board.put("a8", new Rook(board));
        board.put("b8", new kNight(board));
        board.put("c8", new Bishop(board));
        board.put("d8", new Queen(board));
        board.put("e8", new King(board));
        board.put("f8", new Bishop(board));
        board.put("g8", new kNight(board));
        board.put("h8", new Rook(board));
        // Ряд 7
        board.put("a7", new Pawn(board, "a7"));
        board.put("b7", new Pawn(board, "b7"));
        board.put("c7", new Pawn(board, "c7"));
        board.put("d7", new Pawn(board, "d7"));
        board.put("e7", new Pawn(board, "e7"));
        board.put("f7", new Pawn(board, "f7"));
        board.put("g7", new Pawn(board, "g7"));
        board.put("h7", new Pawn(board, "h7"));
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
        board.put("a2", new Pawn(board, "a2"));
        board.put("b2", new Pawn(board, "b2"));
        board.put("c2", new Pawn(board, "c2"));
        board.put("d2", new Pawn(board, "d2"));
        board.put("e2", new Pawn(board, "e2"));
        board.put("f2", new Pawn(board, "f2"));
        board.put("g2", new Pawn(board, "g2"));
        board.put("h2", new Pawn(board, "h2"));
        // Ряд 1
        board.put("a1", new Rook(board));
        board.put("b1", new kNight(board));
        board.put("c1", new Bishop(board));
        board.put("d1", new Queen(board));
        board.put("e1", new King(board));
        board.put("f1", new Bishop(board));
        board.put("g1", new kNight(board));
        board.put("h1", new Rook(board));

        /*
        Pawn pawn = new Pawn(board, "a1");

        board.put("a1", pawn);
        board.put("a2", null);
        board.put("a3", null);
        board.put("a4", null);
        */
    }

    public boolean strokeFigure(String stroke){

        boolean result = false;

        String str[] = stroke.split(" ");
        Figure figure = board.get(str[0]);
        if(figure == null){
            return false;
        }

        result = figure.move(str[1]);

        return result;
    }

}
