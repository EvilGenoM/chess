package mobi.mpk.domain.game;

import mobi.mpk.domain.*;
import mobi.mpk.domain.rules.ClassicChessRules;
import mobi.mpk.domain.figure.*;
import mobi.mpk.net.User;

import java.util.List;

public class ClassicChessGame extends Game{

    private Color nowStroke = Color.white;


    public ClassicChessGame(Player player1, Player player2){

        super(player1, player2, new ClassicChessRules());

        initBoard();

    }

    protected void initBoard(){

        Cell[][] cells = getBoard().getMassiveCell();

        List<Figure> orderFigures = getRools().orderFiguresOnBorad(Color.white);

        putFiguresOnCell(cells, orderFigures, 0, 0);

        orderFigures = getRools().orderFiguresOnBorad(Color.black);

        putFiguresOnCell(cells, orderFigures, 0, 6);


    }

    @Override
    public String handleStroke(Stroke stroke, User user){

        if(nowStroke == Color.white){

            if(getPlayerWhite().getUser().equals(user)){
                String answer = getPlayerWhite().move(stroke, getBoard(), getRools());
                newStroke();
                return answer;
            } else {
                return "Не ваш ход!";
            }

        } else {

            if(getPlayerBlack().getUser().equals(user)){
                String answer = getPlayerBlack().move(stroke, getBoard(), getRools());
                newStroke();
                return answer;
            } else {
                return "Не ваш ход!";
            }

        }


    }

    private void newStroke(){
        if(nowStroke == Color.white){
            nowStroke = Color.black;
        } else {
            nowStroke = Color.white;
        }
    }

    private void putFiguresOnCell(Cell[][] cells, List<Figure> orderFigures,
                                  int startX, int startY){
        int x = startX;
        int y = startY;

        for(Figure figure : orderFigures){
            cells[x][y].setFigure(figure);
            x++;
            if(x == 8){
                x = 0;
                y++;
            }
        }

    }



}
