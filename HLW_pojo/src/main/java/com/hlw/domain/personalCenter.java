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
    private String headShot;
    private Float account;

    public personalCenter() {
    }

    public personalCenter(String userName, String sex, String location, String phoneNumber, String birthday, String personalDesc, String email, String headShot, Float account) {
        this.userName = userName;
        this.sex = sex;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.personalDesc = personalDesc;
        this.email = email;
        this.headShot = headShot;
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
                ", headShot='" + headShot + '\'' +
                ", account=" + account +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        personalCenter that = (personalCenter) o;
        return Objects.equals(userName, that.userName) && Objects.equals(sex, that.sex) && Objects.equals(location, that.location) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(birthday, that.birthday) && Objects.equals(personalDesc, that.personalDesc) && Objects.equals(email, that.email) && Objects.equals(headShot, that.headShot) && Objects.equals(account, that.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, sex, location, phoneNumber, birthday, personalDesc, email, headShot, account);
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

    public String getHeadShot() {
        return headShot;
    }

    public void setHeadShot(String headShot) {
        this.headShot = headShot;
    }

    public Float getAccount() {
        return account;
    }

    public void setAccount(Float account) {
        this.account = account;
    }
}
