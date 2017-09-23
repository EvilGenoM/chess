package mobi.mpk.chess.domain;


public class Board {

    private Cell[][] cells;

    public Board(){

        cells = new Cell[8][8];

        for(int x = 0; x < 8; x++){

            for (int y = 0; y < 8; y++){
                cells[x][y] = new Cell(x,y);
            }

        }

    }

    public Cell[][] getMassiveCell(){ return cells; }

    public Cell getCell(Cell cell){

        int x = cell.getIntX()-1;
        int y = cell.getY()-1;

        return this.cells[x][y];
    }


}
