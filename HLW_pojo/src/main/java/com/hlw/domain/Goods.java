package com.hlw.domain;

import java.util.Objects;

public class Goods {
    private String goodsName;
    private String goodsType;
    private String releaseTime;
    private Float price;
    private int goodsNum;
    private String phoneNumber;
    private String location;
    private String goodsDsec;
    private String goodsId;
    private String userId;

    public Goods() {
    }

    public Goods(String goodsName, String goodsType, String releaseTime, Float price, int goodsNum, String phoneNumber, String location, String goodsDsec, String goodsId, String userId) {
        this.goodsName = goodsName;
        this.goodsType = goodsType;
        this.releaseTime = releaseTime;
        this.price = price;
        this.goodsNum = goodsNum;
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.goodsDsec = goodsDsec;
        this.goodsId = goodsId;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsName='" + goodsName + '\'' +
                ", goodsType='" + goodsType + '\'' +
                ", releaseTime='" + releaseTime + '\'' +
                ", price=" + price +
                ", goodsNum=" + goodsNum +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", location='" + location + '\'' +
                ", goodsDsec='" + goodsDsec + '\'' +
                ", goodsId=" + goodsId +
                ", userId='" + userId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return goodsNum == goods.goodsNum && goodsId == goods.goodsId && Objects.equals(goodsName, goods.goodsName) && Objects.equals(goodsType, goods.goodsType) && Objects.equals(releaseTime, goods.releaseTime) && Objects.equals(price, goods.price) && Objects.equals(phoneNumber, goods.phoneNumber) && Objects.equals(location, goods.location) && Objects.equals(goodsDsec, goods.goodsDsec) && Objects.equals(userId, goods.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodsName, goodsType, releaseTime, price, goodsNum, phoneNumber, location, goodsDsec, goodsId, userId);
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

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public int getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGoodsDsec() {
        return goodsDsec;
    }

    public void setGoodsDsec(String goodsDsec) {
        this.goodsDsec = goodsDsec;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
