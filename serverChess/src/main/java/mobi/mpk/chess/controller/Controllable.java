package mobi.mpk.chess.controller;

import mobi.mpk.chess.message.Message;

public interface Controllable {

    Message handleMessage(Message message);

}
