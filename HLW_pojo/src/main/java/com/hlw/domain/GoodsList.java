package com.hlw.domain;


public class GoodsList {
    private String goodsName;
    private String goodsType;
    private String releaseTime;
    private Float price;
    private String storeName;
    private String location;
    private String goodsId;
    private String goodsLinkurl;
    private String goodsMainImg;

    public GoodsList() {
    }

    public GoodsList(String goodsName, String goodsType, String releaseTime, Float price, String storeName, String location, String goodsId, String goodsLinkurl, String goodsMainImg) {
        this.goodsName = goodsName;
        this.goodsType = goodsType;
        this.releaseTime = releaseTime;
        this.price = price;
        this.storeName = storeName;
        this.location = location;
        this.goodsId = goodsId;
        this.goodsLinkurl = goodsLinkurl;
        this.goodsMainImg = goodsMainImg;
    }

    @Override
    public String toString() {
        return "GoodsList{" +
                "goodsName='" + goodsName + '\'' +
                ", goodsType='" + goodsType + '\'' +
                ", releaseTime='" + releaseTime + '\'' +
                ", price=" + price +
                ", storeName='" + storeName + '\'' +
                ", location='" + location + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", goodsLinkurl='" + goodsLinkurl + '\'' +
                ", goodsMainImg='" + goodsMainImg + '\'' +
                '}';
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

    public String getGoodsLinkurl() {
        return goodsLinkurl;
    }

    public void setGoodsLinkurl(String goodsLinkurl) {
        this.goodsLinkurl = goodsLinkurl;
    }

    public String getGoodsMainImg() {
        return goodsMainImg;
    }

    public void setGoodsMainImg(String goodsMainImg) {
        this.goodsMainImg = goodsMainImg;
    }
}
