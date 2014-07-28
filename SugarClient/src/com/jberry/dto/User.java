package com.jberry.dto;

//TODO: make it private.
public class User {
    private String userName;
    private String password;
    private String email;
    private boolean admin;
    private boolean isLoggedIn;
    private int Id;

    //Constructor
    public User(String userName, String password, String email, boolean admin, boolean isLoggedIn, int id) {
        this.userName = "admin";
        this.password = "admin";
        this.email = "a@a.is";
        this.admin = true;
        this.isLoggedIn = false;
        Id = 1337;
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
    public boolean isAdmin() {
        return admin;
    }
    public boolean isLoggedIn() {
        return isLoggedIn;
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
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    public void setLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }
    public void setId(int id) {
        Id = id;
    }
}
