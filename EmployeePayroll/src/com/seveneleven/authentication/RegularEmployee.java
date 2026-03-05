package com.seveneleven.authentication;
public class RegularEmployee extends User {
    public RegularEmployee(String username,String password){
        super(username,password,"EMPLOYEE");
    }
    public boolean authenticate(String username,String password){
        if(this.username.equals(username)){
            return passwordHash.equals(PasswordUtil.hash(password));
        }
        return false;
    }
}