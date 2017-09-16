package mobi.mpk.cli;

import java.io.Serializable;
import java.util.Date;

public class Reply implements Serializable {

    private String name;
    private String log;
    private String text;
    private Date date;
    private boolean isClose = false;
    private String Stroke;
    private boolean successStroke;

    public boolean isSuccessStroke() {
        return successStroke;
    }

    public void setSuccessStroke(boolean successStroke) {
        this.successStroke = successStroke;
    }

    public void setStroke(String stroke) {
        Stroke = stroke;
    }

    public String getStroke() {
        return Stroke;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log += log;
    }

    public Date getDate() {
        return date;
    }

    public void setDate() {
        this.date = new Date();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isClose() {
        return isClose;
    }

    public void setClose(boolean close) {
        isClose = close;
    }

    public boolean equals(Reply reply){
        if(this.text.equals(reply.text)){
            return true;
        } else {
            return false;
        }
    }

}
