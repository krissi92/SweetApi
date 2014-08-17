package com.jberry.dto;

public class User {
    private String Id;
    private String userName;
    private String password;
    private String email;

    //Made the class Singleton.
    private User(){ }
    private static User usr;
    public static User getTheUser(){
        if (usr == null){
            usr = new User();
        }
        return usr;
    }

    //Getters
    public String getUserName() {
        return userName;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }
    public String getId() {
        return Id;
    }

    //Setters
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setId(String id) {
        Id = id;
    }
}
