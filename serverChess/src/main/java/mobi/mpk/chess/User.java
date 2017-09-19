package mobi.mpk.chess;

import mobi.mpk.chess.registry.RegistryAllUsers;
import mobi.mpk.chess.registry.Registry;

import java.util.Date;

public class User {

    private String name;
    private Date timeConnect;

    public User(){

        this.name = addStandartName();
        this.timeConnect = new Date();

    }

    private String addStandartName(){

        String anonymus = "Anonymus";

        Registry registry = RegistryAllUsers.getInstance();
        boolean isNameExist = registry.existName(anonymus);

        String name = anonymus;
        int i = 0;
        while (isNameExist){

            name = anonymus;
            ++i;
            name += i;

            isNameExist = registry.existName(name);

        }

        return name;
    }

    public User(String userName){
        addName(userName);
        this.timeConnect = new Date();
    }


    public String getName(){

        return this.name;

    }

    public boolean addName(String name){

        Registry registry = RegistryAllUsers.getInstance();
        boolean isNameExist = registry.existName(name);

        if(isNameExist){
            return false;
        } else {
            this.name = name;
            return true;
        }

    }

}
