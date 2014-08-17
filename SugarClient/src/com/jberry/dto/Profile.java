package com.jberry.dto;

public class Profile {
    private String userId;
    private String userName;
    private String email;
    private String firstName;
    private String lastName;
    private long birthDay;
    private double height;
    private double weight;
    private String trainerID;
    private String sex;

    //Setters
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setBirthDay(long birthDay) {
        this.birthDay = birthDay;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public void setTrainerID(String trainerID) {
        this.trainerID = trainerID;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

    //Getters
    public String getUserId() {
        return userId;
    }
    public String getUserName() {
        return userName;
    }
    public String getEmail() {
        return email;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public long getBirthDay() {
        return birthDay;
    }
    public double getHeight() {
        return height;
    }
    public double getWeight() {
        return weight;
    }
    public String getTrainerID() {
        return trainerID;
    }
    public String getSex() {
        return sex;
    }
}
