package domain;

public class ResultStroke {

    private String text;
    private boolean isSuccess;

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
