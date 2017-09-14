package mobi.mpk.domain.rools;

import mobi.mpk.domain.Color;
import mobi.mpk.domain.figure.*;

import java.util.List;

public interface Rools {


    public void move();

    public List<Figure> orderFiguresOnBorad(Color color);

    void addColorPlayer();

}
