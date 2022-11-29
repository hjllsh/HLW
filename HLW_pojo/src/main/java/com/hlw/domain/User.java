package com.hlw.domain;

import java.util.*;

public class User {
    private String userName;
    private String passWord;
    private String userId;
    private String email;
    private String headShot;

    public User() {
    }

    public User(String userName, String passWord, String userId, String email, String headShot) {
        this.userName = userName;
        this.passWord = passWord;
        this.userId = userId;
        this.email = email;
        this.headShot = headShot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName) && Objects.equals(passWord, user.passWord) && Objects.equals(userId, user.userId) && Objects.equals(email, user.email) && Objects.equals(headShot, user.headShot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, passWord, userId, email, headShot);
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", userId='" + userId + '\'' +
                ", email='" + email + '\'' +
                ", headShot='" + headShot + '\'' +
                '}';
    }

    public String getuserName() {
        return userName;
    }

    public void setuserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHeadShot() {
        return headShot;
    }

    public void setHeadShot(String headShot) {
        this.headShot = headShot;
    }
}
