package net;


import static net.Server.getUserList;

public class User {

    private String name = null;
    private boolean connect;

    public String getName(){
        return this.name;
    }

    public String setName(String name){

        for(User user : getUserList()){

            if(user.getName().equals(name)){
                return "Имя уже существует";
            }

        }

        this.name = name;

        return "Ваше имя: " + this.name;

    }

    public boolean equals(User user){
        if(this.name != null && this.name.equals(user.getName())){
            return true;
        } else {
            return false;
        }
    }

    public boolean getConnect(){ return this.connect; }

    public void setConnect(boolean connect) {
        this.connect = connect;
    }
}
