package mobi.mpk.domain.rules;

import mobi.mpk.domain.*;
import mobi.mpk.domain.fabricfigure.*;
import mobi.mpk.domain.figure.*;

import java.util.*;

import static mobi.mpk.Constant.ERROR_COLOR_FIGURE;

public class ClassicChessRules implements Rules {


    private Figure figure;
    private RulesStrokes rs;


    @Override
    public ResultStroke move(Cell from, Cell to, Board board, Color color) {

        if(from.getFigure() != null && from.getFigure().getColor() != color){
            ResultStroke resultStroke = new ResultStroke();
            resultStroke.setText(ERROR_COLOR_FIGURE);
            return resultStroke;
        }

        RulesStrokes rs = new ClassicRulesStrokes();
        ResultStroke resultStroke = rs.strokeFigure(from, to, board);
        deadKing(board, resultStroke);
        return resultStroke;

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

        Random random = new Random();

        if(random.nextInt(1) == 1){
            players[0] = player1;
            players[1] = player2;
        } else {
            players[0] = player2;
            players[1] = player1;
        }

        return players;

    }

    private void deadKing(Board board, ResultStroke resultStroke){


        Cell[][] cells = board.getMassiveCell();
        int kingSum = 0;

        for(int x=0; x<8; x++){
            for(int y = 0; y<8; y++){

                if(cells[x][y].getFigure() != null && cells[x][y].getFigure().getClass().getName().equals("King")){
                    kingSum += 1;
                }

            }
        }

        if(kingSum == 1){
            resultStroke.setEndGame(true);
        }


    }


}
