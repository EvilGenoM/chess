package mobi.mpk.domain.game;

import mobi.mpk.domain.*;
import mobi.mpk.domain.rules.ClassicChessRules;
import mobi.mpk.domain.figure.*;
import mobi.mpk.net.User;

import java.util.List;

import static mobi.mpk.Constant.GAME_ERROR_NOTYOUSTROKE;

public class ClassicChessGame extends Game{

    private Color nowStroke = Color.white;


    public ClassicChessGame(Player player1, Player player2){

        super(player1, player2, new ClassicChessRules());

        initBoard();

    }

    protected void initBoard(){

        Cell[][] cells = getBoard().getMassiveCell();

        List<Figure> orderFigures = getRules().orderFiguresOnBorad(Color.white);

        putWFiguresOnCell(cells, orderFigures, 0, 0);

        orderFigures = getRules().orderFiguresOnBorad(Color.black);

        putBFiguresOnCell(cells, orderFigures, 0, 7);


    }

    @Override
    public ResultStroke handleStroke(Stroke stroke, User user){

        if(nowStroke == Color.white){

            if(getPlayerWhite().getUser().equals(user)){
                ResultStroke answer = getPlayerWhite().move(stroke, getBoard(), getRules(), Color.white);

                if(answer.isSuccess()) {
                    nextStroke();
                }

                return answer;
            } else {
                ResultStroke resultStroke = new ResultStroke();
                resultStroke.setText(GAME_ERROR_NOTYOUSTROKE);
                return resultStroke;
            }

        } else {

            if(getPlayerBlack().getUser().equals(user)){
                ResultStroke answer = getPlayerBlack().move(stroke, getBoard(), getRules(), Color.black);

                if(answer.isSuccess()) {
                    nextStroke();
                }

                return answer;
            } else {
                ResultStroke resultStroke = new ResultStroke();
                resultStroke.setText(GAME_ERROR_NOTYOUSTROKE);
                return resultStroke;
            }

        }


    }

    @Override
    public Color getColorPlayer(Player player){

        if(player.equals(getPlayerWhite())){
            return Color.white;
        } else {
            return Color.black;
        }

    }


    private void nextStroke(){
        if(nowStroke == Color.white){
            nowStroke = Color.black;
        } else {
            nowStroke = Color.white;
        }
    }

    private void putWFiguresOnCell(Cell[][] cells, List<Figure> orderFigures,
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

    private void putBFiguresOnCell(Cell[][] cells, List<Figure> orderFigures,
                                   int startX, int startY){
        int x = startX;
        int y = startY;

        for(Figure figure : orderFigures){
            cells[x][y].setFigure(figure);
            x++;
            if(x == 8){
                x = 0;
                y--;
            }
        }

    }



}
