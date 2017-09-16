package mobi.mpk.domain;

public class ResultStroke {

    private String text;
    private boolean isSuccess;
    private boolean isEndGame;

    public boolean isEndGame() {
        return isEndGame;
    }

    public void setEndGame(boolean endGame) {
        isEndGame = endGame;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public boolean isSuccess() {
        return isSuccess;
    }


}
