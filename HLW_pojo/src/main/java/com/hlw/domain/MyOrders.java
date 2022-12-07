package com.hlw.domain;


public class MyOrders {
    private String buyTime;
    private String orderId;
    private String goodsName;
    private String goodsType;
    private Float totalPrice;
    private String location;
    private int buyNum;
    private String userId;
    private String isTransport;
    private String phonenumber;

    public MyOrders() {
    }

    @Override
    public String toString() {
        return "MyOrders{" +
                "buyTime='" + buyTime + '\'' +
                ", orderId='" + orderId + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsType='" + goodsType + '\'' +
                ", totalPrice=" + totalPrice +
                ", location='" + location + '\'' +
                ", buyNum=" + buyNum +
                ", userId='" + userId + '\'' +
                ", isTransport='" + isTransport + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                '}';
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

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
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

    public String getIsTransport() {
        return isTransport;
    }

    public void setIsTransport(String isTransport) {
        this.isTransport = isTransport;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public MyOrders(String buyTime, String orderId, String goodsName, String goodsType, Float totalPrice, String location, int buyNum, String userId, String isTransport, String phonenumber) {
        this.buyTime = buyTime;
        this.orderId = orderId;
        this.goodsName = goodsName;
        this.goodsType = goodsType;
        this.totalPrice = totalPrice;
        this.location = location;
        this.buyNum = buyNum;
        this.userId = userId;
        this.isTransport = isTransport;
        this.phonenumber = phonenumber;
    }
}
