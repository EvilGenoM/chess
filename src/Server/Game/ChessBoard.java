package Server.Game;

import java.util.*;

public class ChessBoard {

    Map<String, Figure> board = new HashMap<String, Figure>();

    public ChessBoard(){
        // Ряд 1
        board.put("a1", new Rook(board));
        board.put("b1", new kNight(board));
        board.put("c1", new Bishop(board));
        board.put("d1", new Queen(board));
        board.put("e1", new King(board));
        board.put("f1", new Bishop(board));
        board.put("g1", new kNight(board));
        board.put("h1", new Rook(board));
        // Ряд 2
        board.put("a2", new Pawn(board));
        board.put("b2", new Pawn(board));
        board.put("c2", new Pawn(board));
        board.put("d2", new Pawn(board));
        board.put("e2", new Pawn(board));
        board.put("f2", new Pawn(board));
        board.put("g2", new Pawn(board));
        board.put("h2", new Pawn(board));
        // Ряд 3
        board.put("a3", null);
        board.put("b3", null);
        board.put("c3", null);
        board.put("d3", null);
        board.put("e3", null);
        board.put("f3", null);
        board.put("g3", null);
        board.put("h3", null);
        // Ряд 4
        board.put("a4", null);
        board.put("b4", null);
        board.put("c4", null);
        board.put("d4", null);
        board.put("e4", null);
        board.put("f4", null);
        board.put("g4", null);
        board.put("h4", null);
        // Ряд 5
        board.put("a5", null);
        board.put("b5", null);
        board.put("c5", null);
        board.put("d5", null);
        board.put("e5", null);
        board.put("f5", null);
        board.put("g5", null);
        board.put("h5", null);
        // Ряд 6
        board.put("a6", null);
        board.put("b6", null);
        board.put("c6", null);
        board.put("d6", null);
        board.put("e6", null);
        board.put("f6", null);
        board.put("g6", null);
        board.put("h6", null);
        // Ряд 7
        board.put("a7", new Pawn(board));
        board.put("b7", new Pawn(board));
        board.put("c7", new Pawn(board));
        board.put("d7", new Pawn(board));
        board.put("e7", new Pawn(board));
        board.put("f7", new Pawn(board));
        board.put("g7", new Pawn(board));
        board.put("h7", new Pawn(board));
        // Ряд 8
        board.put("a8", new Rook(board));
        board.put("b8", new kNight(board));
        board.put("c8", new Bishop(board));
        board.put("d8", new Queen(board));
        board.put("e8", new King(board));
        board.put("f8", new Bishop(board));
        board.put("g8", new kNight(board));
        board.put("h8", new Rook(board));
    }

}
