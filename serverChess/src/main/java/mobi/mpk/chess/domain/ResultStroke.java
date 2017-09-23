package mobi.mpk.chess.domain;

public class ResultStroke {

    private String text;
    private boolean isSuccess;

    public ResultStroke(String text, boolean isSuccess) {

        this.text = text;
        this.isSuccess = isSuccess;

    }

    public ResultStroke() {

        this.isSuccess = false;

    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }


}
