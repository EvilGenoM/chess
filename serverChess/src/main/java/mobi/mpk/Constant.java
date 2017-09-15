package mobi.mpk;

import mobi.mpk.domain.ResultStroke;

public class Constant {

    public final static String REPLY_HELP = "join Name - отправить приглашение в игру" +
                                            "\nplayers - вывести список игроков" +
                                            "\nclose - выйти из приложения";
    public final static String LOG_COMMAND = "Выполнена команда: ";

    public final static String ERROR_COMMAND = "Неизвестная команда...";

    //------------------------------------

    //Константы описывающие соединение игроков

    public final static String ERROR_CONNECT_PLAYER = "Игрок не найден...";

    public final static String CONNECT_WAIT = "Ожидайте ответа...";

    public final static String ERROR_CONNECT = "Соединение разорвано";

    public final static String GAME_BEGIN = "Игра началась";


    //----------------------------------------

    //Команды LOBBY

    public final static String COMMAND_JOIN = "join";

    public final static String COMMAND_HELP = "help";

    public final static String COMMAND_PLAYERS = "players";

    public final static String COMMAND_CLOSE = "close";

    //------------------------------------------

    //Константы игры

    public final static String GAME_ERROR_NOTYOUSTROKE = "Не ваш ход";

    public final static String GAME_YOUWHITE = "Ваши белые фигуры\nВаш ход:";

    public final static String GAME_YOUBLACK = "Ваши черные фигуры";

    //Константы правил хождения фигур

    public final static String ERROR_MOVE = "Ошибка хода";

    public final static String ERROR_COLOR_FIGURE = "На клетке находится не ваша фигура";

    public final static String ERROR_CELL = "Фигура не может пойти в эту клетку";

    public final static String ERROR_WAY_FIGURE = "На пути фигуры есть препятствия";

    public final static String ERROR_CELL_FIGURE = "В указанной клетке уже находится ваша фигура";

    public final static String ERROR_CELL_YOUFIGURE = "В указанной клетке нет вашей фигуры";

    public final static String SUCCESS_ATTACK = "Вы забрали вражескую фигуру";

    public final static String SUCCESS_STROKE = "Успешный ход";




}
