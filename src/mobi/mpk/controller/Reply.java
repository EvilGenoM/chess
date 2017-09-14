package mobi.mpk.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Reply implements Serializable {

    private String name;
    private String log;
    private String text;
    private Date date;
    private boolean isClose = false;

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
