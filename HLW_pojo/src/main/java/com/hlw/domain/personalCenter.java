package com.hlw.domain;

import java.util.Objects;

public class personalCenter {
    private String userName;
    private String sex;
    private String location;
    private String phoneNumber;
    private String birthday;
    private String personalDesc;
    private String email;
    private String headshot;
    private Float account;

    public personalCenter() {
    }

    public personalCenter(String userName, String sex, String location, String phoneNumber, String birthday, String personalDesc, String email, String headshot, Float account) {
        this.userName = userName;
        this.sex = sex;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.personalDesc = personalDesc;
        this.email = email;
        this.headshot = headshot;
        this.account = account;
    }

    @Override
    public String toString() {
        return "personalCenter{" +
                "userName='" + userName + '\'' +
                ", sex='" + sex + '\'' +
                ", location='" + location + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birthday='" + birthday + '\'' +
                ", personalDesc='" + personalDesc + '\'' +
                ", email='" + email + '\'' +
                ", headshot='" + headshot + '\'' +
                ", account=" + account +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPersonalDesc() {
        return personalDesc;
    }

    public void setPersonalDesc(String personalDesc) {
        this.personalDesc = personalDesc;
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
