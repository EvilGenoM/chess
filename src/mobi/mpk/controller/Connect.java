package mobi.mpk.controller;

public interface Connect {

    Controller getPlayer1Controller();

    Controller getPlayer2Controller();

    Reply execute(Request request, Controller control);

}
