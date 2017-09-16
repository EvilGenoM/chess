package mobi.mpk.domain;

import mobi.mpk.domain.figure.*;

public class Cell {

    private char x;
    private int y;
    private Figure figure = null;


    public Cell(char x, int y){
        this.x = x;
        this.y = y;
        this.figure = null;
    }

    public Cell(char x, int y, Figure figure){
        this.x = x;
        this.y = y;
        this.figure = figure;
    }

    public Cell(int x, int y){

        this.x = 'a';
        for(int i = 0; i < x; i++){
            ++this.x;
        }

        this.y = y+1;
        this.figure = null;
    }

    public void setFigure(Figure figure){
        this.figure = figure;
    }

    public Figure getFigure(){ return this.figure; }

    public char getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private void findColor(){

    }


    public boolean equals(Cell cell){

        if(this != null && cell != null && this.x == cell.getX() && this.y == cell.getY()){
            return true;
        } else {
            return false;
        }

    }


}
