package com.hlw.domain;

import java.util.Objects;

public class myTrade {
    private String goodsName;
    private String myLocation;
    private String phoneNumber;
    private int num;
    private String transportFare;
    private Float total;
    private String orderId;

    public myTrade() {
    }

    public myTrade(String goodsName, String myLocation, String phoneNumber, int num, String transportFare, Float total, String orderId) {
        this.goodsName = goodsName;
        this.myLocation = myLocation;
        this.phoneNumber = phoneNumber;
        this.num = num;
        this.transportFare = transportFare;
        this.total = total;
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "myTrade{" +
                "goodsName='" + goodsName + '\'' +
                ", myLocation='" + myLocation + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", num=" + num +
                ", transportFare='" + transportFare + '\'' +
                ", total=" + total +
                ", orderId='" + orderId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        myTrade myTrade = (myTrade) o;
        return num == myTrade.num && Objects.equals(goodsName, myTrade.goodsName) && Objects.equals(myLocation, myTrade.myLocation) && Objects.equals(phoneNumber, myTrade.phoneNumber) && Objects.equals(transportFare, myTrade.transportFare) && Objects.equals(total, myTrade.total) && Objects.equals(orderId, myTrade.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodsName, myLocation, phoneNumber, num, transportFare, total, orderId);
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getMyLocation() {
        return myLocation;
    }

    public void setMyLocation(String myLocation) {
        this.myLocation = myLocation;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTransportFare() {
        return transportFare;
    }

    public void setTransportFare(String transportFare) {
        this.transportFare = transportFare;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
