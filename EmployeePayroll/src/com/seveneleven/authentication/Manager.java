package com.seveneleven.authentication;
public class Manager extends User {
    public Manager(String username,String password){
        super(username,password,"MANAGER");
    }
    public boolean authenticate(String username,String password){
        if(this.username.equals(username)){
            return passwordHash.equals(PasswordUtil.hash(password));
        }
        return false;
    }
}