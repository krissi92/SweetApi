package com.jberry.dto;

/**
 * Created by Krissi on 5.8.2014.
 */
public class Profile {
    private String userId;
    private String userName;
    private String email;
    private String firstName;
    private String lastName;
    private long birthDay;
    private float height;
    private float weight;
    private String trainerID;



    public float getWeight() {return weight;}

    public void setWeight(float weight) {this.weight = weight;}
    public String getTrainerID() {return trainerID;}

    public void setTrainerID(String trainerID) {this.trainerID = trainerID;}

    public float getHeight() {return height;}

    public void setHeight(float height) {this.height = height;}

    public long getBirthDay() {return birthDay;}

    public void setBirthDay(long birthDay) {this.birthDay = birthDay;}

    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getFirstName() {return firstName;}

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getUserName() {return userName;}

    public void setUserName(String userName) {this.userName = userName;}

    public String getUserId() {return userId;}

    public void setUserId(String userId) {this.userId = userId;}
}
