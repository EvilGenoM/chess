package mobi.mpk.chess.domain.rules;

import mobi.mpk.chess.domain.*;
import mobi.mpk.chess.domain.factory.figure.*;
import mobi.mpk.chess.domain.figure.Figure;
import mobi.mpk.chess.domain.rules.strokerules.figures.*;

import java.util.LinkedList;
import java.util.List;

public class ClassicRules implements Rules{

    private ClassicStrokeRulesFigure rulesFigure;


    @Override
    public List<Cell> moveKing(Stroke stroke) {

        Cell from = stroke.getFrom();
        Cell to = stroke.getTo();

        rulesFigure = new ClassicStrokeRulesKing();

        return rulesFigure.move(from, to);

    }

    @Override
    public List<Cell> moveQueen(Stroke stroke) {

        Cell from = stroke.getFrom();
        Cell to = stroke.getTo();

        rulesFigure = new ClassicStrokeRulesQueen();

        return rulesFigure.move(from, to);
    }

    @Override
    public List<Cell> moveBishop(Stroke stroke) {

        Cell from = stroke.getFrom();
        Cell to = stroke.getTo();

        rulesFigure = new ClassicStrokeRulesBishop();

        return rulesFigure.move(from, to);
    }

    @Override
    public List<Cell> movekNight(Stroke stroke) {

        Cell from = stroke.getFrom();
        Cell to = stroke.getTo();

        rulesFigure = new ClassicStrokeRuleskNight();

        return rulesFigure.move(from, to);
    }

    @Override
    public List<Cell> moveRook(Stroke stroke) {

        Cell from = stroke.getFrom();
        Cell to = stroke.getTo();

        rulesFigure = new ClassicStrokeRulesRook();

        return rulesFigure.move(from, to);
    }

    @Override
    public List<Cell> movePawn(Stroke stroke) {

        Cell from = stroke.getFrom();
        Cell to = stroke.getTo();

        rulesFigure = new ClassicStrokeRulesPawn();

        return rulesFigure.move(from, to);
    }

    @Override
    public boolean canPutFigure(Cell from, Cell to) {

        if(to.getFigure() == null){
            return true;
        } else if(to.getFigure().getColor() != from.getFigure().getColor()){
            return true;
        } else {
            return false;
        }

    }

    @Override
    public Player wonPlayer() {
        return null;
    }

    @Override
    public List<Figure> orderFigure(Color color) {

        List<FactoryFigure> creators = new LinkedList<FactoryFigure>();
        List<Figure> orderFigures = new LinkedList<Figure>();

        creators.add(new FactoryRook());
        creators.add(new FactoryKnight());
        creators.add(new FactoryBishop());
        creators.add(new FactoryQueen());
        creators.add(new FactoryKing());
        creators.add(new FactoryBishop());
        creators.add(new FactoryKnight());
        creators.add(new FactoryRook());

        for(int i = 0; i < 8; i++){

            creators.add(new FactoryPawn());

        }


        for(FactoryFigure creator: creators){
            orderFigures.add(creator.factoryMethod(color));
        }


        return orderFigures;

    }


}
