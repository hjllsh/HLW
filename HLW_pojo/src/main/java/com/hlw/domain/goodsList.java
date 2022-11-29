package com.hlw.domain;

import java.util.Objects;

public class goodsList {
    private String goodsName;
    private String goodsType;
    private String releaseTime;
    private Float price;
    private String storeName;
    private String location;
    private String goodsId;

    public goodsList() {
    }

    public goodsList(String goodsName, String goodsType, String releaseTime, Float price, String storeName, String location, String goodsId) {
        this.goodsName = goodsName;
        this.goodsType = goodsType;
        this.releaseTime = releaseTime;
        this.price = price;
        this.storeName = storeName;
        this.location = location;
        this.goodsId = goodsId;
    }

    @Override
    public String toString() {
        return "goodsList{" +
                "goodsName='" + goodsName + '\'' +
                ", goodsType='" + goodsType + '\'' +
                ", releaseTime='" + releaseTime + '\'' +
                ", price=" + price +
                ", storeName='" + storeName + '\'' +
                ", location='" + location + '\'' +
                ", goodsId='" + goodsId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        goodsList goodsList = (goodsList) o;
        return Objects.equals(goodsName, goodsList.goodsName) && Objects.equals(goodsType, goodsList.goodsType) && Objects.equals(releaseTime, goodsList.releaseTime) && Objects.equals(price, goodsList.price) && Objects.equals(storeName, goodsList.storeName) && Objects.equals(location, goodsList.location) && Objects.equals(goodsId, goodsList.goodsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodsName, goodsType, releaseTime, price, storeName, location, goodsId);
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

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }
}
