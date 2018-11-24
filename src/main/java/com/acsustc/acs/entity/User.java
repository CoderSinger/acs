package com.acsustc.acs.entity;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int userId;
    private String userName;
    private String password;
    private String phoneNumber;

    public User(String userName, String password, String phoneNumber) {
        this.password = password;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
    }


    public User(String userName, String password) {
        this.password = password;
        this.userName = userName;
    }

    public User() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
