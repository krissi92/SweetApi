package com.jberry.dto;

public class User {
    private String userName;
    private String password;
    private String email;
    private boolean isDiabetic;
    private int Id;


    //Constructor
    public User(String userName, String password, String email, boolean admin, boolean isLoggedIn, int id) {
        this.userName = "admin";
        this.password = "admin";
        this.email = "a@a.is";
        this.Id = 1337;
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
    public int getId() {
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
    public void setId(int id) {
        Id = id;
    }

    public boolean isDiabetic() {return isDiabetic;}
    public void setDiabetic(boolean isDiabetic) {this.isDiabetic = isDiabetic;}
}
