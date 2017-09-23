package mobi.mpk.chess.domain;

import java.util.Date;

public class Stroke {


    private Cell from;
    private Cell to;

    private Date time;

    public Stroke(Cell from, Cell to){

        this.from = from;
        this.to = to;

    }


    public Stroke(String stroke){

        String[] coordCell;

        coordCell = stroke.split(" ");

        if(coordCell[0] != null && coordCell[1] != null){
            this.from = createCell(coordCell[0]);
            this.to = createCell(coordCell[1]);
        }

        this.time = new Date();

    }

    public Cell getFrom() {
        return from;
    }

    public Cell getTo() {
        return to;
    }

    private Cell createCell(String coordCell){

        char[] letter = {'a', 'b', 'c','d','e','f','g','h'};


        char xCoordCell = coordCell.charAt(0);
        int yCoordCell = Character.getNumericValue(coordCell.charAt(1));



        return new Cell(xCoordCell, yCoordCell);

    }


}
