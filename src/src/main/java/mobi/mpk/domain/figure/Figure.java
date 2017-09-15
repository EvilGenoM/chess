package mobi.mpk.domain.figure;

import mobi.mpk.domain.Color;

public abstract class Figure {

    private Color color;

    public Figure(Color color){
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

}
