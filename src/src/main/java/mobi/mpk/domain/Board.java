package mobi.mpk.domain;

import mobi.mpk.domain.figure.Figure;

import java.util.*;

public class Board {

    private Cell[][] cells;
    private List<Figure> whiteFigure;
    private List<Figure> blackFigure;

    public Board(){

        cells = new Cell[8][8];

        for(int x = 0; x < 8; x++){

            for (int y = 0; y < 8; y++){
                cells[x][y] = new Cell(x,y);
            }

        }

    }

    public Cell[][] getMassiveCell(){ return cells; }


}
