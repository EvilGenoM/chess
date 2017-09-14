package mobi.mpk.domain.rules;

import mobi.mpk.domain.Board;
import mobi.mpk.domain.Cell;
import mobi.mpk.domain.Color;
import mobi.mpk.domain.Player;
import mobi.mpk.domain.fabricfigure.*;
import mobi.mpk.domain.figure.*;

import java.util.*;

public class ClassicChessRules implements Rules {


    private Figure figure;
    private RulesStrokes rs;


    @Override
    public boolean move(Cell from, Cell to, Board board) {

        RulesStrokes rs = new ClassicRulesStrokes();
        return rs.strokeFigure(from, to, board);

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
    public Player[] identifyWhitePlayer(Player player1, Player player2){
        Player[] players = new Player[2];

        if(new Random().nextInt(1) == 1){
            players[0] = player1;
            players[1] = player2;
        } else {
            players[0] = player2;
            players[1] = player1;
        }

        return players;
    }


}
