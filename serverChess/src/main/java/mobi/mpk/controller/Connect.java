package mobi.mpk.controller;

import mobi.mpk.cli.Reply;
import mobi.mpk.cli.Request;

public interface Connect {

    Controller getPlayer1Controller();

    Controller getPlayer2Controller();

    Reply execute(Request request, Controller control);

}
