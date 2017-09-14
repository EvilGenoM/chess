package mobi.mpk.domain.rools;

import mobi.mpk.domain.Color;
import mobi.mpk.domain.fabricfigure.*;
import mobi.mpk.domain.figure.*;

import java.util.*;

public class ClassicChessRools implements Rools {


    private Figure figure;


    @Override
    public void move() {

    }

    @Override
    public List<Figure> orderFiguresOnBorad(Color color) {

        List<Creator> creators = new ArrayList<Creator>();
        List<Figure> orderFigures = new ArrayList<Figure>();

        creators.add(new CreatorRook());
        creators.add(new CreatorKnight());
        creators.add(new CreatorBishop());
        creators.add(new CreatorQueen());
        creators.add(new CreatorKing());
        creators.add(new CreatorBishop());
        creators.add(new CreatorKnight());
        creators.add(new CreatorRook());

        for(int i = 0; i < 8; i++){

            creators.add(new CreatorPawn());

        }


        for(Creator creator: creators){
            orderFigures.add(creator.factoryMethod(color));
        }


        return orderFigures;
    }

    @Override
    public void addColorPlayer(){

    }


}
