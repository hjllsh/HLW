package com.hlw.domain;

import java.util.Objects;

public class Store {
    private String storeName;
    private String userId;
    private String location;
    private String nationality;
    private String idCard;
    private String goodsType;

    public Store() {
    }

    public Store(String storeName, String userId, String location, String nationality, String idCard, String goodsType) {
        this.storeName = storeName;
        this.userId = userId;
        this.location = location;
        this.nationality = nationality;
        this.idCard = idCard;
        this.goodsType = goodsType;
    }

    @Override
    public String toString() {
        return "Store{" +
                "storeName='" + storeName + '\'' +
                ", userId='" + userId + '\'' +
                ", location='" + location + '\'' +
                ", nationality='" + nationality + '\'' +
                ", idCard='" + idCard + '\'' +
                ", goodsType='" + goodsType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return Objects.equals(storeName, store.storeName) && Objects.equals(userId, store.userId) && Objects.equals(location, store.location) && Objects.equals(nationality, store.nationality) && Objects.equals(idCard, store.idCard) && Objects.equals(goodsType, store.goodsType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeName, userId, location, nationality, idCard, goodsType);
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }
}
