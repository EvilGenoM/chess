package mobi.mpk.chess.domain;

public class Board {

    private final int BOARD_WIDTH = 8;
    private final int BOARD_HEIGHT = 8;

    private Cell[][] board;
    private int boardWidth, boardHeight;

    public Board(){

        boardWidth = BOARD_WIDTH;
        boardHeight = BOARD_HEIGHT;
        board = new Cell[boardWidth][boardHeight];

    }

}
