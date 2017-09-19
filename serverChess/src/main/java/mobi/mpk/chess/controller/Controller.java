package mobi.mpk.chess.controller;

import mobi.mpk.chess.Message;

public interface Controller {

    Message handleMessage(Message message);

}
