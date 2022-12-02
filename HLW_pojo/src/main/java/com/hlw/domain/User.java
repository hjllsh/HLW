package com.hlw.domain;



public class User {
    private String userName;
    private String password;
    private String userId;
    private String email;
    private String headshot;
    private Float account;
    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userId='" + userId + '\'' +
                ", email='" + email + '\'' +
                ", headshot='" + headshot + '\'' +
                ", account=" + account +
                '}';
    }

    public User(String userName, String password, String userId, String email, String headshot, Float account) {
        this.userName = userName;
        this.password = password;
        this.userId = userId;
        this.email = email;
        this.headshot = headshot;
        this.account = account;
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

    public String getHeadshot() {
        return headshot;
    }

    public void setHeadshot(String headshot) {
        this.headshot = headshot;
    }

    public Float getAccount() {
        return account;
    }

    public void setAccount(Float account) {
        this.account = account;
    }
}
