package com.hlw.domain;

import java.util.Objects;

public class MyOrders {
    private String buyTime;
    private String orderId;
    private String goodsName;
    private String goodsType;
    private Float price;
    private String location;
    private int buyNum;
    private String userId;
    private String phoneNumber;

    public MyOrders() {
    }

    public MyOrders(String buyTime, String orderId, String goodsName, String goodsType, Float price, String location, int buyNum, String userId, String phoneNumber) {
        this.buyTime = buyTime;
        this.orderId = orderId;
        this.goodsName = goodsName;
        this.goodsType = goodsType;
        this.price = price;
        this.location = location;
        this.buyNum = buyNum;
        this.userId = userId;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "MyOrders{" +
                "buyTime='" + buyTime + '\'' +
                ", orderId='" + orderId + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsType='" + goodsType + '\'' +
                ", price=" + price +
                ", location='" + location + '\'' +
                ", buyNum=" + buyNum +
                ", userId='" + userId + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyOrders myOrders = (MyOrders) o;
        return buyNum == myOrders.buyNum && Objects.equals(buyTime, myOrders.buyTime) && Objects.equals(orderId, myOrders.orderId) && Objects.equals(goodsName, myOrders.goodsName) && Objects.equals(goodsType, myOrders.goodsType) && Objects.equals(price, myOrders.price) && Objects.equals(location, myOrders.location) && Objects.equals(userId, myOrders.userId) && Objects.equals(phoneNumber, myOrders.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buyTime, orderId, goodsName, goodsType, price, location, buyNum, userId, phoneNumber);
    }

    public String getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(String buyTime) {
        this.buyTime = buyTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(int buyNum) {
        this.buyNum = buyNum;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
